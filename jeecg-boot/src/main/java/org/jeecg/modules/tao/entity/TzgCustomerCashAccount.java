package org.jeecg.modules.tao.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Description: 银行卡
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
@Data
@TableName("tzg_customer_cash_account")
public class TzgCustomerCashAccount implements Serializable {
    private static final long serialVersionUID = 1L;

	/**客户资金账户ID*/
	@TableId(type = IdType.UUID)
	private java.lang.String id;
	/**客户ID*/
    @Excel(name = "客户ID", width = 15)
	private java.lang.String customerId;
	/**账户名称*/
    @Excel(name = "账户名称", width = 15)
	private java.lang.String accountName;
	/**账号*/
    @Excel(name = "账号", width = 15)
	private java.lang.String accountNo;
	/**开户机构
中农工建等银行
第三方支付平台*/
    @Excel(name = "开户机构", width = 15)
	private java.lang.String accountInst;
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
}
