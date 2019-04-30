package org.jeecg;

import java.util.ArrayList;
import java.util.List;

import org.jeecgframework.codegenerate.generate.impl.CodeGenerateOneToMany;
import org.jeecgframework.codegenerate.generate.pojo.onetomany.MainTableVo;
import org.jeecgframework.codegenerate.generate.pojo.onetomany.SubTableVo;

/**
 * 代码生成器入口【一对多】
 * @author 张代浩
 * @site www.jeecg.org
 * 
 */
public class JeecgOneToMainUtil {

	/**
	 * 一对多(父子表)数据模型，生成方法
	 * @param args
	 */
	public static void main(String[] args) {
		//第一步：设置主表配置
//		MainTableVo mainTable = new MainTableVo();
//		mainTable.setTableName("tzg_customer");//表名
//		mainTable.setEntityName("TzgCustomer");	 //实体名
//		mainTable.setEntityPackage("tao");	 //包名
//		mainTable.setFtlDescription("客户信息");	 //描述
//
//		//第二步：设置子表集合配置
//		List<SubTableVo> subTables = new ArrayList<SubTableVo>();
//		//[1].子表一
//		SubTableVo po = new SubTableVo();
//		po.setTableName("tzg_customer_shop");//表名
//		po.setEntityName("TzgCustomerShop");	    //实体名
//		po.setEntityPackage("tao");	        //包名
//		po.setFtlDescription("店铺信息");       //描述
//		//子表外键参数配置
//		/*说明:
//		 * a) 子表引用主表主键ID作为外键，外键字段必须以_ID结尾;
//		 * b) 主表和子表的外键字段名字，必须相同（除主键ID外）;
//		 * c) 多个外键字段，采用逗号分隔;
//		*/
//		po.setForeignKeys(new String[]{"customer_id"});
//		subTables.add(po);
//		//[2].子表二
//		SubTableVo po2 = new SubTableVo();
//		po2.setTableName("tzg_customer_contact");		//表名
//		po2.setEntityName("TzgCustomerContact");			//实体名
//		po2.setEntityPackage("tao"); 				//包名
//		po2.setFtlDescription("联系人");			//描述
//		//子表外键参数配置
//		/*说明:
//		 * a) 子表引用主表主键ID作为外键，外键字段必须以_ID结尾;
//		 * b) 主表和子表的外键字段名字，必须相同（除主键ID外）;
//		 * c) 多个外键字段，采用逗号分隔;
//		*/
//		po2.setForeignKeys(new String[]{"customer_id"});
//		subTables.add(po2);
//
//		//[3].子表三
//		SubTableVo po3 = new SubTableVo();
//		po3.setTableName("tzg_customer_cash_account");		//表名
//		po3.setEntityName("TzgCustomerCashAccount");			//实体名
//		po3.setEntityPackage("tao"); 				//包名
//		po3.setFtlDescription("银行卡");			//描述
//		//子表外键参数配置
//		/*说明:
//		 * a) 子表引用主表主键ID作为外键，外键字段必须以_ID结尾;
//		 * b) 主表和子表的外键字段名字，必须相同（除主键ID外）;
//		 * c) 多个外键字段，采用逗号分隔;
//		 */
//		po3.setForeignKeys(new String[]{"customer_id"});
//		subTables.add(po3);
//		mainTable.setSubTables(subTables);
//
//		//第三步：一对多(父子表)数据模型,代码生成
//		new CodeGenerateOneToMany(mainTable,subTables).generateCodeFile();
		/*======================================================================*/


		//第一步：设置主表配置
		MainTableVo mainTable = new MainTableVo();
		mainTable.setTableName("tzg_customer_shop");//表名
		mainTable.setEntityName("TzgCustomerShop");	 //实体名
		mainTable.setEntityPackage("tao");	 //包名
		mainTable.setFtlDescription("店铺信息");	 //描述

		//第二步：设置子表集合配置
		List<SubTableVo> subTables = new ArrayList<SubTableVo>();
		//[1].子表一
		SubTableVo po = new SubTableVo();
		po.setTableName("tzg_shop_service_account");//表名
		po.setEntityName("TzgShopServiceAccount");	    //实体名
		po.setEntityPackage("tao");	        //包名
		po.setFtlDescription("店铺账号");       //描述
		//子表外键参数配置
		/*说明:
		 * a) 子表引用主表主键ID作为外键，外键字段必须以_ID结尾;
		 * b) 主表和子表的外键字段名字，必须相同（除主键ID外）;
		 * c) 多个外键字段，采用逗号分隔;
		*/
		po.setForeignKeys(new String[]{"shop_id,customer_id"});
		subTables.add(po);
		//[2].子表二
		SubTableVo po2 = new SubTableVo();
		po2.setTableName("tzg_shop_kpi");		//表名
		po2.setEntityName("TzgShopKpi");			//实体名
		po2.setEntityPackage("tao"); 				//包名
		po2.setFtlDescription("店铺指标");			//描述
		//子表外键参数配置
		/*说明:
		 * a) 子表引用主表主键ID作为外键，外键字段必须以_ID结尾;
		 * b) 主表和子表的外键字段名字，必须相同（除主键ID外）;
		 * c) 多个外键字段，采用逗号分隔;
		*/
		po2.setForeignKeys(new String[]{"shop_id,customer_id"});
		subTables.add(po2);


		//第三步：一对多(父子表)数据模型,代码生成
		new CodeGenerateOneToMany(mainTable,subTables).generateCodeFile();
	}
}
