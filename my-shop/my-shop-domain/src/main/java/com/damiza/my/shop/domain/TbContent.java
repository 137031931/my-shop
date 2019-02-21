package com.damiza.my.shop.domain;

import com.damiza.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 内容管理
 */
@Data
public class TbContent extends BaseEntity {
    @NotNull(message = "父级类目不能为空")
    private Long categoryId;

    @Length(min = 1,max = 20,message = "标题长度在1 - 20之间")
    private String title;

    @Length(min = 1,max = 20,message = "子标题长度在1 - 20之间")
    private String subTitle;

    @Length(min = 1,max = 50,message = "标题描述长度在1 - 50之间")
    private String titleDesc;


    private String url;
    private String pic;
    private String pic2;

    @Length(min = 1,message = "内容不可为空")
    private String content;

}
