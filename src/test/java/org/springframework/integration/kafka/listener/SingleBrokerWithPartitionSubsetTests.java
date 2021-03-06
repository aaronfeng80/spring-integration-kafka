/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.springframework.integration.kafka.listener;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import org.springframework.integration.kafka.rule.KafkaEmbedded;

/**
 * @author Marius Bogoevici
 */
public class SingleBrokerWithPartitionSubsetTests extends AbstractMessageListenerContainerTests {

	@Rule
	public final KafkaEmbedded kafkaEmbeddedBrokerRule = new KafkaEmbedded(1);

	@Override
	public KafkaEmbedded getKafkaRule() {
		return kafkaEmbeddedBrokerRule;
	}

	@Test
	public void testLowVolumeLowConcurrency() throws Exception {
		createTopic(TEST_TOPIC, 4, 1, 1);
		runMessageListenerTest(100, 2, 4, 100, 2, "none", TEST_TOPIC);
	}

	@Test
	@Ignore
	public void testMediumVolumeLowConcurrency() throws Exception {
		createTopic(TEST_TOPIC, 4, 1, 1);
		runMessageListenerTest(100, 2, 4, 1000, 2, "none", TEST_TOPIC);
	}

	@Test
	@Ignore
	public void testHighVolumeLowConcurrency() throws Exception {
		createTopic(TEST_TOPIC, 4, 1, 1);
		runMessageListenerTest(100, 2, 4, 10000, 2, "none", TEST_TOPIC);
	}

	@Test
	@Ignore
	public void testLowVolumeMediumConcurrency() throws Exception {
		createTopic(TEST_TOPIC, 10, 1, 1);
		runMessageListenerTest(100, 5, 10, 100, 2, "none", TEST_TOPIC);
	}

	@Test
	@Ignore
	public void testMediumVolumeMediumConcurrency() throws Exception {
		createTopic(TEST_TOPIC, 10, 1, 1);
		runMessageListenerTest(100, 5, 10, 1000, 2, "none", TEST_TOPIC);
	}

	@Test
	@Ignore
	public void testHighVolumeMediumConcurrency() throws Exception {
		createTopic(TEST_TOPIC, 10, 1, 1);
		runMessageListenerTest(100, 5, 10, 100000, 2, "none", TEST_TOPIC);
	}


	@Test
	@Ignore
	public void testLowVolumeHighConcurrency() throws Exception {
		createTopic(TEST_TOPIC, 100, 1, 1);
		runMessageListenerTest(100, 20, 100, 1000, 2, "none", TEST_TOPIC);
	}

	@Test
	@Ignore
	public void testMediumVolumeHighConcurrency() throws Exception {
		createTopic(TEST_TOPIC, 100, 1, 1);
		runMessageListenerTest(100, 20, 100, 10000, 2, "none", TEST_TOPIC);
	}

	@Test
	@Ignore
	public void testHighVolumeHighConcurrency() throws Exception {
		createTopic(TEST_TOPIC, 100, 1, 1);
		runMessageListenerTest(100, 20, 100, 100000, 2, "none", TEST_TOPIC);
	}


}
