package com.nbaengine.hoopstatistics.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.nbaengine.hoopstatistics.R;
import com.nbaengine.hoopstatistics.adapters.PlayerAdapter;
import com.nbaengine.hoopstatistics.modal.PlayerResponse;
import com.nbaengine.hoopstatistics.modal.TeamResponse;
import com.nbaengine.hoopstatistics.network.ApiClient;
import com.nbaengine.hoopstatistics.service.PlayerService;
import com.nbaengine.hoopstatistics.viewmodel.PlayerViewModel;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements PlayerBtnInterface, AdapterView.OnItemSelectedListener {


    private List<PlayerResponse> playerList;
    private List<TeamResponse> teamList;
    private PlayerViewModel playerViewModel;
    private PlayerAdapter adapter;

    @BindView(R.id.player_recycler_view)
    RecyclerView player_recyclerView;

    @BindView(R.id.progress)
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        player_recyclerView.setHasFixedSize(true);
        player_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlayerAdapter(playerList, this);
        player_recyclerView.setAdapter(adapter);


        playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);

        playerViewModel.getPlayerList().observe(this, new Observer<List<PlayerResponse>>() {
            @Override
            public void onChanged(List<PlayerResponse> playerResponses) {
                if (playerResponses != null) {
                    playerList = playerResponses;
                    adapter.setPlayerList(playerList);
                    Log.d("playerlist", "worked");
                    progressBar.setVisibility(View.GONE);
                } else {
                    Log.d("playerlist", "failed");
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });

        playerViewModel.getTeamList().observe(this, new Observer<List<TeamResponse>>() {
            @Override
            public void onChanged(List<TeamResponse> teamResponses) {
                if (teamResponses != null) {
                    teamList = teamResponses;
                    Log.d("teamlist", "worked");
                    progressBar.setVisibility(View.GONE);
                } else {
                    Log.d("teamlist", "failed");
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        playerViewModel.makePlayerCall();
        playerViewModel.makeTeamCall();
    }


    @Override
    public void clickPlayer(List<PlayerResponse> playerResponses, int position) {
        Fragment fragment = new PlayerProfile_Fragment(playerResponses, position, teamList);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.fragmentContainer, fragment).commit();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
