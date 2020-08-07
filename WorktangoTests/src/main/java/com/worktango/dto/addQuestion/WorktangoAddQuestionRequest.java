package com.worktango.dto.addQuestion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Gagan on 08/06/2020.
 */

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorktangoAddQuestionRequest {
	public String operationName;
	public AddQuestionVariables variables;
	public String query;

}
