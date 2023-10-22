package com.patient.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class User {

    private String name;
    private String email;
    private String password;
    private String dateOfBirth;
    private String gender;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonProperty("status")
    private Boolean status;
    @JsonProperty("token")
    private String token;

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public User(String name, String email, String password) {

    }

    public User(String name, String email, String password, String dateOfBirth, String gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("status")
    public Boolean getStatus() {
        return status;
    }
    @JsonProperty("status")
    public Boolean setStatus(Boolean status) {
        this.status = status;
        return status;
    }
    @JsonProperty("token")
    public String getToken() {
        return token;
    }
    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

}
