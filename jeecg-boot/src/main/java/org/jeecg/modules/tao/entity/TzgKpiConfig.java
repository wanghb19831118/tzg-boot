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
 * @Description: 服务指标配置
 * @author： jeecg-boot
 * @date：   2019-04-17
 * @version： V1.0
 */
@Data
@TableName("tzg_kpi_config")
public class TzgKpiConfig implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**指标id*/
	@TableId(type = IdType.UUID)
	private java.lang.String id;
	/**指标名称*/
	@Excel(name = "指标名称", width = 15)
	private java.lang.String kpiName;
	/**指标注解*/
	@Excel(name = "指标注解", width = 15)
	private java.lang.String kpiTitle;
	/**值类型  value值 avg平均值*/
	@Excel(name = "值类型", width = 15)
	private java.lang.String kpiType;
	/**默认指标值*/
	@Excel(name = "默认指标值", width = 15)
	private java.lang.String dfVal;
	/**对应采集的数据字段，用来采集数据后对相应的指标进行判断*/
	@Excel(name = "指标映射", width = 15)
	private java.lang.String keyMap;
	/**平台*/
	@Excel(name = "平台", width = 15)
	private java.lang.String platform;
	/**默认分值计算公式*/
	@Excel(name = "默认分值计算公式", width = 15)
	private java.lang.String scoreFormula;
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
