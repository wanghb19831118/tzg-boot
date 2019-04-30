package org.jeecg.modules.tao.service;

import org.jeecg.modules.tao.entity.TzgCustomerContact;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 联系人
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
public interface ITzgCustomerContactService extends IService<TzgCustomerContact> {

	public List<TzgCustomerContact> selectByMainId(String mainId);
}
