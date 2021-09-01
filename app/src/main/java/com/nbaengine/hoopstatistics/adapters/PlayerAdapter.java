package com.nbaengine.hoopstatistics.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nbaengine.hoopstatistics.R;
import com.nbaengine.hoopstatistics.modal.PlayerResponse;
import com.nbaengine.hoopstatistics.view.PlayerBtnInterface;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {


    private List<PlayerResponse> playerList;
    private PlayerBtnInterface playerBtnInterface;

    public PlayerAdapter(List<PlayerResponse> playerList, PlayerBtnInterface playerBtnInterface) {
        this.playerList = playerList;
        this.playerBtnInterface = playerBtnInterface;
    }

    public void setPlayerList(List<PlayerResponse> playerList){
        this.playerList = playerList;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item_layout, parent, false);
        return new PlayerViewHolder(view, playerBtnInterface, playerList);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PlayerViewHolder holder, int position) {

        try {
            holder.name.setText(this.playerList.get(position).getFirstname() + " \n" + this.playerList.get(position).getLastname());
            holder.team.setText(this.playerList.get(position).getTeam().split(" (?!.* )")[1]);
            holder.position.setText(this.playerList.get(position).getPosition());
            holder.number.setText(this.playerList.get(position).getJerseyNumber());
            Picasso.get().load(playerList.get(position).getHeadShotUrl()).error(R.drawable.placeholder).into(holder.playerImage);
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        if (this.playerList != null){
            return this.playerList.size();
        }
        return 0;
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder{

        CircleImageView playerImage;
        TextView name, team, position, number;
        PlayerBtnInterface playerBtnInterface;
        List<PlayerResponse> playerResponses;

        public PlayerViewHolder(@NonNull @NotNull View itemView, PlayerBtnInterface playerBtnInterface, List<PlayerResponse> playerResponses) {
            super(itemView);

            playerImage = itemView.findViewById(R.id.player_image);
            name = itemView.findViewById(R.id.player_name);
            team = itemView.findViewById(R.id.player_team);
            position = itemView.findViewById(R.id.player_position);
            number = itemView.findViewById(R.id.player_number);

            this.playerBtnInterface = playerBtnInterface;
            this.playerResponses = playerResponses;

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION & playerBtnInterface != null) {
                        playerBtnInterface.clickPlayer(playerResponses, position);
                    }
                }
            });



        }


    }
}
