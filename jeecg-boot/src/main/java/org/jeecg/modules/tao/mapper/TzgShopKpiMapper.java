package org.jeecg.modules.tao.mapper;

import java.util.List;
;
import org.jeecg.modules.tao.entity.TzgShopKpi;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 店铺指标
 * @author： jeecg-boot
 * @date：   2019-04-17
 * @version： V1.0
 */
public interface TzgShopKpiMapper extends BaseMapper<TzgShopKpi> {

	public boolean deleteByMainId(String mainId);
    
	public List<TzgShopKpi> selectByMainId(String mainId);
}
