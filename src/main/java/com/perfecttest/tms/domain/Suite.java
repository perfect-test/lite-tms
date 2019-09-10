package com.perfecttest.tms.domain;

public class Suite {
    private Integer id;
    private String createTime;
    private String updateTime;
    private Integer createUserId;
    private Integer updateUserId;
    private String name;
    private String shortDescription;
    private String description;
    private Integer projectId;

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
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
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

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Suite withId(Integer id) {
        this.id = id;
        return this;
    }

    public Suite withCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public Suite withUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Suite withCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public Suite withUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
        return this;
    }

    public Suite withName(String name) {
        this.name = name;
        return this;
    }

    public Suite withShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public Suite withDescription(String description) {
        this.description = description;
        return this;
    }

    public Suite withProjectId(Integer projectId) {
        this.projectId = projectId;
        return this;
    }


}
