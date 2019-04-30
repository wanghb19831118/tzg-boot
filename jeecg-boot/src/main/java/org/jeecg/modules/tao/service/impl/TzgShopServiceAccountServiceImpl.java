package org.jeecg.modules.tao.service.impl;

import org.jeecg.modules.tao.entity.TzgShopServiceAccount;
import org.jeecg.modules.tao.mapper.TzgShopServiceAccountMapper;
import org.jeecg.modules.tao.service.ITzgShopServiceAccountService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 店铺账号
 * @author： jeecg-boot
 * @date：   2019-04-17
 * @version： V1.0
 */
@Service
public class TzgShopServiceAccountServiceImpl extends ServiceImpl<TzgShopServiceAccountMapper, TzgShopServiceAccount> implements ITzgShopServiceAccountService {
	
	@Autowired
	private TzgShopServiceAccountMapper tzgShopServiceAccountMapper;
	
	@Override
	public List<TzgShopServiceAccount> selectByMainId(String mainId) {
		return tzgShopServiceAccountMapper.selectByMainId(mainId);
	}
}
