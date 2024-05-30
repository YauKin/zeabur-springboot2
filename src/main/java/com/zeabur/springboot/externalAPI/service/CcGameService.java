package com.zeabur.springboot.externalAPI.service;

import com.zeabur.springboot.ccgames.dto.request.*;
import com.zeabur.springboot.externalAPI.dto.response.ApiResponse;
import com.zeabur.springboot.externalAPI.dto.response.GameListResponseDto;
import com.zeabur.springboot.externalAPI.dto.response.LoginResponseDto;

public interface CcGameService {

    ApiResponse<LoginResponseDto> login(LoginRequestDto loginRequestDto) throws Exception;

    String getUserInfo(UserInfoRequestDto userInfoRequestDto);

    ApiResponse<GameListResponseDto> getGameList(GameListRequestDto gameListRequestDto) throws Exception;

    ApiResponse<GameListResponseDto> searchByGameList(GameSearchRequestDto gameSearchRequestDto) throws Exception;

    String getReservedGameList(UserReservedGameListRequestDto userReservedGameListRequestDto);

    String getUserRentalGameHistory(UserRentalGameHistoryRequestDto userRentalGameHistoryRequestDto);

    String reserveGame(ReserveGameRequestDto reserveGameRequestDto);

    String cancelReserve(CancelReserveRequestDto cancelReserveRequestDto);

    String rentGame(RentGameRequestDto rentGameRequestDto);

    String returnGame(ReturnGameRequestDto returnGameRequestDto);
}
