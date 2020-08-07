package com.worktango.createSurvey;
import org.testng.annotations.Test;

import com.worktango.dto.AddQuestionWorktangoResponse;
import com.worktango.dto.CreateSurveyWorktangoResponse;
import com.worktango.dto.ShowSurveyWorktangoResponse;
import com.worktango.dto.addQuestion.WorktangoAddQuestionRequest;
import com.worktango.dto.addSurvey.WorktangoRequest;
import com.worktango.dto.updateSurvey.WorktangoUpdateSurveyRequest;
import com.worktango.utility.RestAssuredWrapper;
import com.worktango.utility.TestConstants;


import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;



public class CreateSurveyApiTests {

	public static int surveyId;
	public static String surveyName;
	RestAssuredWrapper restMethod = new RestAssuredWrapper();
	CreateSurveyTestHelper createHelper = new CreateSurveyTestHelper();
	ShowSurveyTestHelper showHelper = new ShowSurveyTestHelper();
	AddQuestionTestHelper addQuesHelper = new AddQuestionTestHelper();
	UpdateSurveyTestHelper updateHelper = new UpdateSurveyTestHelper();
	ShowSurveyWorktangoResponse showSurveyResponse = new ShowSurveyWorktangoResponse();
	AddQuestionWorktangoResponse addQuestionResponse = new AddQuestionWorktangoResponse();
	WorktangoRequest createSurveyRequest = new WorktangoRequest();
	CreateSurveyWorktangoResponse createSurveyResponse = new CreateSurveyWorktangoResponse();
	CreateSurveyWorktangoResponse updateSurveyResponse = new CreateSurveyWorktangoResponse();


	/**
	 * <pre>
	 * Verify createSurvey API
	 * </pre>
	 * <p>
	 * <pre>
	 * Test:CREATE_SURVEY
	 *     Steps:
	 *     1. Create Request body for survey API
	 *     2. Make createSurvey API call.
	 *     3. Validate API status code
	 *     4. validate surveyId sent in request is same returned in response
	 *     
	 * </pre>
	 *</p>
	 * @param sTestId       TestCase ID
	 * @param sTestDesc     TestCase Description
	 * @throws Exception
	 */

	@Test(dataProvider = "createSurvey", dataProviderClass = CreateSurveyDataProvider.class, priority=1)
	public void createSurvey(String sTestId, String sTestDesc){	

		//Generating random surveyName
		surveyName = createHelper.randomNumber();

		//CreateBookingRequest
		WorktangoRequest createSurveyRequest = createHelper.createSurveyObj(surveyName);

		Map<String,Object> queryParam = new HashMap<String,Object>();
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Authorization", "Bearer JWT "+TestConstants.token);

		createSurveyResponse = restMethod.run(TestConstants.WORKTANGO_URL, createSurveyRequest, queryParam,headers,CreateSurveyWorktangoResponse.class,200);

		surveyId = createSurveyResponse.getData().getAddSurvey().getId();
		System.out.println(surveyId);


	}

	@Test(priority=2)
	public void showSurvey(){	

		//ShowSurveyRequest
		WorktangoRequest showSurveyRequest = showHelper.showSurveyObj(surveyId);

		Map<String,Object> queryParam = new HashMap<String,Object>();
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Authorization", "Bearer JWT "+TestConstants.token);

		showSurveyResponse = restMethod.run(TestConstants.WORKTANGO_URL, showSurveyRequest, queryParam,headers,ShowSurveyWorktangoResponse.class,200);

		int id = showSurveyResponse.getData().getSurvey().getId();
		String surveyStatus = showSurveyResponse.getData().getSurvey().getStatus().getName();
		System.out.println(id);
		Assert.assertEquals(id, surveyId);
		Assert.assertEquals(surveyStatus, "CREATED");

	}

	@Test(priority=3)
	public void addIconQuestion() {

		//AddIconQuestionRequest
		WorktangoAddQuestionRequest addQuestionRequest = addQuesHelper.addIconQuestionObj(surveyId);

		Map<String,Object> queryParam = new HashMap<String,Object>();
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Authorization", "Bearer JWT "+TestConstants.token);

		addQuestionResponse = restMethod.run(TestConstants.WORKTANGO_URL, addQuestionRequest, queryParam,headers,AddQuestionWorktangoResponse.class,200);

		int id = addQuestionResponse.getData().getAddSurveyElement().getId();
		String typeName = addQuestionResponse.getData().getAddSurveyElement().get__typename();
		Assert.assertEquals(typeName, "SurveyElement");

	}
	
	@Test(priority=4)
	public void updateSurvey(){	


		//UpdateSurveyRequest
		WorktangoUpdateSurveyRequest updateSurveyRequest = updateHelper.updateSurveyObj(surveyName, surveyId);

		Map<String,Object> queryParam = new HashMap<String,Object>();
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Authorization", "Bearer JWT "+TestConstants.token);

		updateSurveyResponse = restMethod.run(TestConstants.WORKTANGO_URL, updateSurveyRequest, queryParam,headers,CreateSurveyWorktangoResponse.class,200);

		int id = updateSurveyResponse.getData().getUpdateSurvey().getId();
		System.out.println(id);


	}




}
