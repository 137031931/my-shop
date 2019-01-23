package com.damiza.my.shop.web.admin.service.impl;

import com.damiza.my.shop.domain.TbUser;
import com.damiza.my.shop.web.admin.dao.TbUserDao;
import com.damiza.my.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
@Service
public class TbUserServiceImpl implements TbUserService {


    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public void save(TbUser tbUser) {
        tbUser.setUpdated(new Date());
        //新增用户
        if (tbUser.getId() == null){
            tbUser.setCreated(new Date());
            tbUserDao.insert(tbUser);
        }
        //编辑用户
        else {
            tbUserDao.update(tbUser);
        }
    }

    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }

    @Override
    public List<TbUser> selectByUsername(String username) {
        return tbUserDao.selectByUsername(username);
    }

    @Override
    public TbUser login(String email,String password) {

        TbUser tbUser = tbUserDao.getByEmail(email);
        /**
         * 验证登录
         */
        //如果用用户不为空就把密码用md5的方式转码
        if (tbUser != null){
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            //转码后的密码与数据库中的相比较是否相同,相同则登录成功
            if (md5Password.equals(tbUser.getPassword())){
                return tbUser;
            }
        }

        return null;
    }

    /**
     * 用户信息的有效性验证
     * @param tbUser
     */
    private void checkTbUser(TbUser tbUser){

    }
}
