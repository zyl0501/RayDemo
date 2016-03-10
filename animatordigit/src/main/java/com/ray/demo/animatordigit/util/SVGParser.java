package com.ray.demo.animatordigit.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by ziby on 26/08/15.
 */
public class SVGParser {

  /**
   * Check if file is an SVG
   */
  public static boolean isSVGImage(File f) {
    try {
      System.out.println("Checking if " + f.getAbsolutePath() + " is an SVG file...");
      Document document = getXMLDocumentFromFile(f);
      boolean headerSVG = document.getDoctype() != null && document.getDoctype()
          .getName()
          .toLowerCase()
          .equals("svg");
      if (headerSVG) {
        return true;
      } else {
        return document.getElementsByTagName("svg") != null;
      }
    } catch (Exception e) {
    }

    return false;
  }

  /**
   * Parse path elements of an SVG file into a single big path sequence.
   */
  public static String getPathDataFromSVGFile(File f) {
    try {
      StringBuilder sb = new StringBuilder();
      Document document = getXMLDocumentFromFile(f);
      NodeList nList = document.getElementsByTagName("path");
      for (int i = 0; i < nList.getLength(); i++) {
        Element e = (Element) nList.item(i);
        sb.append(e.getAttribute("d"));
      }

      return sb.toString();
    } catch (Exception e) {
    }

    return null;
  }

  private static Document getXMLDocumentFromFile(File f)
      throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(false);
    factory.setValidating(false);
    factory.setFeature("http://xml.org/sax/features/namespaces", false);
    factory.setFeature("http://xml.org/sax/features/validation", false);
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
    factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
    DocumentBuilder builder = null;
    builder = factory.newDocumentBuilder();
    Document document = builder.parse(f);
    return document;
  }
}
