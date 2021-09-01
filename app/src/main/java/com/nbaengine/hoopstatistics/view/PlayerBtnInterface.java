package com.nbaengine.hoopstatistics.view;

import com.nbaengine.hoopstatistics.modal.PlayerResponse;

import java.util.List;

public interface PlayerBtnInterface {
    public void clickPlayer(List<PlayerResponse> playerResponses, int position);
}
