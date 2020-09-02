package com.xiaobai.loT.controller;

import com.xiaobai.common.utils.R;
import com.xiaobai.loT.service.TPaintingService;
import com.xiaobai.loT.vo.TPaintingTopicVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("loT/image")
public class TImageController {

    @Resource
    private TPaintingService tPaintingService;

    /**
     * 图片的上传
     */
    @RequestMapping("/pic/upload")
    public R upload(MultipartFile uploadFile, @RequestBody TPaintingTopicVo tpaintingEntity) {

        return tPaintingService.upload(uploadFile,tpaintingEntity);
    }
    /**
     * 下载
     */
    @RequestMapping("/pic/download")
    public  R  downloadPic(String uuid,String path){

        return  tPaintingService.downloadPic(uuid,path);
    }


}
