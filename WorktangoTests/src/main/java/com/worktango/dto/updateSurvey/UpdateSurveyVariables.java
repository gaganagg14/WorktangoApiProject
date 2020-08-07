package com.worktango.dto.updateSurvey;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateSurveyVariables {
	private int id;
	private Survey survey;
	

}
