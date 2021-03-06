/*
 * Copyright (c) 2018 Boris Fox, REDCOM-Internet CJSC
 * All rights reserved.
 */

package ru.redcom.lib.integration.api.client.dadata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ru.redcom.lib.integration.api.client.dadata.types.Gender;
import ru.redcom.lib.integration.api.client.dadata.types.QcName;

/*
Название	Длина	Описание
source	100	Исходное ФИО одной строкой
result	150	Стандартизованное ФИО одной строкой
result_genitive	150	ФИО в родительном падеже (кого?)
result_dative	150	ФИО в дательном падеже (кому?)
result_ablative	150	ФИО в творительном падеже (кем?)
surname	50	Фамилия
name	50	Имя
patronymic	50	Отчество
gender	10	Пол
М — мужской;
Ж — женский;
НД — не удалось однозначно определить;
qc	5	Код проверки

[
  {
    "source": "Срегей владимерович иванов",
    "result": "Иванов Сергей Владимирович",
    "result_genitive": "Иванова Сергея Владимировича",
    "result_dative": "Иванову Сергею Владимировичу",
    "result_ablative": "Ивановым Сергеем Владимировичем",
    "surname": "Иванов",
    "name": "Сергей",
    "patronymic": "Владимирович",
    "gender": "М",
    "qc": 1
  }
]
*/

/**
 * Cleaned Person Name container.
 *
 * @author boris
 */
@SuppressWarnings("unused")
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Name extends ResponseItem {
	private String result;

	@JsonProperty("result_genitive")
	private String resultGenitive;
	@JsonProperty("result_dative")
	private String resultDative;
	@JsonProperty("result_ablative")
	private String resultAblative;

	private String surname;
	private String name;
	private String patronymic;

	private Gender gender;

	@JsonProperty(required = true)
	private QcName qc;

	// This class is not instantiable
	private Name() {
	}
}
