package com.nbaengine.hoopstatistics.service;

import com.nbaengine.hoopstatistics.modal.LatestStatResponse;
import com.nbaengine.hoopstatistics.modal.PlayerResponse;
import com.nbaengine.hoopstatistics.modal.TeamResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface PlayerService {

    ///

    @GET("players/firstname?firstname=jaylen")
    Call<List<PlayerResponse>> getPlayer(
            @Header("x-rapidapi-host") String host,
            @Header("x-rapidapi-key") String key
    );

    @GET("teams")
    Call<List<TeamResponse>> getTeam(
            @Header("x-rapidapi-host") String host,
            @Header("x-rapidapi-key") String key
    );

    @GET("playerseasons?")
    Call<List<LatestStatResponse>> getLatestStats(
            @Header("x-rapidapi-host") String host,
            @Header("x-rapidapi-key") String key,
            @Query("playerId") String id
    );

}


//
//Log.d("players", " \n" +
//        "firstname: " + player.firstname + " \n" +
//        "lastname: " + player.lastname + " \n" +
//        "position: " + player.position + " \n" +
//        "date of birth: " + player.dateofbirth + " \n" +
//        "height: " + player.height + " \n" +
//        "weight: " + player.weight + " \n" +
//        "jerseyNumber: " + player.jerseyNumber + " \n" +
//        "age: " + player.age
//        );