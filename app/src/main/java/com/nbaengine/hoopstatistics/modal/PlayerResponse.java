package com.nbaengine.hoopstatistics.modal;

import com.google.gson.annotations.SerializedName;

public class PlayerResponse {

    @SerializedName("id")
    private Double id;

    @SerializedName("firstName")
    private String firstname;

    @SerializedName("lastName")
    private  String lastname;

    @SerializedName("team")
    private String team;

    @SerializedName("position")
    private  String position;

    @SerializedName("dateOfBirth")
    private  String dateofbirth;

    @SerializedName("height")
    private  String height;

    @SerializedName("weight")
    private  String weight;

    @SerializedName("jerseyNumber")
    private  String jerseyNumber;

    @SerializedName("age")
    private  String age;

   @SerializedName("careerPoints")
    private float careerPoints;

   @SerializedName("careerBlocks")
    private float careerBlocks;

   @SerializedName("careerAssists")
    private float careerAssists;

    @SerializedName("careerRebounds")
    private float careerRebounds;

    @SerializedName("careerTurnovers")
    private float careerTurnovers;

    @SerializedName("careerPercentageThree")
    private float careerPercentageThree;

    @SerializedName("careerPercentageFreethrow")
    private float careerPercentageFreethrow;

    @SerializedName("careerPercentageFieldGoal")
    private float careerPercentageFieldGoal;

    @SerializedName("headShotUrl")
    private String headShotUrl;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(String jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public float getCareerPoints() {
        return careerPoints;
    }

    public void setCareerPoints(float careerPoints) {
        this.careerPoints = careerPoints;
    }

    public float getCareerBlocks() {
        return careerBlocks;
    }

    public void setCareerBlocks(float careerBlocks) {
        this.careerBlocks = careerBlocks;
    }

    public float getCareerAssists() {
        return careerAssists;
    }

    public void setCareerAssists(float careerAssists) {
        this.careerAssists = careerAssists;
    }

    public float getCareerRebounds() {
        return careerRebounds;
    }

    public void setCareerRebounds(float careerRebounds) {
        this.careerRebounds = careerRebounds;
    }

    public float getCareerTurnovers() {
        return careerTurnovers;
    }

    public void setCareerTurnovers(float careerTurnovers) {
        this.careerTurnovers = careerTurnovers;
    }

    public float getCareerPercentageThree() {
        return careerPercentageThree;
    }

    public void setCareerPercentageThree(float careerPercentageThree) {
        this.careerPercentageThree = careerPercentageThree;
    }

    public float getCareerPercentageFreethrow() {
        return careerPercentageFreethrow;
    }

    public void setCareerPercentageFreethrow(float careerPercentageFreethrow) {
        this.careerPercentageFreethrow = careerPercentageFreethrow;
    }

    public float getCareerPercentageFieldGoal() {
        return careerPercentageFieldGoal;
    }

    public void setCareerPercentageFieldGoal(float careerPercentageFieldGoal) {
        this.careerPercentageFieldGoal = careerPercentageFieldGoal;
    }

    public String getHeadShotUrl() {
        return headShotUrl;
    }

    public void setHeadShotUrl(String headShotUrl) {
        this.headShotUrl = headShotUrl;
    }
}
