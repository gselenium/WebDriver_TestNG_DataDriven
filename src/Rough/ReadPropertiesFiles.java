package Rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadPropertiesFiles {
	public static void main(String[] args) throws Exception {
		Properties OR=new Properties();
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/com/gktech/config/OR.properties");
		OR.load(ip);
		System.out.println(OR.getProperty("loglink"));
		System.out.println(OR.getProperty("loguname"));
		
		Properties CONFIG=new Properties();
		FileInputStream cp=new FileInputStream(System.getProperty("user.dir")+"/src/com/gktech/config/config.properties");
		CONFIG.load(cp);
		System.out.println(CONFIG.getProperty("browsertype"));
		System.out.println(CONFIG.getProperty("adminuname"));
		System.out.println(System.getProperty("user.dir"));
	}

}
