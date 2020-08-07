package com.worktango.createSurvey;

import java.util.ArrayList;
import java.util.List;

import com.worktango.dto.addQuestion.AddQuestionVariables;
import com.worktango.dto.addQuestion.Category;
import com.worktango.dto.addQuestion.Icon;
import com.worktango.dto.addQuestion.LanguageSelect;
import com.worktango.dto.addQuestion.SurveyElement;
import com.worktango.dto.addQuestion.Type;
import com.worktango.dto.addQuestion.WorktangoAddQuestionRequest;
import com.worktango.dto.addSurvey.Language;

public class AddQuestionTestHelper {
	
	public WorktangoAddQuestionRequest addIconQuestionObj(int surveyId) {
		WorktangoAddQuestionRequest addQuestion = new WorktangoAddQuestionRequest();
		
		//Set OperationName
		addQuestion.setOperationName("AddSurveyElement");
		
		//Set variables
		AddQuestionVariables variables = new AddQuestionVariables();
		variables.setSurveyId(surveyId);
		SurveyElement surveyElement = new SurveyElement();
		surveyElement.setIsLibraryQuestion(false);
		surveyElement.setIsAttributeBased(false);
		surveyElement.setOrderIndex(1);
		surveyElement.setShowTextComment(false);
		surveyElement.setShowSkipButton(false);
		surveyElement.setShowLabels(false);
		surveyElement.setShowDescription(false);
		surveyElement.setHideReporting(false);
		List<LanguageSelect> messagesPerLanguage = new ArrayList<LanguageSelect>();
		LanguageSelect lang = new LanguageSelect();
		Language language = new Language();
		language.setLangISOCode("en-ca");
		lang.setLanguage(language);
		lang.setMessage("TestIcon");
		lang.setDescription("");
		messagesPerLanguage.add(lang);
		surveyElement.setMessagesPerLanguage(messagesPerLanguage);
		
		Category category = new Category();
		category.setId(9);
		surveyElement.setCategory(category);
		Type t = new Type();
		t.setName("FIXED");
		surveyElement.setType(t);
		surveyElement.setRatingOptionLowest(1);
		surveyElement.setRatingOptionHighest(4);
		Icon icon = new Icon();
		icon.setName("fixed_eyes");
		surveyElement.setIcon(icon);
		variables.setSurveyElement(surveyElement);
		addQuestion.setVariables(variables);
		
		//Set Query
		String query = "mutation AddSurveyElement($surveyId: Int!, $surveyElement: SurveyElementInput!) {\n  addSurveyElement(surveyId: $surveyId, surveyElement: $surveyElement) {\n    id\n    __typename\n  }\n}\n";
		addQuestion.setQuery(query);
		
		return addQuestion;
		
	}

}
