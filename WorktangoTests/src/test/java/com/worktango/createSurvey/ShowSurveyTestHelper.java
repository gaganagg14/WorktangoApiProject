package com.worktango.createSurvey;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.worktango.dto.addSurvey.Language;
import com.worktango.dto.addSurvey.LanguageClass;
import com.worktango.dto.addSurvey.Types;
import com.worktango.dto.addSurvey.Variables;
import com.worktango.dto.addSurvey.WorktangoRequest;

public class ShowSurveyTestHelper {
	
	public WorktangoRequest showSurveyObj(int surveyId) {
		WorktangoRequest showSurvey = new WorktangoRequest();
		
		//Set OperationName
		showSurvey.setOperationName("getSurvey");
		
		//Set variables
		Variables variables = new Variables();
		variables.setId(surveyId);
		showSurvey.setVariables(variables);
		
		//Set Query
		String query = "query getSurvey($id: Int) {\n  survey(id: $id) {\n    id\n  status {\n      name\n      __typename\n    }\n   }\n}\n";
		showSurvey.setQuery(query);
		
		return showSurvey;
		
	}

}
