package practi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class productcre {
@Test(dataProvider = "proddata")
public void tes(String ProductName ) throws InterruptedException {
//	 String Description, String Dimension, String Shipping, String use, double price,int sku, String eincode, int itemcode,int updatestkqty, int minqty, int maxqty
	System.out.println("seb");
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://react.greens-intl.ae/admin/");
	driver.findElement(By.xpath("//p[@content='Products']")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.xpath("//p[@content='Catalog']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[normalize-space()='Create Product']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys(ProductName);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//textarea[@name='prd_description']")).sendKeys("b");
	WebElement ele = driver.findElement(By.xpath("//button[@id='react-aria9254313668-:rh:']"));
	Select s= new Select(ele);
	s.selectByIndex(1);
			driver.quit();
}
@DataProvider(name="proddata")
public Object[][]getProddata()
{
	Object data[][]=new Object[2][1];
	data[0][0]="a";
	data[1][0]="b";
			return data;
}
}
