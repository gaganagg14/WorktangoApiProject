package com.worktango.dto.updateSurvey;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.worktango.dto.addSurvey.LanguageClass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Survey {
	private int sendingEmailAddressId;
	private List<Employees> employeeIds;
	private List<LanguageClass> namesPerLanguage;
	private String fromEmailName;
	private String startTimeUTC;
	private String endTimeUTC;
	private Timezone timezone;
	private Status status;

}
