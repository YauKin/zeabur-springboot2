package com.zeabur.springboot.externalAPI.service;

import com.zeabur.springboot.ccgames.dto.*;

public interface CcGameService {

    String login(LoginRequestDto loginRequestDto);

    String getUserInfo(UserInfoRequestDto userInfoRequestDto);

    String getGameList(GameListRequestDto gameListRequestDto);

    String searchByGameList(GameSearchRequestDto gameSearchRequestDto);

    String getUserGameBookingList(UserGameBookingListRequestDto userGameBookingListRequestDto);

    String getUserGameList(UserGameListRequestDto userGameListRequestDto);
}
