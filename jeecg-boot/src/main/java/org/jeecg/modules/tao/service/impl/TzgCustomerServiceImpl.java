package org.jeecg.modules.tao.service.impl;

import org.jeecg.modules.tao.entity.TzgCustomer;
import org.jeecg.modules.tao.entity.TzgCustomerShop;
import org.jeecg.modules.tao.entity.TzgCustomerContact;
import org.jeecg.modules.tao.entity.TzgCustomerCashAccount;
import org.jeecg.modules.tao.mapper.TzgCustomerShopMapper;
import org.jeecg.modules.tao.mapper.TzgCustomerContactMapper;
import org.jeecg.modules.tao.mapper.TzgCustomerCashAccountMapper;
import org.jeecg.modules.tao.mapper.TzgCustomerMapper;
import org.jeecg.modules.tao.service.ITzgCustomerService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 客户信息
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
@Service
public class TzgCustomerServiceImpl extends ServiceImpl<TzgCustomerMapper, TzgCustomer> implements ITzgCustomerService {

	@Autowired
	private TzgCustomerMapper tzgCustomerMapper;
	@Autowired
	private TzgCustomerShopMapper tzgCustomerShopMapper;
	@Autowired
	private TzgCustomerContactMapper tzgCustomerContactMapper;
	@Autowired
	private TzgCustomerCashAccountMapper tzgCustomerCashAccountMapper;
	
	@Override
	@Transactional
	public void saveMain(TzgCustomer tzgCustomer, List<TzgCustomerShop> tzgCustomerShopList, List<TzgCustomerContact> tzgCustomerContactList, List<TzgCustomerCashAccount> tzgCustomerCashAccountList) {
		tzgCustomerMapper.insert(tzgCustomer);
		for(TzgCustomerShop entity: tzgCustomerShopList) {
			//外键设置
			entity.setCustomerId(tzgCustomer.getId());
			tzgCustomerShopMapper.insert(entity);
		}
		for(TzgCustomerContact entity: tzgCustomerContactList) {
			//外键设置
			entity.setCustomerId(tzgCustomer.getId());
			tzgCustomerContactMapper.insert(entity);
		}
		for(TzgCustomerCashAccount entity: tzgCustomerCashAccountList) {
			//外键设置
			entity.setCustomerId(tzgCustomer.getId());
			tzgCustomerCashAccountMapper.insert(entity);
		}
	}

	@Override
	@Transactional
	public void updateMain(TzgCustomer tzgCustomer, List<TzgCustomerShop> tzgCustomerShopList, List<TzgCustomerContact> tzgCustomerContactList, List<TzgCustomerCashAccount> tzgCustomerCashAccountList) {
		tzgCustomerMapper.updateById(tzgCustomer);
		
		//1.先删除子表数据
		tzgCustomerShopMapper.deleteByMainId(tzgCustomer.getId());
		tzgCustomerContactMapper.deleteByMainId(tzgCustomer.getId());
		tzgCustomerCashAccountMapper.deleteByMainId(tzgCustomer.getId());
		
		//2.子表数据重新插入
		for(TzgCustomerShop entity: tzgCustomerShopList) {
			//外键设置
			entity.setCustomerId(tzgCustomer.getId());
			tzgCustomerShopMapper.insert(entity);
		}
		for(TzgCustomerContact entity: tzgCustomerContactList) {
			//外键设置
			entity.setCustomerId(tzgCustomer.getId());
			tzgCustomerContactMapper.insert(entity);
		}
		for(TzgCustomerCashAccount entity: tzgCustomerCashAccountList) {
			//外键设置
			entity.setCustomerId(tzgCustomer.getId());
			tzgCustomerCashAccountMapper.insert(entity);
		}
	}

	@Override
	@Transactional
	public void delMain(String id) {
		tzgCustomerMapper.deleteById(id);
		tzgCustomerShopMapper.deleteByMainId(id);
		tzgCustomerContactMapper.deleteByMainId(id);
		tzgCustomerCashAccountMapper.deleteByMainId(id);
	}

	@Override
	@Transactional
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			tzgCustomerMapper.deleteById(id);
			tzgCustomerShopMapper.deleteByMainId(id.toString());
			tzgCustomerContactMapper.deleteByMainId(id.toString());
			tzgCustomerCashAccountMapper.deleteByMainId(id.toString());
		}
	}
	
}
