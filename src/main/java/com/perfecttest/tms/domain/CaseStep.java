package com.perfecttest.tms.domain;

public class CaseStep {

    private String step;
    private String expectedResult;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public CaseStep withStep(String step) {
        this.step = step;
        return this;
    }

    public CaseStep withExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
        return this;
    }


}
