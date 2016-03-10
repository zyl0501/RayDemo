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

/**
 * Created by eneim on 3/4/16.
 */
final class PathDataSource {

  static final String SRC_ZERO = "M66,130 C101.227,129.927 129.906,101.221 130,66 "
      + "C129.915,30.778 101.223,2.084 66,2 C30.829,2.143 2.085,30.815 2,66 "
      + "C2.106,101.182 30.821,129.882 66,130 L66,130 Z";

  static final String SRC_ONE = "M50,2 L80.813,2 L80.813,130 L50,130 L50,2 Z";

  static final String SRC_TWO =
      "M108.405,130.00025 L41.001,130.00025 C41.001,130.00025 50.923,121.62325 56.738,116.75025 "
          + "C63.061,111.45125 70.487,105.29925 88.19,87.5072496 "
          + "C92.017,83.6612496 95.074,80.2632496 97.519,77.1732496 "
          + "C106.07,66.2152496 107.203,58.7102496 107.492,49.1482496 "
          + "C107.884,36.2052496 94.156,19.1432496 70.997,20.8092496 "
          + "C47.838,22.4752496 41.001,44.1302496 41.001,44.1302496 L23,25.4352496 "
          + "C23,25.4352496 29.837,3.77924956 52.996,2.11324956 "
          + "C76.155,0.447249557 89.884,17.5092496 89.492,30.4532496 "
          + "C89.117,42.8092496 87.892,51.0202496 70.189,68.8122496 "
          + "C67.6,71.4142496 65.215,73.7782496 63.007,75.9352496 "
          + "C50.439,88.1872496 43.254,94.1232496 37.925,98.5882496 "
          + "C32.109,103.46125 23,111.30525 23,111.30525 L91.071,111.30525 "
          + "L108.405,130.00025 L108.405,130.00025 Z";

  static final String SRC_THREE =
      "M39.564,103.813841 C39.564,103.813841 42.569,113.480841 50.837,121.521841 "
          + "C59.785,130.223841 78.949,133.532841 92.833,125.147841 "
          + "C106.053,117.162841 111.102,100.370841 107.965,89.248841 "
          + "C103.759,74.335841 91.315,72.002841 91.315,72.002841 "
          + "C91.315,72.002841 92.96,70.883841 94.142,69.998841 "
          + "C98.03,66.857841 104.552,60.038841 104.552,49.632841 "
          + "C104.552,34.806841 93.604,27.072841 89.304,24.481841 "
          + "C85.004,21.890841 76.109,18.566841 62.175,22.279841 "
          + "C48.243,25.991841 41.695,42.322841 41.695,42.322841 "
          + "L24.13,23.779841 C24.13,23.779841 29.895,8.18284098 44.611,3.73684098 "
          + "C58.414,-0.434159025 68.298,3.88784098 72.598,6.47884098 "
          + "C76.898,9.06984098 87.352,17.082841 87.444,31.890841 "
          + "C87.537,46.715841 73.75,53.459841 73.75,53.459841 "
          + "C73.75,53.459841 78.273,56.147841 82.682,60.313841 "
          + "C86.38,64.100841 90.965,70.154841 90.965,75.162841 "
          + "C90.965,86.634841 87.699,98.234841 75.225,106.459841 "
          + "C61.977,115.196841 41.427,111.134841 33.272,102.978841 "
          + "C25.117,94.823841 22,85.270841 22,85.270841 L39.564,103.813841 L39.564,103.813841 Z";

  static final String SRC_FOUR =
      "M115.548,107.092 L35.208,107.092 L35.208,95.956 L85.64,21.185 L101.548,21.185 L101.548,130 "
          + "L83.34,110.816 L83.34,2 L67.431,2 L17,76.772 L17,87.908 L59.192,87.908 "
          + "L97.339,87.908 L115.548,107.092 L115.548,107.092 Z";

  static final String SRC_FIVE =
      "M20,82.333 L37.854,101.143 C37.854,101.143 41.693,111.223 42.561,112.722 "
          + "C43.428,114.22 53.155,130 73.887,130 C94.617,130 110.699,113.738 110.699,94.124 "
          + "C110.699,74.51 93.911,58.874 75.297,58.874 C74.484,58.874 71.726,59.104 70.926,59.163 "
          + "C54.333,61.326 41.285,74.937 41.285,74.937 L48.148,20.811 L104.147,20.811 L86.294,2 "
          + "L30.295,2 L23.433,56.127 C23.433,56.127 37.634,42.727 53.865,40.258 "
          + "C55.042,40.132 56.236,40.064 57.443,40.064 C76.058,40.064 92.846,55.7 92.846,75.314 "
          + "C92.846,94.927 76.764,111.19 56.033,111.19 C35.303,111.19 25.574,95.41 24.707,93.911 "
          + "C23.84,92.413 20,82.333 20,82.333 L20,82.333 Z";

