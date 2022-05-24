package com.company.project.controller.kindle;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.company.project.dto.PreviewDateQueryDto;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import java.util.Map;

import com.company.project.common.utils.DataResult;

import com.company.project.entity.KindleEntity;
import com.company.project.service.KindleService;



/**
 * 
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2022-04-17 09:58:10
 */
@RestController
@RequestMapping("/")
public class KindleController {
    @Autowired
    private KindleService kindleService;

    @ApiOperation(value = "新增")
    @PostMapping("kindle/add")
    @RequiresPermissions("kindle:add")
    @ResponseBody
    public DataResult add(@RequestBody KindleEntity kindle){
        kindleService.save(kindle);
        return DataResult.success();
    }

    @DeleteMapping("kindle/delete/{id}")
    @RequiresPermissions("kindle:delete")
    public DataResult delete(@PathVariable("id") String id){
        if(StringUtils.isNotBlank(id)){
            kindleService.removeById(id);
        }
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("kindle/update")
    @RequiresPermissions("kindle:update")
    @ResponseBody
    public DataResult update(@RequestBody KindleEntity kindle){
        kindleService.updateById(kindle);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("kindle/listByPage")
    @RequiresPermissions("kindle:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody KindleEntity kindle){
        Page page = new Page(kindle.getPage(), kindle.getLimit());
        LambdaQueryWrapper<KindleEntity> queryWrapper = Wrappers.lambdaQuery();
        //产品名称
        if(StringUtils.isNotBlank(kindle.getName())){
            queryWrapper.like(KindleEntity::getName, kindle.getName());
        }
        //用户名称
        if(StringUtils.isNotBlank(kindle.getReviewsUsername())){
            queryWrapper.eq(KindleEntity::getReviewsUsername, kindle.getReviewsUsername());
        }
        //评分
        if(StringUtils.isNotBlank(kindle.getReviewsRating())){
            queryWrapper.eq(KindleEntity::getReviewsRating, kindle.getReviewsRating());
        }
         //年限
        if(StringUtils.isNotBlank(kindle.getReviewsDate())){
            queryWrapper.like(KindleEntity::getReviewsDate, kindle.getReviewsDate());
        }
        queryWrapper.isNotNull(KindleEntity::getName);
        IPage<KindleEntity> iPage = kindleService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }


    @GetMapping("/kindle/previewDate")
    public DataResult dataMonth(PreviewDateQueryDto queryDto){
        List<Map<String,Object>> monthList = kindleService.listMonth(queryDto.getStartDate(),queryDto.getEndDate());
        return DataResult.success(monthList);
    }

}
