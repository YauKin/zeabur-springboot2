package com.zeabur.springboot.externalAPI.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponseDto {
    private String userId;
    private String domainId;
    private String extendCode;
    private String balance;
    private String frost;
    private String cash;
    private String extendMoney;
    private String pwd;
    private String avatar;
    private String userType;
    private String isRealName;
    private String phone;
    private String level;
    private String levelUid;
    private String privilegeIds;
    private String residueRentNum;
    private String realname;
    private String nickname;
    private String status;
    private String logJson;
    private String ip;
    private String mark;
    private String lockMark;
    private String bindTBAcc;
    private String rentNum;
    private String activeTime;
    private String lastUpTime;
    private String isTrial;
    private String isPopCardInput;
    private String levelInitialActivation;
    private String levelActiveTime;
    private String levelEndTime;
    private String created;
    private String updated;
    private String authCode;
    private String accountAuthCode;
    private String accountAuthCodeMsg;
    private String levelName;
    private String isJudgeExpipyDate;
    private int isFastGiveBack;
    private String isRealNameAuth;
    private int isViewBindAcc;
    private String bindTbAcc;
}
