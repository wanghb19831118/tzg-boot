package org.jeecg.modules.tao.vo;

import java.util.List;

import org.jeecg.modules.tao.entity.TzgCustomerShop;
import org.jeecg.modules.tao.entity.TzgCustomerContact;
import org.jeecg.modules.tao.entity.TzgCustomerCashAccount;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class TzgCustomerPage {

	/**客户ID*/
	private java.lang.String id;
	/**客户名称*/
  	@Excel(name = "客户名称", width = 15)
	private java.lang.String name;
	/**客户类型
0-个人
1-公司*/
  	@Excel(name = "客户类型", width = 15)
	private java.lang.Integer custType;
	/**证照类型
企业注册号
统一社会信用代码
身份证
军官证
驾驶证*/
  	@Excel(name = "证照类型", width = 15)
	private java.lang.String certType;
	/**证照信息*/
  	@Excel(name = "证照信息", width = 15)
	private java.lang.String certification;
	/**发票抬头*/
  	@Excel(name = "发票抬头", width = 15)
	private java.lang.String invoiceHeader;
	/**所属人ID*/
  	@Excel(name = "所属人ID", width = 15)
	private java.lang.String ownerId;
	/**所属人姓名*/
  	@Excel(name = "所属人姓名", width = 15)
	private java.lang.String ownerName;
	/**状态
0-无效
1-有效*/
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
	private java.util.Date updateTime;

	@ExcelCollection(name="店铺信息")
	private List<TzgCustomerShop> tzgCustomerShopList;
	@ExcelCollection(name="联系人")
	private List<TzgCustomerContact> tzgCustomerContactList;
	@ExcelCollection(name="银行卡")
	private List<TzgCustomerCashAccount> tzgCustomerCashAccountList;
	
}
