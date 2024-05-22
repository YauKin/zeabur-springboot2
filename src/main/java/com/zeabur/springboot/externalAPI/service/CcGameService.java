package com.zeabur.springboot.externalAPI.service;

import com.zeabur.springboot.ccgames.dto.request.*;
import com.zeabur.springboot.externalAPI.dto.response.ApiResponse;
import com.zeabur.springboot.externalAPI.dto.response.GameListResponseDto;

public interface CcGameService {

    String login(LoginRequestDto loginRequestDto);

    String getUserInfo(UserInfoRequestDto userInfoRequestDto);

    ApiResponse<GameListResponseDto> getGameList(GameListRequestDto gameListRequestDto) throws Exception;

    String searchByGameList(GameSearchRequestDto gameSearchRequestDto);

    String getReservedGameList(UserReservedGameListRequestDto userReservedGameListRequestDto);

    String getUserRentalGameHistory(UserRentalGameHistoryRequestDto userRentalGameHistoryRequestDto);

    String reserveGame(ReserveGameRequestDto reserveGameRequestDto);

    String cancelReserve(CancelReserveRequestDto cancelReserveRequestDto);

    String rentGame(RentGameRequestDto rentGameRequestDto);

    String returnGame(ReturnGameRequestDto returnGameRequestDto);
}
