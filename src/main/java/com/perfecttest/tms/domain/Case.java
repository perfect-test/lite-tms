package com.perfecttest.tms.domain;

import java.util.List;

public class Case {
    private Integer id;
    private String createTime;
    private String updateTime;
    private Integer createUserId;
    private Integer updateUserId;
    private String name;
    private String preconditions;
    private String description;
    private List<CaseStep> steps;
    private List<CaseReference> references;
    private CasePriority priority;
    private CaseType type;
    private Integer suiteId;

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

    public String getPreconditions() {
        return preconditions;
    }

    public void setPreconditions(String preconditions) {
        this.preconditions = preconditions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CaseStep> getSteps() {
        return steps;
    }

    public void setSteps(List<CaseStep> steps) {
        this.steps = steps;
    }

    public List<CaseReference> getReferences() {
        return references;
    }

    public void setReferences(List<CaseReference> references) {
        this.references = references;
    }

    public CasePriority getPriority() {
        return priority;
    }

    public void setPriority(CasePriority priority) {
        this.priority = priority;
    }

    public CaseType getType() {
        return type;
    }

    public void setType(CaseType type) {
        this.type = type;
    }

    public Integer getSuiteId() {
        return suiteId;
    }

    public void setSuiteId(Integer suiteId) {
        this.suiteId = suiteId;
    }

    public Case withId(Integer id) {
        this.id = id;
        return this;
    }

    public Case withCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public Case withUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Case withCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public Case withUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
        return this;
    }

    public Case withName(String name) {
        this.name = name;
        return this;
    }

    public Case withPreconditions(String preconditions) {
        this.preconditions = preconditions;
        return this;
    }

    public Case withDescription(String description) {
        this.description = description;
        return this;
    }

    public Case withSteps(List<CaseStep> steps) {
        this.steps = steps;
        return this;
    }

    public Case withReferences(List<CaseReference> references) {
        this.references = references;
        return this;
    }

    public Case withPriority(CasePriority priority) {
        this.priority = priority;
        return this;
    }

    public Case withType(CaseType type) {
        this.type = type;
        return this;
    }

    public Case withSuiteId(Integer suiteId) {
        this.suiteId = suiteId;
        return this;
    }


}
