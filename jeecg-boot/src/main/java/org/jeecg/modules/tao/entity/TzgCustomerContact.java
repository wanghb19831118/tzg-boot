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
 * @Description: 联系人
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
@Data
@TableName("tzg_customer_contact")
public class TzgCustomerContact implements Serializable {
    private static final long serialVersionUID = 1L;

	/**联系人ID*/
	@TableId(type = IdType.UUID)
	private java.lang.String id;
	/**客户ID*/
	private java.lang.String customerId;
	/**姓名*/
    @Excel(name = "姓名", width = 15)
	private java.lang.String name;
	/**职务
总经理
运营
掌柜
人资
客服*/
    @Excel(name = "职务", width = 15)
	private java.lang.String duty;
	/**电话*/
    @Excel(name = "电话", width = 15)
	private java.lang.String phone;
	/**移动电话*/
    @Excel(name = "移动电话", width = 15)
	private java.lang.String mobile;
	/**固定电话*/
    @Excel(name = "固定电话", width = 15)
	private java.lang.String telephone;
	/**QQ*/
    @Excel(name = "QQ", width = 15)
	private java.lang.String qq;
	/**电子邮箱*/
    @Excel(name = "电子邮箱", width = 15)
	private java.lang.String email;
	/**微信*/
    @Excel(name = "微信", width = 15)
	private java.lang.String wechat;
	/**备注*/
    @Excel(name = "备注", width = 15)
	private java.lang.String mark;
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
