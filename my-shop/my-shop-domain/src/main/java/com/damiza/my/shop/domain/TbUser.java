package com.damiza.my.shop.domain;

import com.damiza.my.shop.commons.persistence.BaseEntity;
import com.damiza.my.shop.commons.utils.RegexpUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class TbUser extends BaseEntity {
    @Length(min = 6,max = 20,message = "姓名的长度必须在6 - 20之间")
    private String username;

    @JsonIgnore
    @Length(min = 6,max = 20,message = "密码的长度必须在6 - 20之间")
    private String password;

    @Pattern(regexp = RegexpUtils.PHONE,message = "手机号格式不正确")
    private String phone;

    @Pattern(regexp = RegexpUtils.EMAIL,message = "邮箱格式不正确")
    private String email;


//    @JsonIgnore
//    public String getPassword() {
//        return password;
//    }



}
