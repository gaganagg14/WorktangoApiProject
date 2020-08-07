package com.worktango.dto.addQuestion;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.worktango.dto.addSurvey.LanguageClass;
import com.worktango.dto.addSurvey.Types;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddQuestionVariables {
	private SurveyElement surveyElement;
	private int surveyId;
}
