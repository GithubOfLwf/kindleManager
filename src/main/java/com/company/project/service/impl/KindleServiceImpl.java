package com.company.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.company.project.mapper.KindleMapper;
import com.company.project.entity.KindleEntity;
import com.company.project.service.KindleService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("kindleService")
public class KindleServiceImpl extends ServiceImpl<KindleMapper, KindleEntity> implements KindleService {

    @Resource
    private KindleMapper kindleMapper;
    /**
     * 获取月份
     *
     * @param startDate
     * @param endDate
     * @return java.util.List<java.lang.String>
     * @param: startDate
     * @param: endTime
     * @date 2022/5/2 19:57
     * @version 1.0.0
     */
    @Override
    public List<Map<String,Object>> listMonth(String startDate, String endDate) {
        return kindleMapper.listMonth(startDate,endDate);
    }
}