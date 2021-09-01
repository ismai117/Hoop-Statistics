package com.nbaengine.hoopstatistics.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nbaengine.hoopstatistics.modal.LatestStatResponse;
import com.nbaengine.hoopstatistics.modal.PlayerResponse;
import com.nbaengine.hoopstatistics.modal.TeamResponse;
import com.nbaengine.hoopstatistics.network.ApiClient;
import com.nbaengine.hoopstatistics.service.PlayerService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerViewModel extends ViewModel {

    private String apiHost = "nba-player-individual-stats.p.rapidapi.com";
    private String apiKey = "0c42b61f32mshd336f80f0806bb5p150e69jsn83cc84b177b5";
    private MutableLiveData<List<PlayerResponse>> playerList;
    private MutableLiveData<List<TeamResponse>> teamList;
    private MutableLiveData<List<LatestStatResponse>> statList;

    public MutableLiveData<List<PlayerResponse>> getPlayerList() {
        if (playerList == null){
            playerList = new MutableLiveData<>();
        }

        return playerList;
    }

    public MutableLiveData<List<TeamResponse>> getTeamList(){
        if (teamList == null){
            teamList = new MutableLiveData<>();
        }

        return teamList;
    }

    public MutableLiveData<List<LatestStatResponse>> getStatList(){
        if (statList == null){
            statList = new MutableLiveData<>();
        }

        return statList;
    }

    public void makePlayerCall() {

        PlayerService playerService = ApiClient.getApiClient().create(PlayerService.class);

        Call<List<PlayerResponse>> getPlayers = playerService.getPlayer(apiHost, apiKey);

        getPlayers.enqueue(new Callback<List<PlayerResponse>>() {
            @Override
            public void onResponse(Call<List<PlayerResponse>> call, Response<List<PlayerResponse>> response) {
                getPlayerList().postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PlayerResponse>> call, Throwable t) {
                getPlayerList().postValue(null);
            }
        });
    }

    public void makeTeamCall() {

        PlayerService playerService = ApiClient.getApiClient().create(PlayerService.class);

        Call<List<TeamResponse>> getTeams = playerService.getTeam(apiHost, apiKey);

        getTeams.enqueue(new Callback<List<TeamResponse>>() {
            @Override
            public void onResponse(Call<List<TeamResponse>> call, Response<List<TeamResponse>> response) {
                getTeamList().postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<TeamResponse>> call, Throwable t) {
                getTeamList().postValue(null);
            }
        });
    }

    public void makeStatCall(String id){

        PlayerService playerService = ApiClient.getApiClient().create(PlayerService.class);

        Call<List<LatestStatResponse>> getstats = playerService.getLatestStats(apiHost, apiKey, id);

        getstats.enqueue(new Callback<List<LatestStatResponse>>() {
            @Override
            public void onResponse(Call<List<LatestStatResponse>> call, Response<List<LatestStatResponse>> response) {
                getStatList().postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<LatestStatResponse>> call, Throwable t) {
                getStatList().postValue(null);
            }
        });

    }
}