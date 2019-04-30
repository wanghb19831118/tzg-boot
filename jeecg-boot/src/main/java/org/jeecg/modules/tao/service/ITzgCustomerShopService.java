package org.jeecg.modules.tao.service;

import org.jeecg.modules.tao.entity.TzgCustomerShop;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.tao.entity.TzgShopKpi;
import org.jeecg.modules.tao.entity.TzgShopServiceAccount;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 店铺信息
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
public interface ITzgCustomerShopService extends IService<TzgCustomerShop> {

	public List<TzgCustomerShop> selectByMainId(String mainId);

	/**
	 * 添加一对多
	 *
	 */
	public void saveMain(TzgCustomerShop tzgCustomerShop, List<TzgShopServiceAccount> tzgShopServiceAccountList, List<TzgShopKpi> tzgShopKpiList) ;

	/**
	 * 修改一对多
	 *
	 */
	public void updateMain(TzgCustomerShop tzgCustomerShop, List<TzgShopServiceAccount> tzgShopServiceAccountList, List<TzgShopKpi> tzgShopKpiList);

	/**
	 * 删除一对多
	 */
	public void delMain (String id);

	/**
	 * 批量删除一对多
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);

}
