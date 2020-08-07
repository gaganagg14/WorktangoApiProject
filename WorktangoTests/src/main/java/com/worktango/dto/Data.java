package com.worktango.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.worktango.dto.addSurvey.AddSurvey;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	
	private AddSurvey addSurvey;
	private ShowSurvey survey;
	private AddQuestion addSurveyElement;
	private UpdateSurvey updateSurvey;

}
