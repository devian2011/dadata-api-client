/*
 * Copyright (c) 2018 Boris Fox, REDCOM-Internet CJSC
 * All rights reserved.
 */

package ru.redcom.lib.integration.api.client.dadata.IntegrationTests.live;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;
import ru.redcom.lib.integration.api.client.dadata.DaDataClient;
import ru.redcom.lib.integration.api.client.dadata.DaDataException;
import ru.redcom.lib.integration.api.client.dadata.IntegrationTests.TestCasesSuccessComposite;

import static ru.redcom.lib.integration.api.client.dadata.IntegrationTests.TestCasesSuccessComposite.successTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonLive.class)
@IfProfileValue(name = "live-tests", value = "enabled")
public class UT55CompositeCleanSuccess {

	@Autowired
	private DaDataClient dadata;


	@Test
	public void cleanSamplesFull() throws DaDataException {
		test(TestCasesSuccessComposite.SampleComposite.SAMPLES_FULL);
	}

	@Test
	public void cleanSamplesGaps() throws DaDataException {
		test(TestCasesSuccessComposite.SampleComposite.SAMPLES_GAPS);
	}

	// -----------------------------------------------------------------------------------------------------------------

	// shared test body
	private void test(final TestCasesSuccessComposite.SampleComposite sample) {
		successTest(dadata, sample.getRequest(), sample.getResponseMatcher());
	}
}
