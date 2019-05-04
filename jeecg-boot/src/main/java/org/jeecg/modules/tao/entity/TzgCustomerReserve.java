package org.jeecg.modules.tao.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Description: 储备客户表
 * @author： jeecg-boot
 * @date：   2019-04-30
 * @version： V1.0
 */
@Data
@TableName("tzg_customer_reserve")
public class TzgCustomerReserve implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**id*/
	@TableId(type = IdType.UUID)
	private java.lang.String id;
	/**负责人id*/
//	@Excel(name = "负责人id", width = 15)
	private java.lang.String userid;
	/**负责人姓名*/
//	@Excel(name = "负责人姓名", width = 15)
	private java.lang.String username;
	/**店铺名称*/
	@Excel(name = "店铺名称", width = 15)
	private java.lang.String shopname;
	/**店铺链接*/
	@Excel(name = "店铺链接", width = 15)
	private java.lang.String shopurl;
	/**店家旺旺*/
	@Excel(name = "店家旺旺", width = 15)
	private java.lang.String accountW;
	/**信用*/
	@Excel(name = "信用", width = 15)
	private java.lang.String credit;
	/**好评率*/
	@Excel(name = "好评率", width = 15)
	private java.lang.String favorableRate;
	/**描述相符DSR*/
	@Excel(name = "描述相符DSR", width = 15)
	private java.lang.String dsr;
	/**所在地*/
	@Excel(name = "所在地", width = 15)
	private java.lang.String address;
	/**商品数*/
	@Excel(name = "商品数", width = 15)
	private java.lang.Integer productNum;
	/**月销笔数*/
	@Excel(name = "月销笔数", width = 15)
	private java.lang.Integer saleMonthNum;
	/**开店时间*/
	@Excel(name = "开店时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createShopTime;
	/**客服电话*/
	@Excel(name = "客服电话", width = 15)
	private java.lang.String servicePhone;
	/**收藏数*/
	@Excel(name = "收藏数", width = 15)
	private java.lang.Integer collectionNum;
	/**分析*/
	@Excel(name = "分析", width = 15)
	private java.lang.String analysisUrl;
	/**监控*/
	@Excel(name = "监控", width = 15)
	private java.lang.String monitorUrl;
	/**创建人*/
//	@Excel(name = "创建人", width = 15)
	private java.lang.String createBy;
	/**创建时间*/
//	@Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;
	/**修改人*/
//	@Excel(name = "修改人", width = 15)
	private java.lang.String updateBy;
	/**修改时间*/
//	@Excel(name = "修改时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateTime;
}
