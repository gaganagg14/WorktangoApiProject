package com.worktango.createSurvey;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.worktango.dto.addSurvey.Language;
import com.worktango.dto.addSurvey.LanguageClass;
import com.worktango.dto.addSurvey.Types;
import com.worktango.dto.addSurvey.Variables;
import com.worktango.dto.addSurvey.WorktangoRequest;
import com.worktango.dto.updateSurvey.Employees;
import com.worktango.dto.updateSurvey.Status;
import com.worktango.dto.updateSurvey.Survey;
import com.worktango.dto.updateSurvey.Timezone;
import com.worktango.dto.updateSurvey.UpdateSurveyVariables;
import com.worktango.dto.updateSurvey.WorktangoUpdateSurveyRequest;

public class UpdateSurveyTestHelper {
	
	public WorktangoUpdateSurveyRequest updateSurveyObj(String surveyName,int surveyId) {
		WorktangoUpdateSurveyRequest updateSurvey = new WorktangoUpdateSurveyRequest();
		
		//Set OperationName
		updateSurvey.setOperationName("UpdateSurvey");
		
		//Set variables
		UpdateSurveyVariables variables = new UpdateSurveyVariables();
		variables.setId(surveyId);
		Survey survey = new Survey();
		survey.setSendingEmailAddressId(1);
		
		//Seting employees
		List<Employees> employeeIds = new ArrayList<Employees>();
		Employees e1 = new Employees();
		e1.setId(42960);
		e1.setAction("CREATE");
		Employees e2 = new Employees();
		e2.setId(42961);
		e2.setAction("CREATE");
		employeeIds.add(e1);
		employeeIds.add(e2);
		survey.setEmployeeIds(employeeIds);
		
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
		survey.setNamesPerLanguage(language);
		
		survey.setFromEmailName("Test");
		survey.setStartTimeUTC("2020-12-06 12:18:00");
		survey.setEndTimeUTC("2020-12-12 12:18:00");
		Timezone t = new Timezone();
		t.setTimezone("Asia/Calcutta");
		survey.setTimezone(t);
		Status s  = new Status();
		s.setName("SCHEDULED");
		survey.setStatus(s);
		variables.setSurvey(survey);
		
		updateSurvey.setVariables(variables);
		
		
		//Set Query
		String query = "mutation UpdateSurvey($id: Int!, $survey: SurveyUpdateInput!) {\n  updateSurvey(id: $id, survey: $survey) {\n    id\n    __typename\n  }\n}\n";
		updateSurvey.setQuery(query);
		
		return updateSurvey;
		
	}
	

}
