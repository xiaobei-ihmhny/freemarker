package com.ihmhny.freemarker.test;

import com.ihmhny.freemarker.model.FieldBean;
import com.ihmhny.freemarker.model.FileSavePathMap;
import com.ihmhny.freemarker.model.PackageNames;
import com.ihmhny.freemarker.utils.DataBaseService;
import com.ihmhny.freemarker.utils.DataBaseServiceImpl;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * 测试模块相关
 */
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

	@Test
	public void testGetModuleName(){
		DataBaseService dbs = new DataBaseServiceImpl();
		String s = dbs.getModuleName("ams_user_ref_role", '_');
		System.out.println("-----------Legend-----------s值=" + s + "," + "当前类=DataBaseTest.testGetModuleName()");

	}

	@Test
	public void testGetPackageName(){
		String s = PackageNames.getPojoPackageName("ys_sale_goods_file");
		System.out.println("-----------Legend-----------s值=" + s + "," + "当前类=DataBaseTest.testGetPackageName()");
	}

	@Test
	public void testGetSavePath(){
		String s1 = FileSavePathMap.getPojoSavePath("ys_sale_goods_file");
		String s2 = FileSavePathMap.getSearchPojoSavePath("ys_sale_goods_file");
		String s3 = FileSavePathMap.getUpdatePojoFilePath("ys_sale_goods_file");
		String s4 = FileSavePathMap.getDaoFilePath("ys_sale_goods_file");
		String s5 = FileSavePathMap.getServiceFilePath("ys_sale_goods_file");
		String s6 = FileSavePathMap.getServiceImplFilePath("ys_sale_goods_file");
		String s7 = FileSavePathMap.getControllerFilePath("ys_sale_goods_file");
		String s8 = FileSavePathMap.getMapperFilePath();
		String s9 = FileSavePathMap.getDaoTestFilePath("ys_sale_goods_file");
		String s10 = FileSavePathMap.getServiceTestFilePath("ys_sale_goods_file");
		String s11 = FileSavePathMap.getControllerTestFilePath("ys_sale_goods_file");
		System.out.println("-----------Legend-----------s值=" + s1 + "," + "当前类=DataBaseTest.testGetPojoSavePath()");
		System.out.println("-----------Legend-----------s值=" + s2 + "," + "当前类=DataBaseTest.testGetPojoSavePath()");
		System.out.println("-----------Legend-----------s值=" + s3 + "," + "当前类=DataBaseTest.testGetPojoSavePath()");
		System.out.println("-----------Legend-----------s值=" + s4 + "," + "当前类=DataBaseTest.testGetPojoSavePath()");
		System.out.println("-----------Legend-----------s值=" + s5 + "," + "当前类=DataBaseTest.testGetPojoSavePath()");
		System.out.println("-----------Legend-----------s值=" + s6 + "," + "当前类=DataBaseTest.testGetPojoSavePath()");
		System.out.println("-----------Legend-----------s值=" + s7 + "," + "当前类=DataBaseTest.testGetPojoSavePath()");
		System.out.println("-----------Legend-----------s值=" + s8 + "," + "当前类=DataBaseTest.testGetPojoSavePath()");
		System.out.println("-----------Legend-----------s值=" + s9 + "," + "当前类=DataBaseTest.testGetPojoSavePath()");
		System.out.println("-----------Legend-----------s值=" + s10 + "," + "当前类=DataBaseTest.testGetPojoSavePath()");
		System.out.println("-----------Legend-----------s值=" + s11 + "," + "当前类=DataBaseTest.testGetPojoSavePath()");
	}
	
}















