package org.jeecg.modules.tao.vo;

import java.util.List;

import org.jeecg.modules.tao.entity.TzgShopServiceAccount;
import org.jeecg.modules.tao.entity.TzgShopKpi;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
public class TzgCustomerShopPage {
	
	/**店铺ID*/
	private String id;
	/**客户ID*/
  	@Excel(name = "客户ID", width = 15)
	private String customerId;
	/**店铺名称*/
  	@Excel(name = "店铺名称", width = 15)
	private String name;
	/**URL*/
  	@Excel(name = "URL", width = 15)
	private String url;
	/**平台：
淘宝
天猫
京东
一号店
亚马逊
自营
客户自营*/
  	@Excel(name = "平台", width = 15)
	private java.lang.String platform;
	/**掌柜*/
  	@Excel(name = "掌柜", width = 15)
	private java.lang.String master;
	/**旺旺号/京东号等等*/
  	@Excel(name = "旺旺号/京东号等等", width = 15)
	private java.lang.String nick;
	/**绩效软件*/
  	@Excel(name = "绩效软件", width = 15)
	private java.lang.String dataSoft;
	/**绩效软件账号*/
  	@Excel(name = "绩效软件账号", width = 15)
	private java.lang.String dataNick;
	/**绩效软件账号密码*/
  	@Excel(name = "绩效软件账号密码", width = 15)
	private java.lang.String dataPwd;
	/**状态
0-未注册
1-正常
2-已关店*/
  	@Excel(name = "状态", width = 15)
	private java.lang.Integer status;
	/**创建人*/
  	@Excel(name = "创建人", width = 15)
	private java.lang.String createBy;
	/**创建时间*/
  	@Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
  	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;
	/**修改人*/
  	@Excel(name = "修改人", width = 15)
	private java.lang.String updateBy;
	/**修改时间*/
  	@Excel(name = "修改时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
  	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	@ExcelCollection(name="店铺账号")
	private List<TzgShopServiceAccount> tzgShopServiceAccountList;
	@ExcelCollection(name="店铺指标")
	private List<TzgShopKpi> tzgShopKpiList;
	
}
