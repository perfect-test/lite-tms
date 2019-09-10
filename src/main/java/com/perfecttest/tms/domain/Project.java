package com.perfecttest.tms.domain;

public class Project {
    private Integer id;
    private String createTime;
    private String updateTime;
    private Integer userId;
    private String name;
    private String shortDescription;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        if(createTime != null){
            createTime = createTime.replace(".0", "");
        }
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        if(updateTime != null){
            updateTime = updateTime.replace(".0", "");
        }
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project withId(Integer id) {
        this.id = id;
        return this;
    }

    public Project withCreateTime(String createTime) {
        setCreateTime(createTime);
        return this;
    }

    public Project withUpdateTime(String updateTime) {
        setUpdateTime(updateTime);
        return this;
    }

    public Project withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Project withName(String name) {
        this.name = name;
        return this;
    }

    public Project withShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public Project withDescription(String description) {
        this.description = description;
        return this;
    }

}
