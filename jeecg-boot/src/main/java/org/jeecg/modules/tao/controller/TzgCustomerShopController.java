package org.jeecg.modules.tao.controller;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.modules.tao.entity.TzgCustomerShop;
import org.jeecg.modules.tao.entity.TzgShopKpi;
import org.jeecg.modules.tao.entity.TzgShopServiceAccount;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.tao.vo.TzgCustomerShopPage;
import org.jeecg.modules.tao.service.ITzgCustomerShopService;
import org.jeecg.modules.tao.service.ITzgShopServiceAccountService;
import org.jeecg.modules.tao.service.ITzgShopKpiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSON;

 /**
 * @Title: Controller
 * @Description: 店铺信息
 * @author： jeecg-boot
 * @date：   2019-04-17
 * @version： V1.0
 */
@RestController
@RequestMapping("/tao/tzgCustomerShop")
@Slf4j
public class TzgCustomerShopController {
	@Autowired
	private ITzgCustomerShopService tzgCustomerShopService;
	@Autowired
	private ITzgShopServiceAccountService tzgShopServiceAccountService;
	@Autowired
	private ITzgShopKpiService tzgShopKpiService;
//	@Autowired
//	private ITzgShopKpiService tzgShopKpiService;
	
	/**
	  * 分页列表查询
	 * @param tzgCustomerShop
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<IPage<TzgCustomerShop>> queryPageList(TzgCustomerShop tzgCustomerShop,
														@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
														@RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
														HttpServletRequest req) {
		Result<IPage<TzgCustomerShop>> result = new Result<IPage<TzgCustomerShop>>();
		QueryWrapper<TzgCustomerShop> queryWrapper = QueryGenerator.initQueryWrapper(tzgCustomerShop, req.getParameterMap());
		Page<TzgCustomerShop> page = new Page<TzgCustomerShop>(pageNo, pageSize);
		IPage<TzgCustomerShop> pageList = tzgCustomerShopService.page(page, queryWrapper);
		result.setSuccess(true);
		result.setResult(pageList);
		return result;
	}
	
	/**
	  *   添加
	 * @param tzgCustomerShopPage
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<TzgCustomerShop> add(@RequestBody TzgCustomerShopPage tzgCustomerShopPage) {
		Result<TzgCustomerShop> result = new Result<TzgCustomerShop>();
		try {
			TzgCustomerShop tzgCustomerShop = new TzgCustomerShop();
			BeanUtils.copyProperties(tzgCustomerShopPage, tzgCustomerShop);
			
			tzgCustomerShopService.saveMain(tzgCustomerShop, tzgCustomerShopPage.getTzgShopServiceAccountList(), tzgCustomerShopPage.getTzgShopKpiList());
			result.success("添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			result.error500("操作失败");
		}
		return result;
	}
	
	/**
	  *  编辑
	 * @param tzgCustomerShopPage
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<TzgCustomerShop> edit(@RequestBody TzgCustomerShopPage tzgCustomerShopPage) {
		Result<TzgCustomerShop> result = new Result<TzgCustomerShop>();
		TzgCustomerShop tzgCustomerShop = new TzgCustomerShop();
		BeanUtils.copyProperties(tzgCustomerShopPage, tzgCustomerShop);
		TzgCustomerShop tzgCustomerShopEntity = tzgCustomerShopService.getById(tzgCustomerShop.getId());
		if(tzgCustomerShopEntity ==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = tzgCustomerShopService.updateById(tzgCustomerShop);
			tzgCustomerShopService.updateMain(tzgCustomerShop, tzgCustomerShopPage.getTzgShopServiceAccountList(), tzgCustomerShopPage.getTzgShopKpiList());
			result.success("修改成功!");
		}
		
		return result;
	}
	
	/**
	  *   通过id删除
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete")
	public Result<TzgCustomerShop> delete(@RequestParam(name="id",required=true) String id) {
		Result<TzgCustomerShop> result = new Result<TzgCustomerShop>();
		TzgCustomerShop tzgCustomerShop = tzgCustomerShopService.getById(id);
		if(tzgCustomerShop ==null) {
			result.error500("未找到对应实体");
		}else {
			tzgCustomerShopService.delMain(id);
			result.success("删除成功!");
		}
		
		return result;
	}
	
	/**
	  *  批量删除
	 * @param ids
	 * @return
	 */
	@DeleteMapping(value = "/deleteBatch")
	public Result<TzgCustomerShop> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<TzgCustomerShop> result = new Result<TzgCustomerShop>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.tzgCustomerShopService.delBatchMain(Arrays.asList(ids.split(",")));
			result.success("删除成功!");
		}
		return result;
	}
	
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/queryById")
	public Result<TzgCustomerShop> queryById(@RequestParam(name="id",required=true) String id) {
		Result<TzgCustomerShop> result = new Result<TzgCustomerShop>();
		TzgCustomerShop tzgCustomerShop = tzgCustomerShopService.getById(id);
		if(tzgCustomerShop ==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(tzgCustomerShop);
			result.setSuccess(true);
		}
		return result;
	}
	
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/queryTzgShopServiceAccountByMainId")
	public Result<List<TzgShopServiceAccount>> queryTzgShopServiceAccountListByMainId(@RequestParam(name="id",required=true) String id) {
		Result<List<TzgShopServiceAccount>> result = new Result<List<TzgShopServiceAccount>>();
		List<TzgShopServiceAccount> tzgShopServiceAccountList = tzgShopServiceAccountService.selectByMainId(id);
		result.setResult(tzgShopServiceAccountList);
		result.setSuccess(true);
		return result;
	}
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/queryTzgShopKpiByMainId")
	public Result<List<TzgShopKpi>> queryTzgShopKpiListByMainId(@RequestParam(name="id",required=true) String id) {
		Result<List<TzgShopKpi>> result = new Result<List<TzgShopKpi>>();
		List<TzgShopKpi> tzgShopKpiList = tzgShopKpiService.selectByMainId(id);
		result.setResult(tzgShopKpiList);
		result.setSuccess(true);
		return result;
	}

  /**
      * 导出excel
   *
   * @param request
   * @param response
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, HttpServletResponse response) {
      // Step.1 组装查询条件
      QueryWrapper<TzgCustomerShop> queryWrapper = null;
      try {
          String paramsStr = request.getParameter("paramsStr");
          if (oConvertUtils.isNotEmpty(paramsStr)) {
              String deString = URLDecoder.decode(paramsStr, "UTF-8");
              TzgCustomerShop tzgCustomerShop = JSON.parseObject(deString, TzgCustomerShop.class);
              queryWrapper = QueryGenerator.initQueryWrapper(tzgCustomerShop, request.getParameterMap());
          }
      } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
      }

      //Step.2 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      List<TzgCustomerShopPage> pageList = new ArrayList<TzgCustomerShopPage>();
      List<TzgCustomerShop> tzgCustomerShopList = tzgCustomerShopService.list(queryWrapper);
      for (TzgCustomerShop tzgCustomerShop : tzgCustomerShopList) {
          TzgCustomerShopPage vo = new TzgCustomerShopPage();
          BeanUtils.copyProperties(tzgCustomerShop, vo);
          List<TzgShopServiceAccount> tzgShopServiceAccountList = tzgShopServiceAccountService.selectByMainId(tzgCustomerShop.getId());
          vo.setTzgShopServiceAccountList(tzgShopServiceAccountList);
          List<TzgShopKpi> tzgShopKpiList = tzgShopKpiService.selectByMainId(tzgCustomerShop.getId());
          vo.setTzgShopKpiList(tzgShopKpiList);
          pageList.add(vo);
      }
      //导出文件名称
      mv.addObject(NormalExcelConstants.FILE_NAME, "店铺信息列表");
      mv.addObject(NormalExcelConstants.CLASS, TzgCustomerShopPage.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("店铺信息列表数据", "导出人:Jeecg", "导出信息"));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
  }

  /**
      * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
  public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          MultipartFile file = entity.getValue();// 获取上传文件对象
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<TzgCustomerShopPage> list = ExcelImportUtil.importExcel(file.getInputStream(), TzgCustomerShopPage.class, params);
              for (TzgCustomerShopPage page : list) {
                  TzgCustomerShop po = new TzgCustomerShop();
                  BeanUtils.copyProperties(page, po);
                  tzgCustomerShopService.saveMain(po, page.getTzgShopServiceAccountList(),page.getTzgShopKpiList());
              }
              return Result.ok("文件导入成功！数据行数：" + list.size());
          } catch (Exception e) {
              log.error(e.getMessage());
              return Result.error("文件导入失败！");
          } finally {
              try {
                  file.getInputStream().close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      return Result.ok("文件导入失败！");
  }

}
