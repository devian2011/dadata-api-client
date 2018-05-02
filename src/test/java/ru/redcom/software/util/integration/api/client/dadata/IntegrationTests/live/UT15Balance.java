/*
 * Copyright (c) 2018 Boris Fox, REDCOM-Internet CJSC
 * All rights reserved.
 */

package ru.redcom.software.util.integration.api.client.dadata.IntegrationTests.live;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.redcom.software.util.integration.api.client.dadata.DaData;
import ru.redcom.software.util.integration.api.client.dadata.DaDataException;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonLive.class)
@ActiveProfiles("live")
public class UT15Balance {

	@Autowired
	private DaData dadata;

	@Test
	public void profileBalance() throws DaDataException {
		final BigDecimal balance = dadata.getProfileBalance();
		System.out.println("Balance = " + balance);
		assertThat(balance, allOf(is(greaterThanOrEqualTo(BigDecimal.valueOf(0L))), is(lessThanOrEqualTo(BigDecimal.valueOf(100L)))));
	}
}
