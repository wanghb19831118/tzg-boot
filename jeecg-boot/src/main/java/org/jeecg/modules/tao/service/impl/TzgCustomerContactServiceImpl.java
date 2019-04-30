package org.jeecg.modules.tao.service.impl;

import org.jeecg.modules.tao.entity.TzgCustomerContact;
import org.jeecg.modules.tao.mapper.TzgCustomerContactMapper;
import org.jeecg.modules.tao.service.ITzgCustomerContactService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 联系人
 * @author： jxq
 * @date：   2019-04-16
 * @version： V1.0
 */
@Service
public class TzgCustomerContactServiceImpl extends ServiceImpl<TzgCustomerContactMapper, TzgCustomerContact> implements ITzgCustomerContactService {
	
	@Autowired
	private TzgCustomerContactMapper tzgCustomerContactMapper;
	
	@Override
	public List<TzgCustomerContact> selectByMainId(String mainId) {
		return tzgCustomerContactMapper.selectByMainId(mainId);
	}
}
