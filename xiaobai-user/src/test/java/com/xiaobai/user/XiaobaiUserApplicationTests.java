package com.xiaobai.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobai.user.dao.TUserDao;
import com.xiaobai.user.entity.TUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@SpringBootTest
class XiaobaiUserApplicationTests {
@Resource
 TUserDao tUserDao;
    @Test
    void contextLoads() {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("client_id","zhangsan");
        TUserEntity tUserEntity = tUserDao.selectOne(queryWrapper);
        System.out.println(tUserEntity);
    }

}
