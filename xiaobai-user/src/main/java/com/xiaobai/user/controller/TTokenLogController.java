package com.xiaobai.user.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiaobai.user.entity.TTokenLogEntity;
import com.xiaobai.user.service.TTokenLogService;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.common.utils.R;



/**
 * Token日志表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 19:32:04
 */
@RestController
@RequestMapping("user/ttokenlog")
public class TTokenLogController {
    @Autowired
    private TTokenLogService tTokenLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
  //  @RequiresPermissions("user:ttokenlog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tTokenLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("user:ttokenlog:info")
    public R info(@PathVariable("id") Integer id){
		TTokenLogEntity tTokenLog = tTokenLogService.getById(id);

        return R.ok().put("tTokenLog", tTokenLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("user:ttokenlog:save")
    public R save(@RequestBody TTokenLogEntity tTokenLog){
		tTokenLogService.save(tTokenLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("user:ttokenlog:update")
    public R update(@RequestBody TTokenLogEntity tTokenLog){
		tTokenLogService.updateById(tTokenLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("user:ttokenlog:delete")
    public R delete(@RequestBody Integer[] ids){
		tTokenLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
