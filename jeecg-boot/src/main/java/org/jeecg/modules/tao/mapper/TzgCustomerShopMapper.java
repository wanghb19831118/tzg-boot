package org.jeecg.modules.tao.mapper;

import java.util.List;
import org.jeecg.modules.tao.entity.TzgCustomerShop;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 店铺信息
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
public interface TzgCustomerShopMapper extends BaseMapper<TzgCustomerShop> {

	public boolean deleteByMainId(String mainId);
    
	public List<TzgCustomerShop> selectByMainId(String mainId);
}
