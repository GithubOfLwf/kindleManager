package com.company.project.mapper;

import com.company.project.entity.KindleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author wenbin
 * @email *****@mail.com
 * @date 2022-04-17 09:58:10
 */
public interface KindleMapper extends BaseMapper<KindleEntity> {

    /**
     * 获取月份数据
     * @param: startDate
     * @param: endDate
     * @date 2022/5/2 20:20
     * @version 1.0.0
     * @return java.util.List<java.lang.String>
     **/
    List<Map<String,Object>> listMonth(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
}
