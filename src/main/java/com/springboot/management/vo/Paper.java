package com.springboot.management.vo;



public class Paper {
    private  Integer id;
    private  Integer score;
    private  String   time;
    private  Integer bankId;


    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", score=" + score +
                ", time='" + time + '\'' +
                ", bankId=" + bankId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }
}