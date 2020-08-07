package com.worktango.dto.addQuestion;

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
public class SurveyElement {
	private boolean isIsLibraryQuestion;
	private boolean isIsAttributeBased;
	private int orderIndex;
	private boolean required;
	private boolean showTextComment;
	private boolean showSkipButton;
	private boolean showLabels;
	private boolean showDescription;
	private boolean hideReporting;
	private List<LanguageSelect> messagesPerLanguage;
	private Category category;
	private Type type;
	private int ratingOptionLowest;
	private int ratingOptionHighest;
	private Icon icon;
}
