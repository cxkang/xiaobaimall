package com.xiaobai.loT.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiaobai.loT.entity.TAppEntity;
import com.xiaobai.loT.service.TAppService;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.common.utils.R;



/**
 * Android App
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@RestController
@RequestMapping("loT/tapp")
public class TAppController {
    @Autowired
    private TAppService tAppService;


    @RequestMapping("/test")
    public R  test(){
        return  R.ok("success");

    }
    /**
     * 列表
     */
    @RequestMapping("/list")
  //  @RequiresPermissions("loT:tapp:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tAppService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("loT:tapp:info")
    public R info(@PathVariable("id") Integer id){
		TAppEntity tApp = tAppService.getById(id);

        return R.ok().put("tApp", tApp);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("loT:tapp:save")
    public R save(@RequestBody TAppEntity tApp){
		tAppService.save(tApp);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("loT:tapp:update")
    public R update(@RequestBody TAppEntity tApp){
		tAppService.updateById(tApp);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("loT:tapp:delete")
    public R delete(@RequestBody Integer[] ids){
		tAppService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
