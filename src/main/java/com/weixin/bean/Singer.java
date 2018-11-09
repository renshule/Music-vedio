package com.weixin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Singer {
    private Integer singerId;
    private String singerName;
    private String singerIntro;
}
