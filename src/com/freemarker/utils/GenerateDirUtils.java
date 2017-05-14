package com.freemarker.utils;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * 
 * @author Legend
 * @since 1.5
 *
 */
public class GenerateDirUtils {
	
	private static Logger log = Logger.getLogger(GenerateDirUtils.class);

	private GenerateDirUtils(){}
	
	/**
	 * 生成目录
	 * @param dirPaths 一个或多个目录
	 * @return 生成结果，成功为true，失败为false
	 */
	public static boolean generateDir(String ... dirPaths){
		boolean flag = false;
		for(String dirPath : dirPaths){
			File dir = new File(dirPath);
			if(dir.exists()){
				flag = deleteFile(dir);
			}else {
				flag = dir.mkdirs();
				log.info("目录"+dir+"创建完成！");
			}
		}
		return flag;
	}
	
	/**
	 * 将给定的File表示的目录及目录中的所有文件删除
	 * @param f 要删除的目录
	 */
	private static boolean deleteFile(File dir){
		boolean flag =  false;
		try {
			if(dir.isDirectory()){
				//将该目录下的所有子项删除
				File[] subs = dir.listFiles();
				for(File sub : subs){
					flag = sub.delete();
					log.info("文件"+sub+"删除成功！");
					if(!flag)break;
				}
			}
			log.info("目录" + dir + "中的所有文件删除成功！！");
		} catch (Exception e) {
			log.error("目录"+ dir +"删除失败，错误信息为："+e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 将给定的File表示的目录及目录中的所有文件递归删除
	 * @param dir 要删除的多级目录
	 * @return flag 删除结果，成功为true，失败为false
	 */
	private static boolean deleteMulDir(File dir){
		boolean flag =  false;
		try {
			if(dir.isDirectory()){
				//将该目录下的所有子项删除
				File[] subs = dir.listFiles();
				for(File sub : subs){
					deleteMulDir(sub);
				}
			}
			flag = dir.delete();
			log.info("多级目录" + dir + "删除成功...");
		} catch (Exception e) {
			log.error("多级目录"+ dir +"删除失败，错误信息为："+e.getMessage());
		}
		return flag;
	}
}
