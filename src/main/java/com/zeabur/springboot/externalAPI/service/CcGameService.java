package com.zeabur.springboot.externalAPI.service;

import com.zeabur.springboot.ccgames.dto.*;

public interface CcGameService {

    String login(LoginRequestDto loginRequestDto);

    String getUserInfo(UserInfoRequestDto userInfoRequestDto);

    String getGameList(GameListRequestDto gameListRequestDto);

    String searchByGameList(GameSearchRequestDto gameSearchRequestDto);

    String getReservedGameList(UserReservedGameListRequestDto userReservedGameListRequestDto);

    String getUserRentalGameHistory(UserRentalGameHistoryRequestDto userRentalGameHistoryRequestDto);

    String reserveGame(ReserveGameRequestDto reserveGameRequestDto);

    String cancelReserve(CancelReserveRequestDto cancelReserveRequestDto);

    String rentGame(RentGameRequestDto rentGameRequestDto);

    String returnGame(ReturnGameRequestDto returnGameRequestDto);
}
