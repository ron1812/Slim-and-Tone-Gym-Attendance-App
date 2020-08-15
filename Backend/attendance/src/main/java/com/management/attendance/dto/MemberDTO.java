package com.management.attendance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.management.attendance.entity.Member;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class MemberDTO {

    @JsonProperty("memberId")
    private long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String address;

    private String contactNo;

    private String alternateContactNo;

    @NotEmpty
    private String gender;

    private String bloodGroup;

    private String occupation;

    private String emailId;

    private String marriedStatus;

    private Date dateOfBirth;

    public MemberDTO() {
    }

    public MemberDTO(Member member) {
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.id=member.getId();
        this.address=member.getAddress();
        this.contactNo=member.getContactNo();
        this.bloodGroup=member.getBloodGroup();
        this.alternateContactNo=member.getAlternateContactNo();
        this.dateOfBirth=member.getDateOfBirth();
        this.gender=member.getGender();
        this.emailId=member.getEmailId();
        this.marriedStatus=member.getMarriedStatus();
        this.occupation=member.getOccupation();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAlternateContactNo() {
        return alternateContactNo;
    }

    public void setAlternateContactNo(String alternateContactNo) {
        this.alternateContactNo = alternateContactNo;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMarriedStatus() {
        return marriedStatus;
    }

    public void setMarriedStatus(String marriedStatus) {
        this.marriedStatus = marriedStatus;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
