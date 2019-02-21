package com.damiza.my.shop.web.admin.service.impl;

import com.damiza.my.shop.commons.dto.BaseResult;
import com.damiza.my.shop.commons.dto.PageInfo;
import com.damiza.my.shop.commons.utils.RegexpUtils;
import com.damiza.my.shop.commons.validator.BeanValidator;
import com.damiza.my.shop.domain.TbUser;
import com.damiza.my.shop.web.admin.dao.TbUserDao;
import com.damiza.my.shop.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbUserServiceImpl implements TbUserService {


    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        //验证不通过
        if(validator != null){
            return BaseResult.fail(validator);
        }
        //通过验证
        else {
            tbUser.setUpdated(new Date());
            //新增用户
            if (tbUser.getId() == null){
                //密码需要加密
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }
            //编辑用户
            else {
                tbUserDao.update(tbUser);
            }

            return BaseResult.success("保存用户信息成功");
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

//    @Override
//    public List<TbUser> selectByUsername(String username) {
//        return tbUserDao.selectByUsername(username);
//    }

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

//    @Override
//    public List<TbUser> search(TbUser tbUser) {
//        return tbUserDao.search(tbUser);
//    }

    @Override
    public void deleteMulti(String[] ids) {
        tbUserDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbUser> page(int start, int length, int draw,TbUser tbUser) {

        int count = tbUserDao.count(tbUser);

        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("tbUser",tbUser);

        PageInfo<TbUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbUserDao.page(params));


        return pageInfo;
    }

    @Override
    public int count(TbUser tbUser) {
        return tbUserDao.count(tbUser);
    }

}
