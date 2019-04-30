package org.jeecg.modules.tao.service;

import org.jeecg.modules.tao.entity.TzgShopServiceAccount;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 店铺账号
 * @author： jeecg-boot
 * @date：   2019-04-17
 * @version： V1.0
 */
public interface ITzgShopServiceAccountService extends IService<TzgShopServiceAccount> {

	public List<TzgShopServiceAccount> selectByMainId(String mainId);
}
