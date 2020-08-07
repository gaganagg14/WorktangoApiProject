package com.worktango.createSurvey;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.worktango.dto.addSurvey.Language;
import com.worktango.dto.addSurvey.LanguageClass;
import com.worktango.dto.addSurvey.Types;
import com.worktango.dto.addSurvey.Variables;
import com.worktango.dto.addSurvey.WorktangoRequest;

public class CreateSurveyTestHelper {
	
	public WorktangoRequest createSurveyObj(String surveyName) {
		WorktangoRequest createSurvey = new WorktangoRequest();
		
		//Set OperationName
		createSurvey.setOperationName("AddSurvey");
		
		//Set variables
		Variables variables = new Variables();
		variables.setShowResults(true);
		variables.setAnonymousConversation(true);
		variables.setSendingEmailAddressId(1);
		
		List<Types> types = new ArrayList<Types>();
		Types t = new Types();
		t.setId(22);
		t.setName("Engagement");
		types.add(t);
		variables.setTypes(types);
		
		//Setting Language
		List<LanguageClass> language = new ArrayList<LanguageClass>();
		LanguageClass lang = new LanguageClass();
		lang.setSurveyName(surveyName);
		lang.setEmailBody("The only way we can improve as an organization");
		lang.setEmailSubject("We need your feedback");
		Language l = new Language();
		l.setId("1");
		l.setLangISOCode("en-ca");
		lang.setLanguage(l);
		language.add(lang);
		variables.setNamesPerLanguage(language);
		
		List<Integer> companyIds = new ArrayList<Integer>();
		companyIds.add(8);
		variables.setCompanyIds(companyIds);
		createSurvey.setVariables(variables);
		
		//Set Query
		String query = "mutation AddSurvey($showResults: Boolean, $anonymousConversation: Boolean, $types: [SurveyTypeInput]!, $companyIds: [Int]!, $namesPerLanguage: [SurveyLanguageInput]!, $sendingEmailAddressId: Int) {\n  addSurvey(survey: {showResults: $showResults, anonymousConversation: $anonymousConversation, types: $types, companyIds: $companyIds, namesPerLanguage: $namesPerLanguage, sendingEmailAddressId: $sendingEmailAddressId}) {\n    id\n    __typename\n  }\n}\n";
		createSurvey.setQuery(query);
		
		return createSurvey;
		
	}
	
	public String randomNumber() {
		Random rand = new Random(); 
		int num = rand.nextInt(1000); 
	    return "Test" + num;
	}

}
