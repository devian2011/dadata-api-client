/*
 * Copyright (c) 2018 Boris Fox, REDCOM-Internet CJSC
 * All rights reserved.
 */

package ru.redcom.software.util.integration.api.client.dadata;

import ru.redcom.software.util.integration.api.client.dadata.dto.Address;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

/**
 * DaData API Client interface.
 */
public interface DaDataClient {
	boolean checkAvailability(boolean silent) throws DaDataException;

	@Nonnull
	BigDecimal getProfileBalance() throws DaDataException;

	@Nonnull
	Address cleanAddress(@Nonnull String source) throws DaDataException;

	@Nonnull
	Address[] cleanAddresses(@Nonnull String... sources) throws DaDataException;

	// TODO implement other API bindings
}