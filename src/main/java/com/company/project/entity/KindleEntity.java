package com.company.project.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.company.project.entity.BaseEntity;


import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.springframework.context.annotation.Primary;

/**
 * 
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2022-04-17 09:58:10
 */
@Data
@TableName("kindle")
public class KindleEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId("id")
	private String id;

	/**
	 *
	 */
	@TableField("pid")
	private String pid;
	/**
	 * 
	 */
	@TableField("name")
	private String name;

	/**
	 * 
	 */
	@TableField("asins")
	private String asins;

	/**
	 * 
	 */
	@TableField("brand")
	private String brand;

	/**
	 * 
	 */
	@TableField("categories")
	private String categories;

	/**
	 * 
	 */
	@TableField("categorie_keys")
	private String categorieKeys;

	/**
	 * 
	 */
	@TableField("manufacturer")
	private String manufacturer;

	/**
	 * 
	 */
	@TableField("reviews_date")
	private String reviewsDate;

	/**
	 * 
	 */
	@TableField("reviews_dateadded")
	private String reviewsDateadded;

	/**
	 * 
	 */
	@TableField("reviews_dateseen")
	private String reviewsDateseen;

	/**
	 * 
	 */
	@TableField("reviews_didpurchase")
	private String reviewsDidpurchase;

	/**
	 * 
	 */
	@TableField("reviews_dorecommend")
	private String reviewsDorecommend;

	/**
	 * 
	 */
	@TableField("reviews_id")
	private String reviewsId;

	/**
	 * 
	 */
	@TableField("reviews_numhelpful")
	private String reviewsNumhelpful;

	/**
	 * 
	 */
	@TableField("reviews_rating")
	private String reviewsRating;

	/**
	 * 
	 */
	@TableField("reviews_sourceurls")
	private String reviewsSourceurls;

	/**
	 * 
	 */
	@TableField("reviews_text")
	private String reviewsText;

	/**
	 * 
	 */
	@TableField("reviews_title")
	private String reviewsTitle;

	/**
	 * 
	 */
	@TableField("reviews_usercity")
	private String reviewsUsercity;

	/**
	 * 
	 */
	@TableField("reviews_userprovince")
	private String reviewsUserprovince;

	/**
	 * 
	 */
	@TableField("reviews_username")
	private String reviewsUsername;

	@TableField(fill = FieldFill.INSERT)
	private Integer deleted;

}
