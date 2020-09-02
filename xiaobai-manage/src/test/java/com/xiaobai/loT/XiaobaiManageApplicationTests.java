package com.xiaobai.loT;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaobai.common.utils.R;
import com.xiaobai.loT.dao.TPaintingDao;
import com.xiaobai.loT.dao.TPaintingTopicDao;
import com.xiaobai.loT.dao.TTopicDao;
import com.xiaobai.loT.entity.TPaintingEntity;
import com.xiaobai.loT.entity.TPaintingTopicEntity;
import com.xiaobai.loT.service.TPaintingService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class XiaobaiManageApplicationTests {
    @Resource
    private TPaintingTopicDao tPaintingTopicDao;
    @Resource
    private TPaintingDao   tPaintingDao;
    @Resource
    private TTopicDao tTopicDao;

    @Test
    void contextLoads() {
//        String arr[] = {"1","2"};
//        List<TPaintingTopicEntity> tPaintingTopicEntities = tPaintingTopicDao.selectBatchIds(Arrays.asList(arr));
//        List<String> paintingUuid = tPaintingTopicEntities.stream().map((p) -> {
//            return p.getPaintingUuid();
//        }).collect(Collectors.toList());
//        System.out.println(paintingUuid);
//        List<String> paintingUuid=new ArrayList<>();
//        paintingUuid.add("1");
//        paintingUuid.add("2");
//        QueryWrapper<TPaintingEntity> queryWrapper=new QueryWrapper<>();
//        queryWrapper.in("data_uuid",paintingUuid);
//        List<TPaintingEntity> tPaintingEntities = tPaintingDao.selectList(queryWrapper);


//        TPaintingEntity tPaintingEntity = tPaintingDao.selectById("1");
//        System.out.println(tPaintingEntity);
        String arr[]={"1","2"};
        int i = tTopicDao.deleteBatchIds(Arrays.asList(arr));
        System.out.println(i);


    }

}
