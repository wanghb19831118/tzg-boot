package org.jeecg.modules.tao.mapper;

import java.util.List;
import org.jeecg.modules.tao.entity.TzgShopServiceAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 店铺账号
 * @author： jeecg-boot
 * @date：   2019-04-17
 * @version： V1.0
 */
public interface TzgShopServiceAccountMapper extends BaseMapper<TzgShopServiceAccount> {

	public boolean deleteByMainId(String mainId);
    
	public List<TzgShopServiceAccount> selectByMainId(String mainId);
}
