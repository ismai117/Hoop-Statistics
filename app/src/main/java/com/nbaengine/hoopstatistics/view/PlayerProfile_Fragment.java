package com.nbaengine.hoopstatistics.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.annotations.SerializedName;
import com.nbaengine.hoopstatistics.R;
;
import com.nbaengine.hoopstatistics.adapters.StatsAdapter;
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

    @BindView(R.id.height_frag)
    TextView playerHeight;
    @BindView(R.id.weight_frag)
    TextView playerWeight;
    @BindView(R.id.age_frag)
    TextView playerAge;
    @BindView(R.id.fullStatsRecycler)
    RecyclerView statRecyclerView;

    @BindView(R.id.layer_one)
    LinearLayout linearLayout1;
    @BindView(R.id.layer_two)
    LinearLayout linearLayout2;

    private StatsAdapter statsAdapter;
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

        statsAdapter = new StatsAdapter(statResponses);
        statRecyclerView.setHasFixedSize(true);
        statRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        statRecyclerView.setAdapter(statsAdapter);

        playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);
        playerViewModel.getStatList().observe(getViewLifecycleOwner(), new Observer<List<LatestStatResponse>>() {
            @Override
            public void onChanged(List<LatestStatResponse> latestStatResponses) {
                if (statResponses != null) {
                    statResponses = latestStatResponses;
                    statsAdapter.setStatList(statResponses);

                    for (LatestStatResponse latestStatResponse : statResponses) {
                        if (latestStatResponse.getSeason().contains(season)) {
                            ppgValue.setText(latestStatResponse.getPointsPerGame());
                            rpgValue.setText(latestStatResponse.getReboundsPerGame());
                            apgValue.setText(latestStatResponse.getAssistsPerGame());
                            Log.d("ppg", "worked");


                            switch (latestStatResponse.getTeam()) {

                                case "ATL":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.hawks_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.hawks_two));
                                    break;

                                case "BOS":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.celtics_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.celtics_two));
                                    break;

                                case "BKN":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.nets_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.nets_two));
                                    break;

                                case "CHA":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.hornets_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.hornets_two));
                                    break;

                                case "CHI":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.bulls_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.bulls_two));
                                    break;

                                case "CLE":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.cleveland_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.cleveland_two));
                                    break;

                                case "DAL":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.mavericks_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.mavericks_two));
                                    break;

                                case "DEN":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.nuggets_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.nuggets_two));
                                    break;

                                case "DET":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.pistons_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.pistons_two));
                                    break;

                                case "GS":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.warriors_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.warriors_two));
                                    break;

                                case "HOU":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.rockets_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.rockets_two));
                                    break;

                                case "IND":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.pacers_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.pacers_two));
                                    break;

                                case "LAC":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.clippers_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.clippers_two));
                                    break;

                                case "LAL":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.lakers_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.lakers_two));
                                    break;

                                case "MEM":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.grizzlies_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.grizzlies_two));
                                    break;

                                case "MIA":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.heat_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.heat_two));
                                    break;

                                case "MIL":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.bucks_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.bucks_two));
                                    break;

                                case "MIN":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.timberwolves_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.timberwolves_two));
                                    break;

                                case "NO":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.pelicans_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.pelicans_two));
                                    break;

                                case "NY":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.knicks_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.knicks_two));
                                    break;

                                case "OKC":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.thunder_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.thunder_two));
                                    break;

                                case "ORL":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.magic_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.magic_two));
                                    break;

                                case "PHI":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.sevsixers_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.sevsixers_two));
                                    break;

                                case "PHX":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.suns_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.suns_two));
                                    break;

                                case "POR":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.blazers_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.blazers_two));
                                    break;

                                case "SAC":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.kings_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.kings_two));
                                    break;

                                case "SA":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.spurs_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.spurs_two));
                                    break;

                                case "TOR":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.raptors_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.raptors_two));
                                    break;

                                case "UTAH":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.jazz_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.jazz_two));
                                    break;

                                case "WSH":
                                    linearLayout1.setBackgroundColor(getResources().getColor(R.color.wizards_one));
                                    linearLayout2.setBackgroundColor(getResources().getColor(R.color.wizards_two));
                                    break;


                            }
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


        try {
            teamName.setText(playerResponses.get(position).getTeam().split(" (?!.* )")[1]);
            playername.setText(playerResponses.get(position).getFirstname() + "\n" + playerResponses.get(position).getLastname());
            playernumber.setText(playerResponses.get(position).getJerseyNumber());
            playerposition.setText(playerResponses.get(position).getPosition());
            playerHeight.setText(playerResponses.get(position).getHeight());
            playerWeight.setText(playerResponses.get(position).getWeight());
            playerAge.setText(playerResponses.get(position).getAge() + " Years");

        } catch (Exception e) {
            e.printStackTrace();
        }

        Picasso.get().load(playerResponses.get(position).getHeadShotUrl()).into(playerimage);


        for (TeamResponse team : teamResponses) {
            try {
                if (playerResponses.get(position).getTeam().equals(team.getName())) {
                    Picasso.get().load(team.getTeamLogoUrl()).into(teamimage);
                } else {
                    Log.d("playerteamlogo", "failed");
                }
            } catch (Exception e) {
                e.printStackTrace();

            }

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.remove(PlayerProfile_Fragment.this).commit();
                }
            });

        }
            return view;

        }
    }