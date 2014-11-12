/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.docker;

import java.util.HashMap;
import java.util.Map;


/**
 * Operations the Docker Component supports
 */
public enum DockerOperation {
    
    EVENTS("events", false, true,
         DockerConstants.DOCKER_INITIAL_RANGE, Long.class),        
    AUTH("auth", false, true,
         DockerConstants.DOCKER_USERNAME, String.class,
         DockerConstants.DOCKER_PASSWORD, String.class,
         DockerConstants.DOCKER_EMAIL, String.class,
         DockerConstants.DOCKER_SERVER_ADDRESS, String.class),
    INFO("info", false, true),
    PING("ping", false, true),
    VERSION("version", false, true),
    LIST_IMAGES("imagelist", false, true,
         DockerConstants.DOCKER_FILTER, String.class,
         DockerConstants.DOCKER_SHOW_ALL, Boolean.class),
    PULL_IMAGE("imagepull", false, true,
         DockerConstants.DOCKER_REGISTRY, String.class,
         DockerConstants.DOCKER_TAG, String.class,
         DockerConstants.DOCKER_REPOSITORY, String.class),
    PUSH_IMAGE("imagepush", false, true,
         DockerConstants.DOCKER_NAME, String.class,
         DockerConstants.DOCKER_USERNAME, String.class,
         DockerConstants.DOCKER_PASSWORD, String.class,
         DockerConstants.DOCKER_EMAIL, String.class,
         DockerConstants.DOCKER_SERVER_ADDRESS, String.class),
    CREATE_IMAGE("imagecreate", false, true,
         DockerConstants.DOCKER_REPOSITORY, String.class),
    SEARCH_IMAGES("imagesearch", false, true,
         DockerConstants.DOCKER_TERM, String.class),
    REMOVE_IMAGE("imageremove", false, true,
         DockerConstants.DOCKER_IMAGE_ID, String.class,
         DockerConstants.DOCKER_FORCE, Boolean.class,
         DockerConstants.DOCKER_NO_PRUNE, String.class),
    INSPECT_IMAGE("imageinspect", false, true,
         DockerConstants.DOCKER_IMAGE_ID, String.class,
         DockerConstants.DOCKER_NO_PRUNE, Boolean.class,
         DockerConstants.DOCKER_FORCE, Boolean.class),
    LIST_CONTAINERS("containerlist", false, true,
         DockerConstants.DOCKER_LIMIT, String.class,
         DockerConstants.DOCKER_SHOW_ALL, Boolean.class,
         DockerConstants.DOCKER_SHOW_SIZE, Boolean.class,
         DockerConstants.DOCKER_BEFORE, String.class,
         DockerConstants.DOCKER_SINCE, String.class),   
    WAIT_CONTAINER("containerwait", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class),
    INSPECT_CONTAINER("inspectcontainer", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class),  
    REMOVE_CONTAINER("removecontainer", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class,
         DockerConstants.DOCKER_FORCE, Boolean.class,
         DockerConstants.DOCKER_REMOVE_VOLUMES, Boolean.class),
    ATTACH_CONTAINER("containerattach", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class,
         DockerConstants.DOCKER_FOLLOW_STREAM, Boolean.class,
         DockerConstants.DOCKER_TIMESTAMPS, Boolean.class,
         DockerConstants.DOCKER_STD_OUT, Boolean.class,
         DockerConstants.DOCKER_STD_ERR, Boolean.class,
         DockerConstants.DOCKER_LOGS, Boolean.class), 
    LOG_CONTAINER("containerlog", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class,
         DockerConstants.DOCKER_FOLLOW_STREAM, Boolean.class,
         DockerConstants.DOCKER_TIMESTAMPS, Boolean.class,
         DockerConstants.DOCKER_STD_OUT, Boolean.class,
         DockerConstants.DOCKER_STD_ERR, Boolean.class,
         DockerConstants.DOCKER_TAIL, Integer.class,
         DockerConstants.DOCKER_TAIL_ALL, Boolean.class),
    CONTAINER_COPY_FILE("containercopyfile", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class,
         DockerConstants.DOCKER_RESOURCE, String.class,
         DockerConstants.DOCKER_HOST_PATH, String.class),
    DIFF_CONTAINER("containerdiff", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class),
    STOP_CONTAINER("containerstop", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class,
         DockerConstants.DOCKER_TIMEOUT, Integer.class),
    KILL_CONTAINER("containerkill", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class,
         DockerConstants.DOCKER_SIGNAL, String.class),
    RESTART_CONTAINER("containerrestart", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class,
         DockerConstants.DOCKER_TIMEOUT, Integer.class),
    TOP_CONTAINER("containertop", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class,
         DockerConstants.DOCKER_TIMEOUT, Integer.class),    
    TAG_IMAGE("imagetag", false, true,
         DockerConstants.DOCKER_IMAGE_ID, String.class,
         DockerConstants.DOCKER_REPOSITORY, String.class,
         DockerConstants.DOCKER_FORCE, Boolean.class),
    PAUSE_CONTAINER("containerpause", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class),
    UNPAUSE_CONTAINER("containerunpause", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class),
    BUILD_IMAGE("imagebuild", false, true,
         DockerConstants.DOCKER_NO_CACHE, Boolean.class,
         DockerConstants.DOCKER_REMOVE, Boolean.class,
         DockerConstants.DOCKER_QUIET, Boolean.class),
    COMMIT_CONTAINER("containercommit", false, true,
         DockerConstants.DOCKER_CONTAINER_ID, String.class,
         DockerConstants.DOCKER_REPOSITORY, String.class,
         DockerConstants.DOCKER_TAG, String.class,
         DockerConstants.DOCKER_MESSAGE, String.class,
         DockerConstants.DOCKER_AUTHOR, String.class,
         DockerConstants.DOCKER_ATTACH_STD_ERR, Boolean.class,
         DockerConstants.DOCKER_ATTACH_STD_IN, Boolean.class,
         DockerConstants.DOCKER_ATTACH_STD_OUT, Boolean.class,
         DockerConstants.DOCKER_PAUSE, Boolean.class,
         DockerConstants.DOCKER_ENV, String.class,
         DockerConstants.DOCKER_HOSTNAME, String.class,
         DockerConstants.DOCKER_MEMORY, Integer.class,
         DockerConstants.DOCKER_MEMORY_SWAP, Integer.class,
         DockerConstants.DOCKER_OPEN_STD_IN, Boolean.class,
         DockerConstants.DOCKER_PORT_SPECS, String.class,
         DockerConstants.DOCKER_STD_IN_ONCE, Boolean.class,
         DockerConstants.DOCKER_TTY, Boolean.class,
         DockerConstants.DOCKER_WORKING_DIR, String.class),
   CREATE_CONTAINER("containercreate", false, true,
         DockerConstants.DOCKER_IMAGE_ID, String.class,
         DockerConstants.DOCKER_NAME, String.class,
         DockerConstants.DOCKER_WORKING_DIR, String.class,
         DockerConstants.DOCKER_DISABLE_NETWORK, Boolean.class,
         DockerConstants.DOCKER_HOSTNAME, String.class,
         DockerConstants.DOCKER_PORT_SPECS, String.class,
         DockerConstants.DOCKER_USER, String.class,
         DockerConstants.DOCKER_TTY, Boolean.class,
         DockerConstants.DOCKER_STD_IN_OPEN, Boolean.class,
         DockerConstants.DOCKER_STD_IN_ONCE, Boolean.class,
         DockerConstants.DOCKER_MEMORY_LIMIT, Long.class,
         DockerConstants.DOCKER_MEMORY_SWAP, Long.class,
         DockerConstants.DOCKER_CPU_SHARES, Integer.class,
         DockerConstants.DOCKER_ATTACH_STD_IN, Boolean.class,
         DockerConstants.DOCKER_ATTACH_STD_OUT, Boolean.class,
         DockerConstants.DOCKER_ATTACH_STD_ERR, Boolean.class,
         DockerConstants.DOCKER_ENV, String.class,
         DockerConstants.DOCKER_CMD, String.class,
         DockerConstants.DOCKER_DNS, String.class,
         DockerConstants.DOCKER_IMAGE, String.class,
         DockerConstants.DOCKER_VOLUMES_FROM, String.class),   
    START_CONTAINER("containerstart", false, true,
         DockerConstants.DOCKER_PUBLISH_ALL_PORTS, Boolean.class,
         DockerConstants.DOCKER_PRIVILEGED, Boolean.class,
         DockerConstants.DOCKER_DNS, String.class,
         DockerConstants.DOCKER_DNS_SEARCH, String.class,
         DockerConstants.DOCKER_CONTAINER_ID, String.class,
         DockerConstants.DOCKER_VOLUMES_FROM, String.class,
         DockerConstants.DOCKER_NETWORK_MODE, String.class,
         DockerConstants.DOCKER_CAP_ADD, String.class,
         DockerConstants.DOCKER_CAP_DROP, String.class);
    
    
    private String text;
    private boolean canConsume;
    private boolean canProduce;
    private Map<String, Class<?>> parameters;
    
    
    private DockerOperation(String text, boolean canConsume, boolean canProduce, Object... params) {
        
        this.text = text;
        this.canConsume = canConsume;
        this.canProduce = canProduce;
        
        parameters = new HashMap<String, Class<?>>();
              
        if (params.length > 0) {
            
            if (params.length % 2 != 0) {
                throw new IllegalArgumentException("Invalid parameter list, "
                    + "must be of the form 'String name1, Class class1, String name2, Class class2...");
            }
            
            int nParameters = params.length / 2;
            
            for (int i = 0; i < nParameters; i++) {
                parameters.put((String) params[i * 2], (Class<?>) params[i * 2 + 1]);
            }
        }

    }
    
    @Override
    public String toString() {
        return text;
    }
    
    public boolean canConsume() {
        return canConsume;
    }
    
    public boolean canProduce() {
        return canProduce;
    }
    
    public Map<String, Class<?>> getParameters() {
        return parameters;
    }
    
    public static DockerOperation getDockerOperation(String name) {
        for (DockerOperation dockerOperation : DockerOperation.values()) {
            if (dockerOperation.toString().equals(name)) {
                return dockerOperation;
            }
        }
        
        return null;
    }

}