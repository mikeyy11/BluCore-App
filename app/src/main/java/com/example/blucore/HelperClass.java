package com.example.blucore;

import java.util.List;

public class HelperClass {

    String userType, email, username, password, jobs;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public HelperClass(String userType, String email, String username, String password, List jobs) {
        this.userType = userType;
        this.email = email;
        this.username = username;
        this.password = password;
        this.jobs = jobs.toString();
    }

    public HelperClass() {
    }
}
