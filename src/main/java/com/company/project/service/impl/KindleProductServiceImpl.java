package com.company.project.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.company.project.mapper.KindleProductMapper;
import com.company.project.entity.KindleProductEntity;
import com.company.project.service.KindleProductService;


@Service("kindleProductService")
public class KindleProductServiceImpl extends ServiceImpl<KindleProductMapper, KindleProductEntity> implements KindleProductService {


}