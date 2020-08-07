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
public class Variables {
	private boolean showResults;
	private boolean anonymousConversation;
	private int sendingEmailAddressId;
	private List<Types> types;
	private List<LanguageClass> namesPerLanguage;
	private List<Integer> companyIds;
	private int id;
	
}
