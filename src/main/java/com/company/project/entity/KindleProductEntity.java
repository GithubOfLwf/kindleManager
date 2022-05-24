package com.company.project.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.company.project.entity.BaseEntity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2022-05-02 16:56:44
 */
@Data
@TableName("kindle_product")
public class KindleProductEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId("id")
	private Long id;

	/**
	 * 商品id
	 */
	@TableField("pid")
	private String pid;

	/**
	 * 商品名称
	 */
	@TableField("name")
	private String name;

	/**
	 * 销量
	 */
	@TableField("sale_num")
	private Long saleNum;

	@TableField("reviews_rating")
	private BigDecimal reviewsRating;

	/**
	 * 类别
	 */
	@TableField("categories")
	private String categories;

	/**
	 * 制造商
	 */
	@TableField("manufacturer")
	private String manufacturer;

	/**
	 * 产品编号
	 */
	@TableField("asins")
	private String asins;

	@TableField(exist = false)
	private Integer top;


}
