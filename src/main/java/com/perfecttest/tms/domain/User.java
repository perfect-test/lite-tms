package com.perfecttest.tms.domain;

import java.util.Arrays;
import java.util.List;

public class User {
    private Integer id;
    private String userName;
    private List<String> availableProjects;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getAvailableProjects() {
        return availableProjects;
    }

    public void setAvailableProjects(List<String> availableProjects) {
        this.availableProjects = availableProjects;
    }

    public User withId(Integer id) {
        this.id = id;
        return this;
    }

    public User withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public User withAvailableProjects(List<String> availableProjects) {
        this.availableProjects = availableProjects;
        return this;
    }

    public User withAvailableProjects(String... availableProjects) {
        this.availableProjects = Arrays.asList(availableProjects);
        return this;
    }


}
