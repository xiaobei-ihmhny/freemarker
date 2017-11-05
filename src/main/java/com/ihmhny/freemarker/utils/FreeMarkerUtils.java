package com.ihmhny.freemarker.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * @author xiaobei
 * @version 1.2
 * @project yzys
 * @class_name FreeMarkerUtils
 * @date 2017-10-26 10:09
 * @description 读取相应的模板数据并执行IO操作生成相关文件
 */
public class FreeMarkerUtils {
	
	private static Logger log = Logger.getLogger(FreeMarkerUtils.class);
	
	public Template getTemplate(String name) {
		try {
			Configuration cfg = new Configuration();
			cfg.setClassForTemplateLoading(this.getClass(), "/ftl");
			cfg.setDefaultEncoding("utf-8");
			Template template = cfg.getTemplate(name);
			template.setEncoding("utf-8");
			return template;
		} catch (IOException e) {
			log.error("错误信息为："+e.getMessage());
			return null;
		}
	}
	
	/**
	 * 生成相应的结果文件
	 * @param templateName 模板名
	 * @param templateData Map模板数据
	 * @param outFilePath 输出路径
	 */
	public void generateFile(String templateName, Map<String, Object> templateData, String outFilePath){
		BufferedWriter out = null;
		try {
			// 通过一个文件输出流，就可以写到相应的文件中，此处用的是绝对路径
			FileOutputStream fos= new FileOutputStream(outFilePath);
			OutputStreamWriter osw =new OutputStreamWriter(fos, "UTF-8");
			out =new BufferedWriter(osw, 1024);
			Template temp = this.getTemplate(templateName);
			temp.process(templateData, out);
		} catch (Exception e) {
			log.error("发生错误，错误信息为："+e.getMessage());
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				log.error("发生错误，错误信息为："+e.getMessage());
			}
		}
	}
	
}
