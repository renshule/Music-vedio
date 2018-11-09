package com.weixin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class User{
    private Integer u_id;
    private String u_name;
    private String u_password;
}




public class Classify {
    private Integer cId;
    private String cName;
}
