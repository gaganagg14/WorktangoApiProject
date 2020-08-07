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
public class UpdateSurvey {
	private int id;
	private String __typename;
}
