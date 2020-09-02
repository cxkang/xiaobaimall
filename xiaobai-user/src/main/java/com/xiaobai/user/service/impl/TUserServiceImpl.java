package com.xiaobai.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.xiaobai.common.utils.R;
import com.xiaobai.user.controller.TUserController;
import com.xiaobai.user.entity.TTokenLogEntity;
import com.xiaobai.user.util.JwtUtil;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.common.utils.Query;

import com.xiaobai.user.dao.TUserDao;
import com.xiaobai.user.entity.TUserEntity;
import com.xiaobai.user.service.TUserService;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;


@Service("tUserService")
public class TUserServiceImpl extends ServiceImpl<TUserDao, TUserEntity> implements TUserService {
    @Resource
    private  TUserDao  userDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TUserEntity> page = this.page(
                new Query<TUserEntity>().getPage(params),
                new QueryWrapper<TUserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R queryUser(String username, String password) {
//        String md5Pass =
//                DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        QueryWrapper<TUserEntity>wrapper=new QueryWrapper<>();
        wrapper.eq("client_id", username)
                .eq("client_password", password);

        TUserEntity tUserEntity = userDao.selectOne(wrapper);
        if(tUserEntity==null){
            return R.error(400,"登录失败");
        }
        Map<String ,Object> info=new HashMap<>();;
        info.put("role","user");
        info.put("username",username);
        String token = JwtUtil.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(info), null);
        TTokenLogEntity t=new TTokenLogEntity();
        t.setToken(token);
        t.setCreateTime(new Date());
        t.setUserUuid(tUserEntity.getDataUuid());
        t.setDataUuid(UUID.randomUUID().toString());
        t.setExpireTime(new Date(JwtUtil.JWT_TTL));
        return  R.ok("登录成功").put("Authorization",token);

    }

}