package com.xiaobai.user.controller;

import java.util.Arrays;
import java.util.Map;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaobai.user.dao.TUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.xiaobai.user.entity.TUserEntity;
import com.xiaobai.user.service.TUserService;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.common.utils.R;

import javax.annotation.Resource;


/**
 * 用户表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 19:32:04
 */
@RestController
@RequestMapping("/user")
public class TUserController {
    @Autowired
    private TUserService tUserService;
    @Resource
    private TUserDao tUserDao;

/**
 * 用户登录  login
 */

@RequestMapping("/login")
  public R login(String  username,String password){

      return tUserService.queryUser(username,password);

  }

@RequestMapping("/")
public R  tets(){
    return R.ok().put("data","测试");
}








    /**
     * 列表
     */
    //@PreAuthorize("hasAnyRole('admin')")
    @RequestMapping("/list")
  //  @RequiresPermissions("user:tuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tUserService.queryPage(params);

        return R.ok().put("page", page);
    }



    /**
     * 信息
     */
    @RequestMapping("/load/{id}")
    //@RequiresPermissions("user:tuser:info")
    public String info(@PathVariable("id") String id){
        QueryWrapper<TUserEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("client_id",id);
        TUserEntity tUserEntity = tUserDao.selectOne(queryWrapper);
        if(tUserEntity!=null){
            return tUserEntity.getClientPassword();
        }
        return null;


    }




    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:tuser:save")
    public R save(@RequestBody TUserEntity tUser){
		tUserService.save(tUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:tuser:update")
    public R update(@RequestBody TUserEntity tUser){
		tUserService.updateById(tUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:tuser:delete")
    public R delete(@RequestBody Integer[] ids){
		tUserService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
