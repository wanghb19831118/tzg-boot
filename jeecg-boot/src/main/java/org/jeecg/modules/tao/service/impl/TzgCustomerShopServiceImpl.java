package org.jeecg.modules.tao.service.impl;

import org.jeecg.modules.tao.entity.TzgCustomerShop;
import org.jeecg.modules.tao.entity.TzgShopKpi;
import org.jeecg.modules.tao.entity.TzgShopServiceAccount;
import org.jeecg.modules.tao.mapper.TzgCustomerShopMapper;
import org.jeecg.modules.tao.mapper.TzgShopKpiMapper;
import org.jeecg.modules.tao.mapper.TzgShopServiceAccountMapper;
import org.jeecg.modules.tao.service.ITzgCustomerShopService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 店铺信息
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
@Service
public class TzgCustomerShopServiceImpl extends ServiceImpl<TzgCustomerShopMapper, TzgCustomerShop> implements ITzgCustomerShopService {
	
	@Autowired
	private TzgCustomerShopMapper tzgCustomerShopMapper;
	
	@Override
	public List<TzgCustomerShop> selectByMainId(String mainId) {
		return tzgCustomerShopMapper.selectByMainId(mainId);
	}

	@Autowired
	private TzgShopServiceAccountMapper tzgShopServiceAccountMapper;
	@Autowired
	private TzgShopKpiMapper tzgShopKpiMapper;

	@Override
	@Transactional
	public void saveMain(TzgCustomerShop tzgCustomerShop, List<TzgShopServiceAccount> tzgShopServiceAccountList, List<TzgShopKpi> tzgShopKpiList) {
		tzgCustomerShopMapper.insert(tzgCustomerShop);
		for(TzgShopServiceAccount entity: tzgShopServiceAccountList) {
			//外键设置
			entity.setShopId(tzgCustomerShop.getId());
			entity.setCustomerId(tzgCustomerShop.getCustomerId());
			tzgShopServiceAccountMapper.insert(entity);
		}
		for(TzgShopKpi entity: tzgShopKpiList) {
			//外键设置
			entity.setShopId(tzgCustomerShop.getId());
			entity.setCustomerId(tzgCustomerShop.getCustomerId());
			tzgShopKpiMapper.insert(entity);
		}
	}

	@Override
	@Transactional
	public void updateMain(TzgCustomerShop tzgCustomerShop, List<TzgShopServiceAccount> tzgShopServiceAccountList, List<TzgShopKpi> tzgShopKpiList) {
		tzgCustomerShopMapper.updateById(tzgCustomerShop);

		//1.先删除子表数据
		tzgShopServiceAccountMapper.deleteByMainId(tzgCustomerShop.getId());
		tzgShopKpiMapper.deleteByMainId(tzgCustomerShop.getId());

		//2.子表数据重新插入
		for(TzgShopServiceAccount entity: tzgShopServiceAccountList) {
			//外键设置
			entity.setShopId(tzgCustomerShop.getId());
			entity.setCustomerId(tzgCustomerShop.getCustomerId());
			tzgShopServiceAccountMapper.insert(entity);
		}
		for(TzgShopKpi entity: tzgShopKpiList) {
			//外键设置
			entity.setShopId(tzgCustomerShop.getId());
			entity.setCustomerId(tzgCustomerShop.getCustomerId());
			tzgShopKpiMapper.insert(entity);
		}
	}

	@Override
	@Transactional
	public void delMain(String id) {
		tzgCustomerShopMapper.deleteById(id);
		tzgShopServiceAccountMapper.deleteByMainId(id);
		tzgShopKpiMapper.deleteByMainId(id);
	}

	@Override
	@Transactional
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			tzgCustomerShopMapper.deleteById(id);
			tzgShopServiceAccountMapper.deleteByMainId(id.toString());
			tzgShopKpiMapper.deleteByMainId(id.toString());
		}
	}
}
