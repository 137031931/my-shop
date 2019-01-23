package com.damiza.my.shop.web.admin.service.test;

import com.damiza.my.shop.domain.TbUser;
import com.damiza.my.shop.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-context-druid.xml","classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {
    @Autowired
    private TbUserService tbUserService;

    @Test
    public void testSelectAll(){
        List<TbUser> tbUsers = tbUserService.selectAll();
        //直接用tbUsers.for就可以用for循环
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

    @Test
    public void testInsert(){
        TbUser tbUser = new TbUser();
        tbUser.setUsername("damiaza");
        //密码不能直接显示在数据库里要使用md5加密,因为这里的参数是数组,所以用.getBytes()方法来转换
        tbUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        tbUser.setPhone("1877777777");
        tbUser.setEmail("admin@123.com");
        tbUser.setCreated(new Date());
        tbUser.setUpdated(new Date());
        tbUserService.save(tbUser);
    }

    @Test
    public void testDelete(){
        //这里是long类型所以加L
        tbUserService.delete(38L);
    }

    @Test
    public void testGetById(){
        TbUser tbUser = tbUserService.getById(34L);
        System.out.println(tbUser.getUsername());
    }

    @Test
    public void testUpdate(){
        TbUser tbUser = tbUserService.getById(36L);
        tbUser.setUsername("damiza1");
        tbUser.setPhone("13999999999");
        tbUserService.update(tbUser);
    }

    @Test
    public void testSelectByUsername(){
        List<TbUser> tbUsers = tbUserService.selectByUsername("uni");
        for (TbUser tbUser : tbUsers) {
            System.out.println(tbUser.getUsername());
        }
    }

//    @Test
//    public void testGetByEmail(){
//        TbUser tbUser = tbUserService.getByEmail("admin@qq.com");
//    }

    @Test
    public void testMD5(){
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}
