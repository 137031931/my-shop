package com.damiza.my.shop.domain;

import com.damiza.my.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 分类管理
 */
@Data
public class TbContentCategory extends BaseEntity {
    @Length(min = 1,max = 20,message = "分类名称必须介于1 - 20位之间")
    private Long parentId;
    private String name;
    private Integer status;

    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    //这个注解是给这个参数起个别名
//    @JsonProperty(value = "isParent")
    private Boolean isParent;
    private TbContentCategory parent;
}
