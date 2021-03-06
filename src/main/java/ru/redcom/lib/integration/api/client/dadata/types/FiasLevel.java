/*
 * Copyright (c) 2018 Boris Fox, REDCOM-Internet CJSC
 * All rights reserved.
 */

package ru.redcom.lib.integration.api.client.dadata.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Arrays;

/**
 * FIAS directory detalization level for this location.
 *
 * @author boris
 */
// JsonProperty/JsonValue does not work on enums when deserializing from json numerical types.
// Deserialization is done by ordinals instead, which is definitely not what we wants here.
// see https://github.com/FasterXML/jackson-databind/issues/1850
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum FiasLevel {
	/*
	Уровень детализации, до которого адрес найден в ФИАС
	0 — страна;
	1 — регион;
	3 — район;
	4 — город;
	5 — район города;
	6 — населенный пункт;
	7 — улица;
	8 — дом;
	65 — планировочная структура;
	90 — доп. территория;
	91 — улица в доп. территории;
	-1 — иностранный или пустой;
	 */
	@JsonProperty("0")
	COUNTRY(0),
	@JsonProperty("1")
	REGION(1),
	@JsonProperty("3")
	AREA(3),
	@JsonProperty("4")
	CITY(4),
	@JsonProperty("5")
	CITYAREA(5),
	@JsonProperty("6")
	SETTLEMENT(6),
	@JsonProperty("7")
	STREET(7),
	@JsonProperty("8")
	HOUSE(8),
	@JsonProperty("65")
	ESTATE(65),
	@JsonProperty("90")
	AUX_TERRITORY(90),
	@JsonProperty("91")
	AUX_TERRITORY_STREET(91),
	@JsonProperty("-1")
	FOREIGN_OR_EMPTY(-1),
	/** Catch-all constant for unrecognized response contents */
	@JsonEnumDefaultValue
	UNKNOWN(null);

	@Nullable private final Integer jsonValue;

	private boolean equalsTo(@NonNull final Integer value) {
		return value.equals(jsonValue);
	}

	@SuppressWarnings("unused")
	@Nullable
	@JsonCreator
	private static FiasLevel jsonCreator(final Integer s) {
		return s == null ? null : Arrays.stream(values()).filter(v -> v.equalsTo(s)).findAny().orElse(UNKNOWN);
	}
}
