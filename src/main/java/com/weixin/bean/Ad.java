package com.weixin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ad {
    private Integer adId;
    private String adPic;
    private Integer adHot;
    private String adIntro;

}