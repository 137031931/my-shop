package com.damiza.my.shop.domain;

import com.damiza.my.shop.commons.persistence.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TbUser extends BaseEntity {
    private String username;

    @JsonIgnore
    private String password;
    private String phone;
    private String email;
    private String content;

//    @JsonIgnore
//    public String getPassword() {
//        return password;
//    }



}
