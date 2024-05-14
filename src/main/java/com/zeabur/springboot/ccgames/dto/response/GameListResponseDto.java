package com.zeabur.springboot.ccgames.dto.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GameListResponseDto {
    private String id;
    private String pId;
    private String productName;
    private String productType;
    private String banner;
    @SerializedName("abstract")
    private String abstractInfo; // Use @SerializedName to map "abstract" JSON field to "abstractInfo"
    private String content;
    private String updateTime;
    private String created;
    private String p_dId;
    private String text;
    private String hotNum;
    private int isRent;
    private int isReserve;
    private int isUpLevel;
}

