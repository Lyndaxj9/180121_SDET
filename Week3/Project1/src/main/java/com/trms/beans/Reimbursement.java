package com.trms.beans;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Reimbursement {
	private int empId;
	private int eventId;
	private int formatId;
	private int centerId;
	private float cost;
	private float projectedReimb;
	private String description;
	private float grade;
	private float passGrade;
	private int workDaysMissed;
	private LocalDateTime dateTime;
	private Date date;
	private String dateStr;
	private String timeStr;
	private LocalDateTime timestamp;
	private String workJustification;
	private int nextApprovalId;
	private int nextInfoReq;
	private int urgent;
	private int approved;
	private List<File> attachments;
	
	public Reimbursement() {
		attachments = new ArrayList<File>();
	}
	
	
	public Reimbursement(int empId, int eventId, int formatId, int centerId, float cost, float projectedReimb,
			String description, float grade, float passGrade, int workDaysMissed, LocalDateTime dateTime,
			LocalDateTime timestamp, String workJustification, int nextApprovalId) {
		this.empId = empId;
		this.eventId = eventId;
		this.formatId = formatId;
		this.centerId = centerId;
		this.cost = cost;
		this.projectedReimb = projectedReimb;
		this.description = description;
		this.grade = grade;
		this.passGrade = passGrade;
		this.workDaysMissed = workDaysMissed;
		this.dateTime = dateTime;
		this.timestamp = timestamp;
		this.workJustification = workJustification;
		this.nextApprovalId = nextApprovalId;
	}
	
	
	
	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public int getEventId() {
		return eventId;
	}


	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	public int getFormatId() {
		return formatId;
	}


	public void setFormatId(int formatId) {
		this.formatId = formatId;
	}


	public int getCenterId() {
		return centerId;
	}


	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}


	public float getProjectedReimb() {
		return projectedReimb;
	}


	public void setProjectedReimb(float projectedReimb) {
		this.projectedReimb = projectedReimb;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getGrade() {
		return grade;
	}


	public void setGrade(float grade) {
		this.grade = grade;
	}


	public float getPassGrade() {
		return passGrade;
	}


	public void setPassGrade(float passGrade) {
		this.passGrade = passGrade;
	}


	public int getWorkDaysMissed() {
		return workDaysMissed;
	}


	public void setWorkDaysMissed(int workDaysMissed) {
		this.workDaysMissed = workDaysMissed;
	}


	public LocalDateTime getDateTime() {
		return dateTime;
	}


	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getDateStr() {
		return dateStr;
	}


	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}


	public String getTimeStr() {
		return timeStr;
	}


	public void setTimeStr(String timeStr) {
		this.timeStr = timeStr;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public String getWorkJustification() {
		return workJustification;
	}


	public void setWorkJustification(String workJustification) {
		this.workJustification = workJustification;
	}


	public int getNextApprovalId() {
		return nextApprovalId;
	}


	public void setNextApprovalId(int nextApprovalId) {
		this.nextApprovalId = nextApprovalId;
	}


	public int getNextInfoReq() {
		return nextInfoReq;
	}


	public void setNextInfoReq(int nextInfoReq) {
		this.nextInfoReq = nextInfoReq;
	}


	public int getUrgent() {
		return urgent;
	}


	public void setUrgent(int urgent) {
		this.urgent = urgent;
	}


	public int getApproved() {
		return approved;
	}


	public void setApproved(int approved) {
		this.approved = approved;
	}


	public List<File> getAttachments() {
		return attachments;
	}


	public void setAttachments(List<File> attachments) {
		this.attachments = attachments;
	}

	public void addFile(File f) {
		attachments.add(f);
	}
	
}
