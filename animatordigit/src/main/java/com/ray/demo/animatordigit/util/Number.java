/*
 * Copyright 2016 eneim@Eneim Labs, nam@ene.im
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ray.demo.animatordigit.util;

import android.util.Pair;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by eneim on 3/4/16.
 */
public enum Number {
  ZERO(PathDataSource.SRC_ZERO),
  ONE(PathDataSource.SRC_ONE),
  TWO(PathDataSource.SRC_TWO),
  THREE(PathDataSource.SRC_THREE),
  FOUR(PathDataSource.SRC_FOUR),
  FIVE(PathDataSource.SRC_FIVE),
  SIX(PathDataSource.SRC_SIX),
  SEVEN(PathDataSource.SRC_SEVEN),
  EIGHT(PathDataSource.SRC_EIGHT),
  NINE(PathDataSource.SRC_NINE);

  public static final Number[] VALUES = {
      ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
  };

  private static final Map<Number, PathParser.PathDataNode[]> sCache = new ConcurrentHashMap<>();
  private static final Map<Pair<Number, Number>, Pair<String, String>> sPairs =
      new ConcurrentHashMap<>();
  final String pathData;

  Number(String pathData) {
    this.pathData = pathData;
  }

  public static PathParser.PathDataNode[] getNodes(Number number) {
    PathParser.PathDataNode[] nodes = sCache.get(number);
    if (nodes == null) {
      nodes = PathParser.createNodesFromPathData(number.pathData);
      sCache.put(number, nodes);
    }

    return nodes;
  }

  public static Pair<String, String> alignNumbers(Pair<Number, Number> source) {
    Pair<String, String> data = sPairs.get(source);
    if (data == null) {
      String[] temp =
          VectAlign.align(source.first.pathData, source.second.pathData, VectAlign.Mode.BASE);
      if (temp == null || temp.length != 2) {
        throw new IllegalStateException("Something is wrong here!");
      }

      data = new Pair<>(temp[0], temp[1]);
      sPairs.put(source, data);
    }

    return data;
  }
}
