package org.jeecg.modules.tao.service;

import org.jeecg.modules.tao.entity.TzgCustomerCashAccount;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 银行卡
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
public interface ITzgCustomerCashAccountService extends IService<TzgCustomerCashAccount> {

	public List<TzgCustomerCashAccount> selectByMainId(String mainId);
}
