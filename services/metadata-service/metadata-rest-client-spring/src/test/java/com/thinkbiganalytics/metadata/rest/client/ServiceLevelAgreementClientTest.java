/**
 *
 */
package com.thinkbiganalytics.metadata.rest.client;

/*-
 * #%L
 * thinkbig-metadata-rest-client-spring
 * %%
 * Copyright (C) 2017 ThinkBig Analytics
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.thinkbiganalytics.metadata.api.sla.FeedExecutedSinceFeed;
import com.thinkbiganalytics.metadata.rest.model.sla.ServiceLevelAgreement;

import org.junit.BeforeClass;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * A test case for service level agreements
 */
public class ServiceLevelAgreementClientTest {

    private static MetadataClient client;

    @BeforeClass
    public static void connect() {
        client = new MetadataClient(URI.create("http://localhost:8077/api/v1/metadata/"));
    }

    //    @Test
    public void testCreateSLA() {
        ServiceLevelAgreement sla = new ServiceLevelAgreement("TestSLA1",
                                                              new FeedExecutedSinceFeed("category", "FeedA", "category", "FeedX"),
                                                              new FeedExecutedSinceFeed("category", "FeedB", "category", "FeedX"));

        ServiceLevelAgreement result = client.createSla(sla);

        assertThat(result).isNotNull();
    }
}
