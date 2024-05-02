package com.zeabur.springboot.externalAPI.service;

import com.zeabur.springboot.ccgames.dto.GameListRequestDto;
import com.zeabur.springboot.ccgames.dto.GameSearchRequestDto;
import com.zeabur.springboot.ccgames.dto.LoginRequestDto;
import com.zeabur.springboot.ccgames.dto.UserInfoRequestDto;
import com.zeabur.springboot.constant.GameType;
import com.zeabur.springboot.helper.RestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CcGameServiceImpl implements CcGameService {

    private final RestHelper restHelper;
    private final String ccGameUrl;
    private final Map<String, String> headers;

    public CcGameServiceImpl(RestHelper restHelper, @Value("${ccgame.api.url}") String ccGameUrl) {
        this.restHelper = restHelper;
        this.ccGameUrl = ccGameUrl;
        this.headers = new HashMap<>();
        this.headers.put("Site-Source", "http://tw.frxgame.com");
    }

    @Override
    public String login(LoginRequestDto loginRequestDto) {
        String apiUrl = ccGameUrl + "user/login/?phone=" + loginRequestDto.getUsername() + "&pwd=" + loginRequestDto.getPassword();
        return doGetIgnoreSSL(apiUrl);
    }

    @Override
    public String getUserInfo(UserInfoRequestDto userInfoRequestDto) {
        String apiUrl = ccGameUrl + "user/getUserInfo/?userId=" + userInfoRequestDto.getUserId() + "&authLoginCode=" + userInfoRequestDto.getAuthLoginCode();
        return doGetIgnoreSSL(apiUrl);
    }

    @Override
    public String getGameList(GameListRequestDto gameListRequestDto) {
        /* this api need page parameter, if page is null, set it to 1 */
        gameListRequestDto.setPage(Optional.ofNullable(gameListRequestDto.getPage()).orElse(1));
        /* this api need gameType parameter, if gameType is null, set it to 0 */
        gameListRequestDto.setGameType(Optional.ofNullable(gameListRequestDto.getGameType()).orElse(GameType.ALL_CATEGORIES));
        String apiUrl = ccGameUrl + "product/getProductList/?page=" + gameListRequestDto.getPage() + "&cId=" + gameListRequestDto.getGameType().getId();
        return doGetIgnoreSSL(apiUrl);
    }

    @Override
    public String searchByGameList(GameSearchRequestDto gameSearchRequestDto) {
        gameSearchRequestDto.setPage(Optional.ofNullable(gameSearchRequestDto.getPage()).orElse(1));
        String apiUrl = ccGameUrl + "product/getProductList/?page=" + gameSearchRequestDto.getPage() + "&key=" + gameSearchRequestDto.getKey();
        return doGetIgnoreSSL(apiUrl);
    }
    private String doGetIgnoreSSL(String apiUrl){
        return restHelper.doGet(apiUrl, String.class, headers, true);
    }


}
