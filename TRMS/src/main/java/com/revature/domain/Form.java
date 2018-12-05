package com.revature.domain;

import java.sql.Timestamp;

public class Form {
	
	private static Timestamp dateTime; 
	private static String address;
	private static String description;
	private static float cost;
	private static int status;
	private static String comment;
	private static Timestamp startDateTime;
	private static String eventType;
	private static String gradeType;
	
	public Form() {
		super();
	}
	
	public static String getComment() {
		return comment;
	}

	public static void setComment(String comment) {
		Form.comment = comment;
	}

	public static Timestamp getDateTime() {
		return dateTime;
	}
	public static void setDateTime(Timestamp dateTime) {
		Form.dateTime = dateTime;
	}
	public static String getAddress() {
		return address;
	}
	public static void setAddress(String address) {
		Form.address = address;
	}
	public static String getDescription() {
		return description;
	}
	public static void setDescription(String description) {
		Form.description = description;
	}
	public static float getCost() {
		return cost;
	}
	public static void setCost(float cost) {
		Form.cost = cost;
	}
	public static int getStatus() {
		return status;
	}
	public static void setStatus(int status) {
		Form.status = status;
	}
	public static Timestamp getStartDateTime() {
		return startDateTime;
	}
	public static void setStartDateTime(Timestamp startDateTime) {
		Form.startDateTime = startDateTime;
	}
	public static String getEventType() {
		return eventType;
	}
	public static void setEventType(String eventType) {
		Form.eventType = eventType;
	}
	public static String getGradeType() {
		return gradeType;
	}
	public static void setGradeType(String gradeType) {
		Form.gradeType = gradeType;
	}

}
