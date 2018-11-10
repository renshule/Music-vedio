package com.weixin.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sing {
    private Integer singId;
    private String singName;
    private String singPic;
    private String singUrl;
    private Integer cId;
    private Integer singerId;
    private String singerName;
}
