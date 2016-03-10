package com.ray.demo.animatordigit.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by ziby on 07/08/15.
 */
public class PathNodeUtils {

  public static final char CMD_PLACEHOLDER = '#';
  public static final char CMD_DUMB = 'D';

  /**
   * Return the number of arguments expected for a specific command
   */
  static int commandArguments(char type) {
    switch (type) {
      case CMD_PLACEHOLDER:
      case 'z':
      case 'Z':
        return 0;
      case 'm':
      case 'M':
      case 'l':
      case 'L':
      case 't':
      case 'T':
        return 2;
      case 'h':
      case 'H':
      case 'v':
      case 'V':
        return 1;
      case 'c':
      case 'C':
        return 6;
      case 's':
      case 'S':
      case 'q':
      case 'Q':
        return 4;
      case 'a':
      case 'A':
        return 7;
    }
    return -1;
  }

  /**
   * Check if the given node sequences are equivalent (in terms of incremental graphic commands).
   * //FIXME this is an approximated method
   */
  public static boolean isEquivalent(ArrayList<PathParser.PathDataNode> original,
      ArrayList<PathParser.PathDataNode> alternative) {
    int innerStart = 0;
    for (PathParser.PathDataNode o : original) {
      boolean found = false;
      for (int i = innerStart; i < alternative.size() && !found; i++) {
        PathParser.PathDataNode n = alternative.get(i);
        if ((o.type == n.type && Arrays.equals(o.params, n.params)) || ((o.type == 'Z'
            || o.type == 'z') && n.type == 'L' /*transformZ*/)) {
          found = true;
          innerStart = i + 1;
        }
      }

      if (!found) return false;
    }

    return true;
  }

  public static ArrayList<PathParser.PathDataNode> transform(PathParser.PathDataNode[] elements) {
    return transform(elements, 0, true);
  }

  /**
   * Transform the input list. Expand (eventually) compressed element and create extra copy if
   * needed.
   */
  public static ArrayList<PathParser.PathDataNode> transform(PathParser.PathDataNode[] elements,
      int extraCopy, boolean transformZ) {
    if (elements == null) return null;

    ArrayList<PathParser.PathDataNode> transformed = new ArrayList<>();
    for (PathParser.PathDataNode node : elements) {

      int cmdArgs = commandArguments(node.type);
      int argsProvided = node.params.length;

      if (node.type == 'z') node.type = 'Z';

      if (cmdArgs == -1) {
        System.err.println("Command not supported! " + node.type);
      } else if (argsProvided < cmdArgs) {
        System.err.println("Command "
            + node.type
            + " requires "
            + cmdArgs
            + " params! Passing only "
            + argsProvided);
      } else if (cmdArgs == node.params.length) {
        //Normal command with the exact number of params
        transformed.add(node);
        if (extraCopy > 0
            && (transformZ || node.type != 'Z')
            && node.type != PathNodeUtils.CMD_DUMB) { //never add extra z/Z or dumb commands
          PathParser.PathDataNode extraNodes = new PathParser.PathDataNode(node);
          if (Character.isLowerCase(
              node.type)) { // this is a relative movement. If we want to create extra nodes, we need to create neutral relative commands
            Arrays.fill(extraNodes.params, 0.0f); //FIXME is good?
          }

          for (int j = 0; j < extraCopy; j++)
            transformed.add(extraNodes);
        }
      } else {
        //Multiple groups of params, verify consistency
        int mod = (argsProvided % cmdArgs);
        if (mod != 0) {
          System.err.println("Providing multiple groups of params for command "
              + node.type
              + ", but in wrong number (missing "
              + mod
              + " args)");
        } else {
          //Create multiple nodes
          int iter = argsProvided / cmdArgs;
          for (int i = 0; i < iter; i++) {
            PathParser.PathDataNode newNode = new PathParser.PathDataNode(node.type,
                PathParser.copyOfRange(node.params, i * cmdArgs, (i + 1) * cmdArgs));
            transformed.add(newNode);

            if (extraCopy > 0) {
              PathParser.PathDataNode extraNodes = new PathParser.PathDataNode(newNode);
              ;
              if (Character.isLowerCase(
                  newNode.type)) { // this is a relative movement. If we want to create extra nodes, we need to create neutral relative commands
                Arrays.fill(extraNodes.params, 0.0f); //FIXME is good?
              }

              for (int j = 0; j < extraCopy; j++)
                transformed.add(extraNodes);
            }
          }
        }
      }
    }

    if (transformZ) {
      float[][] penPos = PathNodeUtils.calculatePenPosition(transformed);
      int i = 0;
      for (PathParser.PathDataNode node : transformed) {
        if (node.type == 'Z') {
          node.type = 'L';
          node.params = penPos[i];
        }
        i++;
      }
    }

    return transformed;
  }

