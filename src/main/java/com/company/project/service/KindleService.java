package com.company.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.company.project.entity.KindleEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2022-04-17 09:58:10
 */
public interface KindleService extends IService<KindleEntity> {

    /**
     * 获取月份
     * @param: startDate
     * @param: endTime
     * @author Wenfei.Li
     * @date 2022/5/2 19:57
     * @version 1.0.0
     * @return java.util.List<java.lang.String>
     **/
    List<Map<String,Object>> listMonth(String startDate, String endTime);

}

