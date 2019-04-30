package org.jeecg.modules.tao.service;

import org.jeecg.modules.tao.entity.TzgShopKpi;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 店铺指标
 * @author： jeecg-boot
 * @date：   2019-04-17
 * @version： V1.0
 */

public interface ITzgShopKpiService extends IService<TzgShopKpi> {

	public List<TzgShopKpi> selectByMainId(String mainId);
}
