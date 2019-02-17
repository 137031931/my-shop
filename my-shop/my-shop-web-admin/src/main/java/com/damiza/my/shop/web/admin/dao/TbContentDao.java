package com.damiza.my.shop.web.admin.dao;

import com.damiza.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TbContentDao {
        /**
         * 查询全部信息
         * @return
         * 1.8版本以后public可以不写
         *
         */
        List<TbContent> selectAll();

        /**
         * 新增用户
         * @param tbContent
         */
        void insert(TbContent tbContent);

        /**
         * 根据id删除方法
         */
        void delete(Long id);

        /**
         * 根据id查询信息
         */
        TbContent getById(Long id);

        /**
         * 更新
         */
        void update(TbContent tbContent);


        /**
         * 批量删除功能
         */
        void deleteMulti(String[] ids);

        /**
         * 分页查询
         * @param params 需要两条参数 start:记录开始的位置 length:每页记录数
         * @return
         */
        List<TbContent> page(Map<String,Object> params);

        /**
         * 查询总笔数
         * @return
         */
        int count(TbContent tbContent);
}
