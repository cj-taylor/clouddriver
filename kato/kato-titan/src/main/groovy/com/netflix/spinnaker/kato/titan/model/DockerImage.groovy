/*
 * Copyright 2015 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.kato.titan.model

/**
 * @author sthadeshwar
 */
class DockerImage {
  String imageName
  String imageVersion

  static class DockerImageResolver {

    private static final String IMAGE_NAME_SEPARATOR = ":"

    /**
     * Docker Image registered: e703cdfcd21a as dockerregistry.us-east-1.dyntest.netflix.net:7001/engtools.dockerfile-test:master-201506020033-trusty-7366606
     * @param image
     * @return
     */
    static DockerImage resolveImage(String image) {
      String[] imageNameParts = image.split(IMAGE_NAME_SEPARATOR)
      return new DockerImage(
        imageName: imageNameParts[0],
        imageVersion: imageNameParts[1]
      )
    }
  }
}
