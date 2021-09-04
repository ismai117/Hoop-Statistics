package com.nbaengine.hoopstatistics.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nbaengine.hoopstatistics.R;
import com.nbaengine.hoopstatistics.modal.LatestStatResponse;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StatsAdapter extends RecyclerView.Adapter<StatsAdapter.StatsViewHolder> {

    private List<LatestStatResponse> latestStatResponses;

    public StatsAdapter(List<LatestStatResponse> latestStatResponses) {
        this.latestStatResponses = latestStatResponses;
    }

    public void setStatList(List<LatestStatResponse> latestStatResponses) {
        this.latestStatResponses = latestStatResponses;
        notifyDataSetChanged();
        Log.d("adapterstat", "working");
    }


    @NonNull
    @NotNull
    @Override
    public StatsViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.statlayout, parent, false);
        return new StatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StatsViewHolder holder, int position) {


        holder.teamName.setText(this.latestStatResponses.get(position).getTeam());
        holder.gamesplayed.setText(this.latestStatResponses.get(position).getGamesPlayed());
        holder.minsPerGame.setText(this.latestStatResponses.get(position).getMinsPerGame());
        holder.pointspergame.setText(this.latestStatResponses.get(position).getPointsPerGame());
        holder.reboundsPerGame.setText(this.latestStatResponses.get(position).getReboundsPerGame());
        holder.assistsPerGame.setText(this.latestStatResponses.get(position).getAssistsPerGame());
        holder.blocksPerGame.setText(this.latestStatResponses.get(position).getBlocksPerGame());

        holder.fg.setText(this.latestStatResponses.get(position).getPercentageFieldGoal());
        holder.fgthree.setText(this.latestStatResponses.get(position).getPercentageThree());
        holder.ft.setText(this.latestStatResponses.get(position).getPercentageFreeThrow());


        holder.seasons.setText(this.latestStatResponses.get(position).getSeason());

    }

    @Override
    public int getItemCount() {
        if (this.latestStatResponses != null) {
            return this.latestStatResponses.size();
        }
        return 0;
    }


    static class StatsViewHolder extends RecyclerView.ViewHolder {

        TextView teamName, gamesplayed, minsPerGame, pointspergame, blocksPerGame, assistsPerGame, reboundsPerGame, turnoversPerGame, fg, fgthree, ft;
        TextView seasons;

        public StatsViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            teamName = itemView.findViewById(R.id.team);
            gamesplayed = itemView.findViewById(R.id.gamesplayed);
            minsPerGame = itemView.findViewById(R.id.minsPerGame);
            pointspergame = itemView.findViewById(R.id.pointspergame);
            reboundsPerGame = itemView.findViewById(R.id.reboundsPerGame);
            assistsPerGame = itemView.findViewById(R.id.assistsPerGame);
            blocksPerGame = itemView.findViewById(R.id.blocksPerGame);

            fg = itemView.findViewById(R.id.fg);
            fgthree = itemView.findViewById(R.id.fg3);
            ft = itemView.findViewById(R.id.ft);

            seasons = itemView.findViewById(R.id.seasons);

        }
    }

}
