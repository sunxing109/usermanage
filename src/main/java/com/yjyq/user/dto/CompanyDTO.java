package com.yjyq.user.dto;

import io.swagger.annotations.ApiModel;

@ApiModel
public class CompanyDTO {

    private String companyName;
    private String totalScore;
    private String taskApplyNum;
    private String publishedNum;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getTaskApplyNum() {
        return taskApplyNum;
    }

    public void setTaskApplyNum(String taskApplyNum) {
        this.taskApplyNum = taskApplyNum;
    }

    public String getPublishedNum() {
        return publishedNum;
    }

    public void setPublishedNum(String publishedNum) {
        this.publishedNum = publishedNum;
    }
}
