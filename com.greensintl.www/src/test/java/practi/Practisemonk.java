package practi;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practisemonk {
@Test
public void m4() throws InterruptedException, Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver =new ChromeDriver();
	driver.get("https://monkeytype.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//button[@class='rejectAll']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@mode='custom']")).click();
//	driver.findElement(By.xpath("//div[@id='caret']")).sendKeys("T");
	Thread.sleep(1000);

	WebElement ele = driver.findElement(By.xpath("//div[@id='words']"));
	Thread.sleep(1000);
	ele.sendKeys("The ");
	
	
	
//	
//	Robot r=new Robot();
//	
//	
//	
//	r.keyPress(KeyEvent.VK_SHIFT);
//	r.keyRelease(KeyEvent.VK_T);
//	r.keyPress(KeyEvent.VK_T);
//	r.keyRelease(KeyEvent.VK_SHIFT);
//	r.keyRelease(KeyEvent.VK_T);
//	r.keyPress(KeyEvent.VK_H);
//	r.keyRelease(KeyEvent.VK_H);
//	r.keyPress(KeyEvent.VK_E);
//	r.keyRelease(KeyEvent.VK_H);
//	
//	r.keyPress(KeyEvent.VK_SPACE);
//	r.keyRelease(KeyEvent.VK_SPACE);
//	
//	r.keyPress(KeyEvent.VK_H);
//	r.keyRelease(KeyEvent.VK_H);
//	r.keyPress(KeyEvent.VK_H);
//	r.keyRelease(KeyEvent.VK_H);
//	r.keyPress(KeyEvent.VK_H);
//	r.keyRelease(KeyEvent.VK_H);
//	r.keyPress(KeyEvent.VK_H);
//	r.keyRelease(KeyEvent.VK_H);
//	r.keyPress(KeyEvent.VK_H);
//	r.keyRelease(KeyEvent.VK_H);
//	r.keyPress(KeyEvent.VK_H);
//	r.keyRelease(KeyEvent.VK_H);
	
			
}
}