  /**
   * Simplify eventually useless nodes
   */
  static void simplify(ArrayList<PathParser.PathDataNode> from,
      ArrayList<PathParser.PathDataNode> to) {
    if (from.size() != to.size()) {
      System.err.println("Cannot simplify lists of nodes of different sizes");
      return;
    }

    System.out.println("Simplify lists with size " + from.size());

    boolean removeIndexes[] = new boolean[from.size()];
    int last = from.size() - 1; //avoid last

    for (int i = 0; i < last; i++) {
      if (from.get(i).isEqual(from.get(i + 1)) && to.get(i).isEqual(to.get(i + 1))) {
        removeIndexes[i] = true;
      }
    }

    Iterator iterators[] = new Iterator[] { from.iterator(), to.iterator() };
    for (Iterator it : iterators) {
      int i = 0;
      while (it.hasNext()) {
        it.next();
        if (removeIndexes[i++]) it.remove();
      }
    }

    System.out.println("Final size after simplify is " + from.size());
  }

  public static float[][] calculatePenPosition(ArrayList<PathParser.PathDataNode> sequence) {
    float penPos[][] = new float[sequence.size()][2];

    float[] lastStart = new float[] { 0, 0 };
    float currentX = 0;
    float currentY = 0;
    boolean saveNewStart = false;

    for (int i = 0; i < sequence.size(); i++) {
      PathParser.PathDataNode node = sequence.get(i);
      if (node.type == 'z' || node.type == 'Z') { //Close path and restart from last start
        currentX = lastStart[0];
        currentY = lastStart[1];
        saveNewStart = true;
      } else {
        float[] positionFromParams = getPositionFromParams(node);
        if (positionFromParams != null) {
          if (Character.isLowerCase(
              node.type)) { //relative movement (it's already correct in case of 'v' or 'h'
            currentX += positionFromParams[0];
            currentY += positionFromParams[1];
          } else { //absolute movement
            if (i > 0 && node.type == 'V') {
              currentX = penPos[i - 1][0];
              currentY = positionFromParams[1];
            } else if (i > 0 && node.type == 'H') {
              currentX = positionFromParams[0];
              currentY = penPos[i - 1][1];
            } else {
              currentX = positionFromParams[0];
              currentY = positionFromParams[1];
            }
          }

          if (node.type == 'm' || node.type == 'M') {
            saveNewStart = true;
          }

          if (saveNewStart) {
            lastStart = new float[] { currentX, currentY };
            saveNewStart = false;
          }
        }
      }

      penPos[i][0] = currentX;
      penPos[i][1] = currentY;
    }

    return penPos;
  }

  static float[] getPositionFromParams(PathParser.PathDataNode node) {
    if (node == null || node.params == null || node.params.length == 0) return null;

    float[] ris = new float[2];

    if (Character.toLowerCase(node.type) == 'v') {
      ris[1] = node.params[0];
    } else if (Character.toLowerCase(node.type) == 'h') {
      ris[0] = node.params[0];
    } else {
      ris[0] = node.params[node.params.length - 2];
      ris[1] = node.params[node.params.length - 1];
    }
    return ris;
  }

  /**
   * Create a VectorDrawable sequence from a list of nodes
   */
  public static String pathNodesToString(ArrayList<PathParser.PathDataNode> nodes,
      boolean onlyCommands) {

    //Format float to avoid scientific notation
    DecimalFormat floatFormatter = new DecimalFormat("###.#########");

    StringBuilder sb = new StringBuilder();
    for (PathParser.PathDataNode n : nodes) {
      sb.append(n.type);
      sb.append(' ');
      if (!onlyCommands) {
        for (float p : n.params) {
          if (("" + p).contains("e") || ("" + p).contains("E")) //apply decimal format only for scientific notation number
          {
            sb.append(floatFormatter.format(p));
          } else {
            sb.append(p);
          }

          sb.append(',');
        }
        sb.replace(sb.length() - 1, sb.length(), " ");
      }
    }
    return sb.toString();
  }

  public static String pathNodesToString(ArrayList<PathParser.PathDataNode> nodes) {
    return pathNodesToString(nodes, false);
  }
}
