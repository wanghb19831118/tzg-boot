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
 * @Description: 项目列表
 * @author： jeecg-boot
 * @date：   2019-04-15
 * @version： V1.0
 */
@Data
@TableName("tzg_project")
public class TzgProject implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**项目id*/
	@TableId(type = IdType.UUID)
	private String id;
	/**项目名称*/
	@Excel(name = "项目名称", width = 15)
	private String proName;
	/**项目简介*/
	@Excel(name = "项目简介", width = 15)
	private String proDes;
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