  static final String SRC_SIX =
      "M65.5539859,62.744 C65.5539859,62.744 69.6309859,61.961 70.0629859,61.856 L69.6149859,61.92 "
          + "C74.0449859,61.286 82.1309859,60.034 91.8249859,64.436 "
          + "C106.476986,71.089 110.698986,85.554 110.164986,96.23 "
          + "C109.657986,106.389 100.142986,125.209 81.1049859,129.214 "
          + "C77.3909859,129.995 73.8059859,130.173 70.3969859,129.842 "
          + "C56.7889859,128.119 45.1409859,118.156 40.4789859,106.321 "
          + "C34.5499859,91.272 43.3629859,75.207 46.8829859,68.504 "
          + "C50.4049859,61.8 79.1519859,20.424 79.1519859,20.424 L68.2259859,8.909 "
          + "L61.6709859,2 C61.6709859,2 32.9249859,43.376 29.4039859,50.08 "
          + "C25.8819859,56.783 17.0699859,72.848 22.9979859,87.898 "
          + "C28.3839859,101.569 43.1609859,112.483 59.8459859,111.385 "
          + "C61.0889859,111.255 62.3499859,111.058 63.6249859,110.79 "
          + "C82.6629859,106.785 92.1779859,87.965 92.6849859,77.806 "
          + "C93.2179859,67.13 88.9959859,52.665 74.3449859,46.012 "
          + "C61.8659859,40.345 48.0739859,44.32 48.0739859,44.32 "
          + "L65.5539859,62.744 L65.5539859,62.744 Z";

  static final String SRC_SEVEN =
      "M56.855,130 L108.642,35.473 L108.642,20.81 L39.853,20.81 L22,2 L58,2 L90.789,2 "
          + "L90.789,16.662 L39.001,111.19 L56.855,130 L56.855,130 Z";

  static final String SRC_EIGHT = "M25.701,82.8 C26.544,80.777 28.242,77.209 29.542,75.385 "
      + "C33.234,70.201 38.061,66.12 44.022,63.139 L44.022,62.424 "
      + "C39.374,59.446 35.558,55.662 32.58,51.072 C29.6,46.486 28.111,41.687 28.111,36.681 "
      + "C28.111,29.842 30.73,22.395 34.093,17.122 C35.4,15.288 36.923,13.555 38.659,11.922 "
      + "C45.689,5.307 54.628,2 65.474,2 C76.318,2 85.257,5.307 92.291,11.922 "
      + "C99.321,18.536 102.838,26.79 102.838,36.681 "
      + "C102.838,38.937 102.535,41.15 101.93,43.321 "
      + "C101.197,45.394 99.663,49.079 98.369,51.072 "
      + "C95.388,55.662 91.575,59.446 86.928,62.424 L86.928,63.139 "
      + "C92.885,66.12 97.712,70.201 101.407,75.385 "
      + "C105.1,80.569 106.949,86.558 106.949,93.352 "
      + "C106.949,101.189 103.43,109.593 98.869,115.524 "
      + "C97.697,116.886 96.398,118.196 94.972,119.452 C86.986,126.485 77.153,130 65.474,130 "
      + "C53.793,130 43.961,126.485 35.977,119.452 C27.991,112.421 24,103.72 24,93.352 "
      + "C24,89.588 24.566,86.07 25.701,82.8 L25.701,82.8 Z";

  static final String SRC_NINE = "M62.9830112,123.091342 L69.5380112,130.000342 "
      + "C69.5380112,130.000342 98.2840112,88.6243418 101.805011,81.9203418 "
      + "C105.327011,75.2173418 114.139011,59.1523418 108.211011,44.1023418 "
      + "C102.825011,30.4313418 88.0470112,19.5173418 71.3630112,20.6153418 "
      + "C70.1200112,20.7453418 68.8590112,20.9423418 67.5840112,21.2103418 "
      + "C48.5450112,25.2153418 39.0310112,44.0353418 38.5240112,54.1943418 "
      + "C37.9910112,64.8703418 42.2120112,79.3353418 56.8640112,85.9883418 "
      + "C69.3430112,91.6553418 83.1350112,87.6803418 83.1350112,87.6803418 "
      + "L65.6550112,69.2563418 C65.6550112,69.2563418 61.5780112,70.0393418 61.1460112,70.1443418 "
      + "L61.5940112,70.0803418 C57.1640112,70.7143418 49.0780112,71.9663418 39.3840112,67.5643418 "
      + "C24.7320112,60.9113418 20.5100112,46.4463418 21.0440112,35.7703418 "
      + "C21.5500112,25.6113418 31.0660112,6.79134177 50.1040112,2.78634177 "
      + "C53.8170112,2.00534177 57.4030112,1.82734177 60.8120112,2.15834177 "
      + "C74.4200112,3.88134177 86.0680112,13.8443418 90.7300112,25.6793418 "
      + "C96.6590112,40.7283418 87.8460112,56.7933418 84.3260112,63.4973418 "
      + "C80.8040112,70.2003418 52.0570112,111.576342 52.0570112,111.576342 "
      + "L62.9830112,123.091342 L62.9830112,123.091342 Z";
}
