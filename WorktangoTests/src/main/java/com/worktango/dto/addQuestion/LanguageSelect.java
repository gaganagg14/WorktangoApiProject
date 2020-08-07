package com.worktango.dto.addQuestion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.worktango.dto.addSurvey.Language;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageSelect {
	private Language language;
	private String message;
	private String description;
}
