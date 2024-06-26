package com.zeabur.springboot.externalAPI.controller;

import com.zeabur.springboot.ccgames.dto.request.*;
import com.zeabur.springboot.externalAPI.service.CcGameService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ccgame")
@CrossOrigin
public class CcGameController {

    private final CcGameService ccGameService;

    @Autowired
    public CcGameController(CcGameService ccGameService) {
        this.ccGameService = ccGameService;
    }

    @PostMapping(value = "/login", produces = {"application/json"}, consumes = {"application/json"})
    public String login(
            @Valid @RequestBody LoginRequestDto loginRequestDto) {
        return ccGameService.login(loginRequestDto);
    }

    @PostMapping("/getUserInfo")
    public String getUserInfo(
            @Valid @RequestBody UserInfoRequestDto userInfoRequestDto
    ) {
        return ccGameService.getUserInfo(userInfoRequestDto);
    }

    @PostMapping("/getGameList")
    public String getGameList(
            @Valid @RequestBody GameListRequestDto gameListRequestDto
    ) {
        return ccGameService.getGameList(gameListRequestDto);
    }

    @PostMapping("/searchGame")
    public String searchGame(
            @Valid @RequestBody GameSearchRequestDto gameSearchRequestDto
    ) {
        return ccGameService.searchByGameList(gameSearchRequestDto);
    }

    @PostMapping("/getReservedGameList")
    public String getReservedGameList(
            @Valid @RequestBody UserReservedGameListRequestDto userReservedGameListRequestDto
    ) {
        return ccGameService.getReservedGameList(userReservedGameListRequestDto);
    }

    @PostMapping("/getUserRentalGameHistory")
    public String getUserRentalGameHistory(
            @Valid @RequestBody UserRentalGameHistoryRequestDto userRentalGameHistoryRequestDto
    ) {
        return ccGameService.getUserRentalGameHistory(userRentalGameHistoryRequestDto);
    }

    @PostMapping("/reserveGame")
    public String reserveGame(
            @Valid @RequestBody ReserveGameRequestDto reserveGameRequestDto
    ) {
        return ccGameService.reserveGame(reserveGameRequestDto);
    }

    @PostMapping("/cancelRental")
    public String cancelRental(
            @Valid @RequestBody CancelReserveRequestDto cancelReserveRequestDto
    ) {
        return ccGameService.cancelReserve(cancelReserveRequestDto);
    }

    @PostMapping("/rentGame")
    public String rentGame(
            @Valid @RequestBody RentGameRequestDto rentGameRequestDto
    ) {
        return ccGameService.rentGame(rentGameRequestDto);
    }

    @PostMapping("/returnGame")
    public String returnGame(
            @Valid @RequestBody ReturnGameRequestDto returnGameRequestDto
    ) {
        return ccGameService.returnGame(returnGameRequestDto);
    }

}
