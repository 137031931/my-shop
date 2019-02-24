package com.damiza.my.shop.domain;

import com.damiza.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

/**
 * 分类管理
 */
@Data
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    //这个注解是给这个参数起个别名
//    @JsonProperty(value = "isParent")
    private Boolean isParent;
    private TbContentCategory parent;
}
