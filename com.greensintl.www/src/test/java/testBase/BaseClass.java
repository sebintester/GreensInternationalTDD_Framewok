package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass
	@Parameters({"os","browser"})
public void setup(String os, String br) throws IOException {
		
	//loading properties file	
	FileReader file=new FileReader(".//src/test/resources/config.properties");	
	p=new Properties();
	p.load(file);
	
	//loading log4j2 file	
	logger=LogManager.getLogger(this.getClass());    
		
	//launching browser based condition
	switch (br.toLowerCase()) {
	case "chrome":driver=new ChromeDriver();break;
	case "edge":driver=new EdgeDriver();break;
	case "firefox":driver=new FirefoxDriver();break;
	

	default:
		System.out.println("no matching broser");
		return;
	}
	
//	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("url"));
	driver.manage().window().maximize();
}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
