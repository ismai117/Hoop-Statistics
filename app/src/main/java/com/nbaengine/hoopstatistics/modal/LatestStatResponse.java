package com.nbaengine.hoopstatistics.modal;

import com.google.gson.annotations.SerializedName;

public class LatestStatResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("playerId")
    public PlayerId playerid;

    @SerializedName("season")
    private String season;

    @SerializedName("team")
    private String team;

    @SerializedName("gamesPlayed")
    private String gamesPlayed;

    @SerializedName("gamesStarted")
    private String gamesStarted;

    @SerializedName("pointsPerGame")
    private String pointsPerGame;

    @SerializedName("blocksPerGame")
    private String blocksPerGame;

    @SerializedName("assistsPerGame")
    private String assistsPerGame;

    @SerializedName("reboundsPerGame")
    private String reboundsPerGame;

    @SerializedName( "turnoversPerGame")
    private String turnoversPerGame;

    @SerializedName("percentageThree")
    private String percentageThree;

    @SerializedName("percentageFieldGoal")
    private String percentageFieldGoal;

    @SerializedName(  "percentageFreeThrow")
    private String percentageFreeThrow;

    @SerializedName("minsPerGame")
    private String minsPerGame;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(String gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getGamesStarted() {
        return gamesStarted;
    }

    public void setGamesStarted(String gamesStarted) {
        this.gamesStarted = gamesStarted;
    }

    public String getPointsPerGame() {
        return pointsPerGame;
    }

    public void setPointsPerGame(String pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
    }

    public String getBlocksPerGame() {
        return blocksPerGame;
    }

    public void setBlocksPerGame(String blocksPerGame) {
        this.blocksPerGame = blocksPerGame;
    }

    public String getAssistsPerGame() {
        return assistsPerGame;
    }

    public void setAssistsPerGame(String assistsPerGame) {
        this.assistsPerGame = assistsPerGame;
    }

    public String getReboundsPerGame() {
        return reboundsPerGame;
    }

    public void setReboundsPerGame(String reboundsPerGame) {
        this.reboundsPerGame = reboundsPerGame;
    }

    public String getTurnoversPerGame() {
        return turnoversPerGame;
    }

    public void setTurnoversPerGame(String turnoversPerGame) {
        this.turnoversPerGame = turnoversPerGame;
    }

    public String getPercentageThree() {
        return percentageThree;
    }

    public void setPercentageThree(String percentageThree) {
        this.percentageThree = percentageThree;
    }

    public String getPercentageFieldGoal() {
        return percentageFieldGoal;
    }

    public void setPercentageFieldGoal(String percentageFieldGoal) {
        this.percentageFieldGoal = percentageFieldGoal;
    }

    public String getPercentageFreeThrow() {
        return percentageFreeThrow;
    }

    public void setPercentageFreeThrow(String percentageFreeThrow) {
        this.percentageFreeThrow = percentageFreeThrow;
    }

    public String getMinsPerGame() {
        return minsPerGame;
    }

    public void setMinsPerGame(String minsPerGame) {
        this.minsPerGame = minsPerGame;
    }


}

class PlayerId {
    @SerializedName("id")
    public int id;
}


