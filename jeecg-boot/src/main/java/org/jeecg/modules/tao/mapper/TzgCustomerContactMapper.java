package org.jeecg.modules.tao.mapper;

import java.util.List;
import org.jeecg.modules.tao.entity.TzgCustomerContact;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 联系人
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
public interface TzgCustomerContactMapper extends BaseMapper<TzgCustomerContact> {

	public boolean deleteByMainId(String mainId);
    
	public List<TzgCustomerContact> selectByMainId(String mainId);
}
