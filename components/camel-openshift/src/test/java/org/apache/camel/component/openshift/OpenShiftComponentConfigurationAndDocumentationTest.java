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
package org.apache.camel.component.openshift;

import org.apache.camel.CamelContext;
import org.apache.camel.ComponentConfiguration;
import org.apache.camel.EndpointConfiguration;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class OpenShiftComponentConfigurationAndDocumentationTest extends CamelTestSupport {

    @Override
    public boolean isUseRouteBuilder() {
        return false;
    }

    @Test
    public void testComponentConfiguration() throws Exception {
        OpenShiftComponent comp = context.getComponent("openshift", OpenShiftComponent.class);
        EndpointConfiguration conf = comp.createConfiguration("openshift:myApp?username=foo&password=secret&operation=list");

        assertEquals("foo", conf.getParameter("username"));
        assertEquals("secret", conf.getParameter("password"));

        ComponentConfiguration compConf = comp.createComponentConfiguration();
        String json = compConf.createParameterJsonSchema();
        assertNotNull(json);

        assertTrue(json.contains("\"application\": { \"kind\": \"parameter\", \"type\": \"string\""));
        assertTrue(json.contains("\"clientId\": { \"kind\": \"parameter\", \"type\": \"string\""));
        assertTrue(json.contains("\"operation\": { \"kind\": \"parameter\", \"type\": \"string\""));
    }

    @Test
    public void testComponentDocumentation() throws Exception {
        CamelContext context = new DefaultCamelContext();
        String html = context.getComponentDocumentation("openshift");
        assertNotNull("Should have found some auto-generated HTML", html);
    }

}
