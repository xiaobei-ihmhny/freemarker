package com.freemarker.test;

import java.util.List;
import java.util.Map;

import com.freemarker.utils.PropUtils;
import org.junit.Test;

import com.freemarker.model.FieldBean;
import com.freemarker.utils.DataBaseService;
import com.freemarker.utils.DataBaseServiceImpl;

public class DataBaseTest {
	

	@Test
	public void testConvert(){
		DataBaseService dbs = new DataBaseServiceImpl();
		String convertField = dbs.convertField('_', "t_user_driver");
		String convertField2 = dbs.convertTableNameToPojo('_', "t_user_driver");
		System.out.println(convertField);
		System.out.println(convertField2);
	}
	
	@Test
	public void testGetAllTableNames(){
		DataBaseService dbs = new DataBaseServiceImpl();
		Map<String, String> tableNames = dbs.getAllTableNames('_');
		for(Map.Entry<String, String> entry : tableNames.entrySet()){
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
	}
	
	@Test
	public void testGetTableInfo(){
		DataBaseService dbs = new DataBaseServiceImpl();
		Map<String, String> tableNames = dbs.getAllTableNames('_');
		for(Map.Entry<String, String> entry : tableNames.entrySet()){
			String tableName = entry.getKey();
			List<FieldBean> tableInfo = dbs.getTableInfo('_', tableName);
			System.out.println(tableInfo.toString());
		}
	}

	@Test
	public void testConvertRequestMappingAddr(){
		DataBaseService dbs = new DataBaseServiceImpl();
		String result = dbs.getAllRequestMappingAddr('_', "bms_goods_brand");
		System.out.println("-----------Legend-----------result值=" + result + "," + "当前类=DataBaseTest.testConvertRequestMappingAddr()");
	}

	@Test
	public void testList(){
		DataBaseService dbs = new DataBaseServiceImpl();
		List<String> list = dbs.getPropList("contextConfiguration", ",");
		System.out.println("-----------Legend-----------list值=" + list + "," + "当前类=DataBaseTest.testList()");
	}

	@Test
	public void testSetMethod(){
		DataBaseService dbs = new DataBaseServiceImpl();
		String setMethod = dbs.getSetMethod("name", "String");
		System.out.println("-----------Legend-----------setMethod值=" + setMethod + "," + "当前类=DataBaseTest.testSetMethod()");
	}
	
	
}















