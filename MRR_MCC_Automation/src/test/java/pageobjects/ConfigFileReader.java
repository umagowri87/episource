package pageobjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "src/test/resources/configs/Configuration.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getQAAdminUserName(){
		String adminuser = properties.getProperty("qa_admin_username");
		if(adminuser!= null) return adminuser;
		else throw new RuntimeException("QA Admin Username not specified in the Configuration.properties file.");		
	}
	
	public String getEpiUATAdminUserName(){
		String adminuser = properties.getProperty("uat_admin_username");
		if(adminuser!= null) return adminuser;
		else throw new RuntimeException("EpiUAT Admin Username not specified in the Configuration.properties file.");		
	}
		
	public String getEpiQAAdminUserName(){
		String adminuser = properties.getProperty("epiqa_admin_username");
		if(adminuser!= null) return adminuser;
		else throw new RuntimeException("EpiQA Admin Username not specified in the Configuration.properties file.");		
	}
	
	public String getQapassword()
	{
		String password = properties.getProperty("qa_admin_password");
		if(password != null) return password;
		else throw new RuntimeException("QA Application password not specified in the Configuration.properties file.");
	}
	
	public String getEpiqapassword()
	{
		String password = properties.getProperty("epiqa_admin_password");
		if(password != null) return password;
		else throw new RuntimeException("EpiQA Application password not specified in the Configuration.properties file.");
	}
	
	public String getUATpassword()
	{
		String password = properties.getProperty("uat_admin_password");
		if(password != null) return password;
		else throw new RuntimeException("UAT Application password not specified in the Configuration.properties file.");
	}
	
	public String getQAApplicationUrl() {
		String url = properties.getProperty("qa_url");
		if(url != null) return url;
		else throw new RuntimeException("QA Application URL not specified in the Configuration.properties file.");
	}
	
	public String getEpiUATApplicationUrl() {
		String url = properties.getProperty("uat_url");
		System.out.println(url);
		if(url != null) {
			System.out.println(url);
			return url;
		}
		else throw new RuntimeException("EpiUAT Application URL not specified in the Configuration.properties file.");
	}
	
	public String getEpiQAApplicationUrl() {
		String url = properties.getProperty("epiqa_url");
		if(url != null) return url;
		else throw new RuntimeException("EpiQA Application URL not specified in the Configuration.properties file.");
	}
	
	public String getAdminPassword(){
		String adminpassword = properties.getProperty("admin_password");
		if(adminpassword!= null) return adminpassword;
		else throw new RuntimeException("Admin Password not specified in the Configuration.properties file.");		
	}
	
	public String getUATperformanceUserName(String threadNum){
		String adminuser = properties.getProperty("perf_username_uat_" + threadNum);
		if(adminuser!= null) return adminuser;
		else throw new RuntimeException("EpiUAT Admin Username not specified in the Configuration.properties file.");		
	}
	
	public String getUATperformncePassword(String threadNum){
		String password = properties.getProperty("perf_password_uat_" + threadNum);
		if(password != null) return password;
		else throw new RuntimeException("UAT Performance Application password not specified in the Configuration.properties file.");
	}
}
