package com.management.attendance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.management.attendance.entity.Member;

import javax.validation.constraints.NotEmpty;

public class MemberDTO {

    @JsonProperty("memberId")
    private long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    public MemberDTO() {
    }

    public MemberDTO(Member member) {
        this.firstName = member.getFirstName();
        this.lastName = member.getLastName();
        this.id=member.getId();
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
}
