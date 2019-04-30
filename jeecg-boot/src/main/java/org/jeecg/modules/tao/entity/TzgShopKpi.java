package org.jeecg.modules.tao.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;

/**
 * @Description: 店铺指标
 * @author： jeecg-boot
 * @date：   2019-04-17
 * @version： V1.0
 */
@Data
@TableName("tzg_shop_kpi")
public class TzgShopKpi implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**店铺服务指标*/
	@TableId(type = IdType.UUID)
	private String id;
	/**客户ID*/
    @Excel(name = "客户ID", width = 15)
	private String customerId;
	/**店铺ID*/
    @Excel(name = "店铺ID", width = 15)
	private String shopId;
	/**指标id*/
    @Excel(name = "指标id", width = 15)
	private String kpiId;
	/**指标值*/
    @Excel(name = "指标值", width = 15)
	private Integer kpiVal;
	/**分值计算公式*/
    @Excel(name = "分值计算公式", width = 15)
	private String scoreFormula;
	/**状态：0无效；1有效*/
    @Excel(name = "状态：0无效；1有效", width = 15)
	private Integer status;
	/**创建人*/
    @Excel(name = "创建人", width = 15)
	private String createBy;
	/**创建时间*/
	@Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**修改人*/
    @Excel(name = "修改人", width = 15)
	private String updateBy;
	/**修改时间*/
	@Excel(name = "修改时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
}
