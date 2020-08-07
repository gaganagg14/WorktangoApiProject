package com.worktango.dto.addSurvey;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageClass {
	private Language language;
	private String surveyName;
	private String emailSubject;
	private String emailBody;
}
