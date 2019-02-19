package com.damiza.my.shop.domain;

import com.damiza.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

/**
 * 内容管理
 */
@Data
public class TbContent extends BaseEntity {
    private Long categoryId;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;

}
