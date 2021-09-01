package com.nbaengine.hoopstatistics.modal;

import com.google.gson.annotations.SerializedName;

public class TeamResponse {


    @SerializedName("id")
    private Double id;

    @SerializedName("name")
    private String name;

    @SerializedName("conference")
    private String conference;

    @SerializedName("record")
    private String record;

    @SerializedName("teamLogoUrl")
    private String teamLogoUrl;

    @SerializedName("dateLastUpdated")
    private String dateLastUpdated;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getTeamLogoUrl() {
        return teamLogoUrl;
    }

    public void setTeamLogoUrl(String teamLogoUrl) {
        this.teamLogoUrl = teamLogoUrl;
    }

    public String getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(String dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }
}
