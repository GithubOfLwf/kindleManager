package com.company.project.controller.kindle;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
import com.company.project.common.utils.DataResult;
import com.company.project.entity.KindleProductEntity;
import com.company.project.service.KindleProductService;



/**
 * 
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2022-05-02 16:56:44
 */
@Controller
@RequestMapping("/")
public class KindleProductController {
    @Autowired
    private KindleProductService kindleProductService;


    /**
    * 跳转到页面
    */
    @GetMapping("/index/kindleProduct")
    public String kindleProduct() {
        return "kindle/kindle_product_list";
        }

    @ApiOperation(value = "新增")
    @PostMapping("kindleProduct/add")
    @RequiresPermissions("kindleProduct:add")
    @ResponseBody
    public DataResult add(@RequestBody KindleProductEntity kindleProduct){
        kindleProductService.save(kindleProduct);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("kindleProduct/delete")
    @RequiresPermissions("kindleProduct:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids){
        kindleProductService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("kindleProduct/update")
    @RequiresPermissions("kindleProduct:update")
    @ResponseBody
    public DataResult update(@RequestBody KindleProductEntity kindleProduct){
        kindleProductService.updateById(kindleProduct);
        return DataResult.success();
    }

    @ApiOperation(value = "查询分页数据")
    @PostMapping("kindleProduct/listByPage")
    @RequiresPermissions("kindleProduct:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody KindleProductEntity kindleProduct){
        Page page = new Page(kindleProduct.getPage(), kindleProduct.getLimit());
        LambdaQueryWrapper<KindleProductEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
        if(StringUtils.isNotBlank(kindleProduct.getName())){
            queryWrapper.like(KindleProductEntity::getName,kindleProduct.getName());
        }
        if(StringUtils.isNotBlank(kindleProduct.getPid())){
            queryWrapper.eq(KindleProductEntity::getPid,kindleProduct.getPid());
        }
        if(StringUtils.isNotBlank(kindleProduct.getAsins())){
            queryWrapper.like(KindleProductEntity::getAsins,kindleProduct.getAsins());
        }
        if(kindleProduct.getTop() != null){
            page.setSize(kindleProduct.getTop());
            queryWrapper.orderByDesc(KindleProductEntity::getSaleNum);
        }
        IPage<KindleProductEntity> iPage = kindleProductService.page(page, queryWrapper);
        return DataResult.success(iPage);
    }

}
