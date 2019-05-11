package cn.l1.hiber.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DBExport {
	public static void main(String[] args) {
		//创建hibernate 的配置文件
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}
}
