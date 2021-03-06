/*
 * Copyright (c) 2018 Boris Fox, REDCOM-Internet CJSC
 * All rights reserved.
 */

package ru.redcom.lib.integration.api.client.dadata.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Address record actuality state in the FIAS directory.
 *
 * @author boris
 */
public enum FiasActuality {
	/*
	Признак актуальности адреса в ФИАС
	0 — актуальный;
	1-50 — переименован;
	51 — переподчинен;
	99 — удален;
	 */
	ACTUAL(0),
	RENAMED(IntStream.rangeClosed(1, 50).toArray()),
	RESUBORDINATED(51),
	REMOVED(99),
	/** Catch-all constant for unrecognized response contents */
	@JsonEnumDefaultValue
	UNKNOWN();

	@NonNull private final int[] values;

	FiasActuality(@NonNull final int... values) {
		Arrays.sort(values);
		this.values = values;
	}

	private boolean contains(final int value) {
		return Arrays.binarySearch(values, value) >= 0;
	}

	@SuppressWarnings("unused")
	@Nullable
	@JsonCreator
	private static FiasActuality jsonCreator(final Integer s) {
		return s == null ? null : Arrays.stream(values()).filter(v -> v.contains(s)).findAny().orElse(UNKNOWN);
	}
}
