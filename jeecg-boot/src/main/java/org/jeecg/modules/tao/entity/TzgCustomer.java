package org.jeecg.modules.tao.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description: 客户信息
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
@Data
@TableName("tzg_customer")
public class TzgCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**客户ID*/
	@TableId(type = IdType.UUID)
	private java.lang.String id;
	/**客户名称*/
	private java.lang.String name;
	/**客户类型
0-个人
1-公司*/
	private java.lang.Integer custType;
	/**证照类型
企业注册号
统一社会信用代码
身份证
军官证
驾驶证*/
	private java.lang.String certType;
	/**证照信息*/
	private java.lang.String certification;
	/**发票抬头*/
	private java.lang.String invoiceHeader;
	/**所属人ID*/
	private java.lang.String ownerId;
	/**所属人姓名*/
	private java.lang.String ownerName;
	/**状态
0-无效
1-有效*/
	private java.lang.Integer status;
	/**创建人*/
	private java.lang.String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;
	/**修改人*/
	private java.lang.String updateBy;
	/**修改时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateTime;
}
