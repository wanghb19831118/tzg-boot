package org.jeecg.modules.tao.service.impl;

import org.jeecg.modules.tao.entity.TzgCustomerCashAccount;
import org.jeecg.modules.tao.mapper.TzgCustomerCashAccountMapper;
import org.jeecg.modules.tao.service.ITzgCustomerCashAccountService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 银行卡
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
@Service
public class TzgCustomerCashAccountServiceImpl extends ServiceImpl<TzgCustomerCashAccountMapper, TzgCustomerCashAccount> implements ITzgCustomerCashAccountService {
	
	@Autowired
	private TzgCustomerCashAccountMapper tzgCustomerCashAccountMapper;
	
	@Override
	public List<TzgCustomerCashAccount> selectByMainId(String mainId) {
		return tzgCustomerCashAccountMapper.selectByMainId(mainId);
	}
}
