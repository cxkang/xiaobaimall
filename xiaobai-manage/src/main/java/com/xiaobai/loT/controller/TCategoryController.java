package com.xiaobai.loT.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiaobai.loT.entity.TCategoryEntity;
import com.xiaobai.loT.service.TCategoryService;
import com.xiaobai.common.utils.PageUtils;
import com.xiaobai.common.utils.R;



/**
 * 画作分类表
 *
 * @author chen
 * @email sunlightcs@gmail.com
 * @date 2020-08-28 14:01:01
 */
@RestController
@RequestMapping("loT/tcategory")
public class TCategoryController {
    @Autowired
    private TCategoryService tCategoryService;
    /**
     * 分类
     */
    @RequestMapping("/list/tree")
    public R list(){

        List<TCategoryEntity> entities = tCategoryService.listWithTree();


        return R.ok().put("data", entities);
    }




    /**
     * 列表
     */
    @RequestMapping("/list")
  //  @RequiresPermissions("loT:tcategory:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tCategoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("loT:tcategory:info")
    public R info(@PathVariable("id") Integer id){
		TCategoryEntity tCategory = tCategoryService.getById(id);

        return R.ok().put("tCategory", tCategory);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("loT:tcategory:save")
    public R save(@RequestBody TCategoryEntity tCategory){
		tCategoryService.save(tCategory);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("loT:tcategory:update")
    public R update(@RequestBody TCategoryEntity tCategory){
		tCategoryService.updateById(tCategory);

        return R.ok();
    }

    /**
     * 删除  可以用逻辑删除 可用show_status
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("loT:tcategory:delete")
    public R delete(@RequestBody Integer[] ids){
		//tCategoryService.removeByIds(Arrays.asList(ids));
        tCategoryService.reremoveMenuByIds(Arrays.asList(ids));
        return R.ok();
    }

}
