package com.worktango.createSurvey;
import org.testng.annotations.DataProvider;

/**
 * Data Provider for createSurvey test cases
 */

public class CreateSurveyDataProvider {

	@DataProvider(name = "createSurvey")
	public static Object[][] createSurveyDataProvider() {

		Object[][] retObjArr = {
				{"CREATE_BOOKING", "Positive test scenario creating booking for room"},
		};
		
		return retObjArr;
	}
	
	@DataProvider(name = "getBooking")
	public static Object[][] getBookingDataProvider() {

		Object[][] retObjArr = {
				{"GET_BOOKING", "Positive test scenario get booking details for room on basis of booking id"}
		};
		
		return retObjArr;
	}
	
	@DataProvider(name = "getBookingRoomDetails")
	public static Object[][] getBookingRoomDataProvider() {

		Object[][] retObjArr = {
				{"GET_ROOM_BOOKING", "Positive test scenario get all booking details for room"},
				{"GET_ROOM_BOOKING_TWICE", "Positive test scenario get all booking details for room if room booked on dfferent days"}

		};
		
		return retObjArr;
	}
	
	@DataProvider(name = "createBookingInvalid")
	public static Object[][] createBookingInvalidDataProvider() {

		Object[][] retObjArr = {
				{"INVALID_BOOKINGROOM_AGAIN", "Invalid test scenario booking same room again"},
				{"INVALID_BOOKING_CHECKOUT_LESSER_CHECKIN", "Invalid test scenario booking date checkout lesser than checkin"}

		};
		
		return retObjArr;
	}

}
