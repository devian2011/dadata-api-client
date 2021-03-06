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

import static ru.redcom.lib.integration.api.client.dadata.IntegrationTests.TestCasesSuccessPhone.SamplePhones;
import static ru.redcom.lib.integration.api.client.dadata.IntegrationTests.TestCasesSuccessPhone.successTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonLive.class)
@IfProfileValue(name = "live-tests", value = "enabled")
public class UT25PhoneCleanSuccess {

	@Autowired
	private DaDataClient dadata;


	@Test
	public void cleanKhabarovsk1() throws DaDataException {
		test(SamplePhones.KHABAROVSK_1);
	}

	@Test
	public void cleanKhabarovsk2() throws DaDataException {
		test(SamplePhones.KHABAROVSK_2);
	}

	@Test
	public void cleanKhabarovsk3() throws DaDataException {
		test(SamplePhones.KHABAROVSK_3);
	}

	@Test
	public void cleanKhabarovsk4() throws DaDataException {
		test(SamplePhones.KHABAROVSK_4);
	}

	@Test
	public void cleanKhabarovsk5() throws DaDataException {
		test(SamplePhones.KHABAROVSK_5);
	}

	@Test
	public void cleanKhabarovsk6() throws DaDataException {
		test(SamplePhones.KHABAROVSK_6);
	}

	@Test
	public void cleanKhabarovsk7() throws DaDataException {
		test(SamplePhones.KHABAROVSK_7);
	}

	@Test
	public void cleanKhabarMobile1() throws DaDataException {
		test(SamplePhones.KHABAR_MOBILE_1);
	}

	@Test
	public void cleanKhabarMobile2() throws DaDataException {
		test(SamplePhones.KHABAR_MOBILE_2);
	}

	@Test
	public void cleanEao1() throws DaDataException {
		test(SamplePhones.EAO_1);
	}

	@Test
	public void cleanMoscow1() throws DaDataException {
		test(SamplePhones.MOSCOW_1);
	}

	@Test
	public void cleanMoscow3() throws DaDataException {
		test(SamplePhones.MOSCOW_2);
	}

	@Test
	public void cleanMoscowMobile1() throws DaDataException {
		test(SamplePhones.MOSCOW_MOBILE_1);
	}

	@Test
	public void cleanMoscowMobile2() throws DaDataException {
		test(SamplePhones.MOSCOW_MOBILE_2);
	}

	@Test
	public void cleanMoscowMobile3() throws DaDataException {
		test(SamplePhones.MOSCOW_MOBILE_3);
	}

	@Test
	public void cleanMoscowMobile4() throws DaDataException {
		test(SamplePhones.MOSCOW_MOBILE_4);
	}

	@Test
	public void cleanSpb1() throws DaDataException {
		test(SamplePhones.SPB_1);
	}

	@Test
	public void cleanSpbMobile1() throws DaDataException {
		test(SamplePhones.SPB_MOBILE_1);
	}

	@Test
	public void cleanSpbSip1() throws DaDataException {
		test(SamplePhones.SPB_SIP_1);
	}

	@Test
	public void cleanNovosib1() throws DaDataException {
		test(SamplePhones.NOVOSIB_1);
	}

	@Test
	public void cleanNovosibMobile1() throws DaDataException {
		test(SamplePhones.NOVOSIB_MOBILE_1);
	}

	@Test
	public void cleanInTTK1() throws DaDataException {
		test(SamplePhones.IN_TTK_1);
	}


	@Test
	public void cleanInvariants1() throws DaDataException {
		test(SamplePhones.INVARIANTS_1);
	}

	@Test
	public void cleanUnknown1() throws DaDataException {
		test(SamplePhones.UNKNOWN_1);
	}

	@Test
	public void cleanForeign1() throws DaDataException {
		test(SamplePhones.FOREIGN_1);
	}

	@Test
	public void cleanUnparseable1() throws DaDataException {
		test(SamplePhones.UNPARSEABLE_1);
	}

	// -----------------------------------------------------------------------------------------------------------------

	// shared test body
	private void test(final SamplePhones sample) {
		successTest(dadata, sample.getSourcePattern(), sample.getMatcher());
	}
}
