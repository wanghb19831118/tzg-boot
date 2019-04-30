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
 * @Description: 公司管理
 * @author： jeecg-boot
 * @date：   2019-04-15
 * @version： V1.0
 */
@Data
@TableName("tzg_company")
public class TzgCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**公司ID*/
	@TableId(type = IdType.UUID)
	private java.lang.String id;
	/**公司名称*/
	@Excel(name = "公司名称", width = 15)
	private java.lang.String companyName;
	/**公司简称*/
	@Excel(name = "公司简称", width = 15)
	private java.lang.String companyShort;
	/**公司代码*/
	@Excel(name = "公司代码", width = 15)
	private java.lang.String companyCode;
	/**状态  1/正常,2/冻结*/
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
	/**最后修改人ID*/
	@Excel(name = "最后修改人ID", width = 15)
	private java.lang.String updateBy;
	/**最后修改时间*/
	@Excel(name = "最后修改时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date updateTime;
}
