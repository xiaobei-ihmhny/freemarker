package com.freemarker.test;

import java.util.List;
import java.util.Map;

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
	
	
}















