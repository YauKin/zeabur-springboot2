package com.zeabur.springboot.externalAPI.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GameListRowResponseDto {
    String id;
    String status;
    String rentNum;
    @JsonProperty("pId")
    String pid;
    String langId;
    String productName;
    String productType;
    String productBrand;
    String productModel;
    String isRecommend;
    String texture;
    String purchasePrice;
    String cashPledge;
    String banner;
    @JsonProperty("abstract")
    @SerializedName("abstract")
    String abstractInfo; // Use @SerializedName to map "abstract" JSON field to "abstractInfo"
    String content;
    String useStatus;
    String warehouseEntryTime;
    String soldOutCause;
    String updateTime;
    String created;
    String p_dId;
    String isShowBuyBtn;
    String btnUrl;
    String text;
    String hotNum;
    String isPopCardInput;
    String isJudgeExpipyDate;
    int isRent;
    int isReserve;
    int isUpLevel;
}

