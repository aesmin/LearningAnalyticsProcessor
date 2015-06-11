/**
 * Copyright 2013 Unicon (R) Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.apereo.lap.controllers;

import junit.framework.Assert;
import org.apereo.lap.services.ConfigurationService;
import org.apereo.lap.services.ProcessingManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.junit.Assert.assertNotNull;

@ContextConfiguration({ "classpath:test-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class HomeControllerTest {

    @Autowired
    ConfigurationService config;

    @Autowired
    ProcessingManagerService pms;

    @Test
    public void testController() {
        assertNotNull(config);
        assertNotNull(pms);
        HomeController controller = new HomeController();
        controller.configuration = config;
        controller.processingManagerService = pms;
        Model model = new ExtendedModelMap();
        Assert.assertEquals("home", controller.home(model));

        Object dev = model.asMap().get("dev");
        Assert.assertEquals("AZ", dev);
    }

}
