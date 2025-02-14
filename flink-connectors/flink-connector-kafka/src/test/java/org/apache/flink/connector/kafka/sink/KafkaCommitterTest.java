/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.connector.kafka.sink;

import org.apache.flink.util.TestLogger;

import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

/** Tests for {@link KafkaCommitter}. */
public class KafkaCommitterTest extends TestLogger {

    @Test
    public void testRetryCommittableOnFailure() throws IOException {
        final KafkaCommitter committer = new KafkaCommitter(new Properties());
        final short epoch = 0;
        final List<KafkaCommittable> committables =
                Collections.singletonList(new KafkaCommittable(0, epoch, "transactionalId", null));
        assertEquals(committables, committer.commit(committables));
    }
}
