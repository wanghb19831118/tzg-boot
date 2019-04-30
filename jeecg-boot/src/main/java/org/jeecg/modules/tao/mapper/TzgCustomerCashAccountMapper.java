package org.jeecg.modules.tao.mapper;

import java.util.List;
import org.jeecg.modules.tao.entity.TzgCustomerCashAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 银行卡
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
public interface TzgCustomerCashAccountMapper extends BaseMapper<TzgCustomerCashAccount> {

	public boolean deleteByMainId(String mainId);
    
	public List<TzgCustomerCashAccount> selectByMainId(String mainId);
}
