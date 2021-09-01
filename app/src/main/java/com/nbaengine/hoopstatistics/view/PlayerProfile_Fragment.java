package com.nbaengine.hoopstatistics.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;
import com.nbaengine.hoopstatistics.R;
;
import com.nbaengine.hoopstatistics.modal.LatestStatResponse;
import com.nbaengine.hoopstatistics.modal.PlayerResponse;
import com.nbaengine.hoopstatistics.modal.TeamResponse;
import com.nbaengine.hoopstatistics.viewmodel.PlayerViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PlayerProfile_Fragment extends Fragment {


    @BindView(R.id.teamName_frag)
    TextView teamName;
    @BindView(R.id.playerName_frag)
    TextView playername;
    @BindView(R.id.playernumber_frag)
    TextView playernumber;
    @BindView(R.id.playerposition_frag)
    TextView playerposition;
    @BindView(R.id.playerImage_frag)
    ImageView playerimage;
    @BindView(R.id.teamImage_frag)
    ImageView teamimage;
    @BindView(R.id.backtohome)
    Button button;

    @BindView(R.id.ppgValue)
    TextView ppgValue;
    @BindView(R.id.rpgValue)
    TextView rpgValue;
    @BindView(R.id.apgValue)
    TextView apgValue;

    @BindView(R.id.progressBar_frag)
    ProgressBar progressBar;

    private final List<PlayerResponse> playerResponses;
    int position;
    private final List<TeamResponse> teamResponses;
    private List<LatestStatResponse> statResponses = new ArrayList<>();
    private PlayerViewModel playerViewModel;
    private String season = "2020-21";

    public PlayerProfile_Fragment(List<PlayerResponse> playerResponses, int position, List<TeamResponse> teamResponses) {
        this.playerResponses = playerResponses;
        this.position = position;
        this.teamResponses = teamResponses;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_player_profile_, container, false);
        ButterKnife.bind(this, view);


        playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
        playerViewModel.getStatList().observe(getViewLifecycleOwner(), new Observer<List<LatestStatResponse>>() {
            @Override
            public void onChanged(List<LatestStatResponse> latestStatResponses) {
                if (statResponses != null) {
                    statResponses = latestStatResponses;

                    for (LatestStatResponse latestStatResponse : statResponses){
                        if (latestStatResponse.getSeason().contains(season)){
                            ppgValue.setText(latestStatResponse.getPointsPerGame());
                            rpgValue.setText(latestStatResponse.getReboundsPerGame());
                            apgValue.setText(latestStatResponse.getAssistsPerGame());
                            Log.d("ppg", "worked");
                        }
                    }

                    progressBar.setVisibility(View.GONE);
                    Log.d("statlist", "worked");
                } else {
                    Log.d("statlist", "failed");
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });


        String[] idValue = playerResponses.get(position).getId().toString().split("\\.");
        playerViewModel.makeStatCall(idValue[0]);




        teamName.setText(playerResponses.get(position).getTeam().split(" (?!.* )")[1]);
        playername.setText(playerResponses.get(position).getFirstname() + "\n" + playerResponses.get(position).getLastname());
        playernumber.setText(playerResponses.get(position).getJerseyNumber());
        playerposition.setText(playerResponses.get(position).getPosition());

        Picasso.get().load(playerResponses.get(position).getHeadShotUrl()).into(playerimage);


        for (TeamResponse team: teamResponses){
            try {
                if (playerResponses.get(position).getTeam().equals(team.getName())){
                    Picasso.get().load(team.getTeamLogoUrl()).into(teamimage);
                } else {
                    Log.d("playerteamlogo", "failed");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.remove(PlayerProfile_Fragment.this).commit();
            }
        });




        return view;
    }
}