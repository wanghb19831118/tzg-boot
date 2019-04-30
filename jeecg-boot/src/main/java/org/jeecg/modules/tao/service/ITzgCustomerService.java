package org.jeecg.modules.tao.service;

import org.jeecg.modules.tao.entity.TzgCustomerShop;
import org.jeecg.modules.tao.entity.TzgCustomerContact;
import org.jeecg.modules.tao.entity.TzgCustomerCashAccount;
import org.jeecg.modules.tao.entity.TzgCustomer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 客户信息
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
public interface ITzgCustomerService extends IService<TzgCustomer> {

	/**
	 * 添加一对多
	 * 
	 */
	public void saveMain(TzgCustomer tzgCustomer, List<TzgCustomerShop> tzgCustomerShopList, List<TzgCustomerContact> tzgCustomerContactList, List<TzgCustomerCashAccount> tzgCustomerCashAccountList) ;
	
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(TzgCustomer tzgCustomer, List<TzgCustomerShop> tzgCustomerShopList, List<TzgCustomerContact> tzgCustomerContactList, List<TzgCustomerCashAccount> tzgCustomerCashAccountList);
	
	/**
	 * 删除一对多
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);
	
}
