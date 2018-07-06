package com.springboot.mybatisplus.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * <p>Title:BONC - PropertiesHelper</p>
 * 
 * <p>Description: 配置文件辅助类</p>
 * 
 * <p>Copyright: Copyright BONC(c) 2001-2010</p>
 * 
 * <p>Company: 北京东方国信科技股份有限公司</p>
 * 
 * @author yangdx
 * @version 1.0.0
 */
public class PropertiesHelper {
	/**
	 * Properties对象
	 */
	private Properties propertie;
	
	/**
	 * 配置文件的文件名及路径，根目录是从classpath开始
	 */
	private String fileName;
	
	/**
	 * 输入文件流(配置文件读)
	 */
	private InputStream inputFile;
	
	/**
	 * 输出的文件流(配置文件写)
	 */
	private FileOutputStream outputFile;
	
	/**
	 * 绝对路径标识，如果是绝对路径，文件修改后，立刻加载。否则只在启动时加载
	 */
	private String isAbsolutePath;
	
	
	//创建一个log4j日志管理器的实例，用于写日志
	protected Logger log4j = LoggerFactory.getLogger(PropertiesHelper.class);

	/**
	 * 不带参数的构造函数，配置文件从空文件开始构造
	 */
	public PropertiesHelper() {
		this.propertie = new Properties();
	}
	
	/**
	 * 构造函数，从一个已经存在的配置文件装载
	 * @param fileName 已经存在的配置文件路径
	 */
	public PropertiesHelper(String fileName) {
		try {
			loadProperties(fileName);
		}
		catch(Exception _ex) {
			log4j.warn("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在");
			_ex.printStackTrace();
		}
	}
	
	/**
	 * 构造函数，从一个已经存在的配置文件装载
	 * @param fileName 已经存在的配置文件路径
	 */
	public PropertiesHelper(String fileName, String isAbsolutePath) {
		try {
			
			this.isAbsolutePath = isAbsolutePath;
			
			loadProperties(fileName);
		}
		catch(Exception _ex) {
			log4j.warn("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在");
			_ex.printStackTrace();
		}
	}
	
	/**
	 * 将配置文件装载到this.propertie
	 * @param fileName 配置文件的路径，路径的开始从classpath开始，/代表类的根目录
	 */
	private void loadProperties(String fileName) throws Exception {
		this.propertie = new Properties();
		
		//将文件名保存起，进行持久化的时候直接使用
		this.fileName = fileName;
		
		this.inputFile = this.getInputStream();
		
		this.propertie.load(this.inputFile);
  
		this.inputFile.close();
	}
	
	/**
	 * 绝对路径的方式传入，创建文件输出流。否则得到服务器启动时产生的文件输入流
	 * @return InputStream对象
	 */
	public InputStream getInputStream() throws Exception{
		InputStream is = null;
		
		if("1".equals(isAbsolutePath)) {
			is = new FileInputStream(new File(fileName));
		}
		else {
			is = super.getClass().getResourceAsStream(fileName);
		}
		
		return is;
	}
	
	/**
	 * 绝对路径的方式传入，创建文件输出流。否则得到服务器启动时产生的文件输出流
	 * @return FileOutputStream对象
	 */
	public FileOutputStream getFileOutputStream() throws Exception {
		FileOutputStream fos = null;
		
		if("1".equals(isAbsolutePath)) {
			fos = new FileOutputStream(new File(fileName));
		}
		else {
			fos = new FileOutputStream(new File(super.getClass().getResource(fileName).toURI()));
		}
		
		return fos;
	}
	
	/**
	 * 根据参数名获取对应的值，如果不存在对应的参数，返回null
	 * @param key 参数名
	 * @return 参数名对应的值
	 */
	public String getValue(String key) {
		if (this.propertie.containsKey(key)) {
			String value = this.propertie.getProperty(key);
			return value;
		}

		return null;
	}
	
	/**
	 * 从指定的配置文件中读取某个参数，如果出现异常或者参数不存在，返回null
	 * @param fileName 配置文件名
	 * @param key 参数名
	 * @return 参数名对应的值
	 */
	public String getValue(String fileName, String key) {
	    return this.getValue(fileName,key,this.isAbsolutePath); 
	}
	
	/**
	 * 根据不同的方式从指定的配置文件中读取某个参数，如果出现异常或者参数不存在，返回null
	 * @param fileName 配置文件名
	 * @param key 参数名
	 * @param isAbsolutePath 通过绝对路径方式读取
	 * @return 参数名对应的值
	 */
	public String getValue(String fileName, String key,String isAbsolutePath) {
	    String value = null;
	    
	    try {
	    	this.isAbsolutePath = isAbsolutePath;
	    	this.loadProperties(fileName);
	    	value = this.getValue(key);
	    }
	    catch(Exception _ex) {
	    	log4j.warn("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在");
	    	_ex.printStackTrace();
	    }
	    
	    return value;
	}
	
	/**
	 * 清除配置文件中的所有内容
	 */
	public void clear() {
		this.propertie.clear();
	}

	/**
	 * 修改或增加一个属性
	 * @param key 参数名称
	 * @param value 参数值
	 */
	public void setValue(String key, String value) {
		this.propertie.setProperty(key, value);
	}
	
	/**
	 * 将配置文件持久化
	 * @param fileName 配置文件的完整路径，根路径是classpath
	 * @param description 文件描述
	 */
	public void save(String fileName, String description) throws Exception {
		this.save(fileName, description, this.isAbsolutePath);
	}
	
	/**
	 * 将配置文件持久化
	 * @param fileName 配置文件的完整路径，根路径是classpath
	 * @param isAbsolutePath 通过绝对路径的方式写入
	 * @param description 文件描述
	 */
	public void save(String fileName, String description,String isAbsolutePath) throws Exception {
		try {
			this.fileName = fileName;
			
			
			this.isAbsolutePath = isAbsolutePath;
			
			//取得文件输出流
			this.outputFile = getFileOutputStream();
			
			//持久化保存属性文件，并设置文件的描述
			this.propertie.store(this.outputFile, description);
			
			this.outputFile.close();
		}
		catch (Exception _ex) {
			log4j.warn("将属性写入到文件的时候出现错误！");
			
			throw _ex;
		} 
		finally {
			//保存完毕，将properties中的内容全部清除
			clear();
		}
	}
	
	/**
	 * 将属性持久化保存到文件中(文件名同读取的文件名)，文件的描述为空
	 */
	public void save() throws Exception {
		if(fileName == null || "".equals(fileName)) {
			throw new Exception("保存属性的时候没有指定文件名！");
		} 
		else {
			save(fileName, "");
		}
	}
}