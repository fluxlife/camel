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
package org.apache.camel.commands;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.ExplicitCamelContextNameStrategy;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextListCommandTest extends TestCase {

    private static final Logger LOG = LoggerFactory.getLogger(ContextListCommandTest.class);

    @Test
    public void testContextList() throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.setNameStrategy(new ExplicitCamelContextNameStrategy("foobar"));
        context.start();

        CamelController controller = new DummyCamelController(context);

        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);

        ContextListCommand command = new ContextListCommand();
        command.execute(controller, ps, null);

        String out = os.toString();
        assertNotNull(out);
        LOG.info("\n\n{}\n", out);

        // should contain a table with the context
        assertTrue(out.contains("foobar"));
        assertTrue(out.contains("Started"));

        context.stop();
    }

}
