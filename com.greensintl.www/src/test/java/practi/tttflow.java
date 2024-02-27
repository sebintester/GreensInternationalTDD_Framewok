package practi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tttflow {
	@Test(dataProvider = "getData")
	public void createProduct(String productname,String description,String dimensions,String shipping,String useAndCare,String price,String sku,String ein,String itemcode  ) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://react.greens-intl.ae/admin/catalogue/manage/");
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[@data-slot='base']/descendant::button[@data-slot='trigger'])[3]")).click();
	driver.findElement(By.xpath("//span[text()='tag1']")).click();
	driver.findElement(By.xpath("(//div[@data-slot='base']/descendant::button[@data-slot='trigger'])[3]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@placeholder='Select Date']")).click();
	driver.findElement(By.xpath("//div[@aria-label='Choose Thursday, February 29th, 2024']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//p[normalize-space()='Show expiry on dashboard']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[@data-slot='base']/descendant::button[@data-slot='trigger'])[4]")).click();
	driver.findElement(By.xpath("//span[text()='Returnable']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[@data-slot='base']/descendant::button[@data-slot='trigger'])[5]")).click();
	driver.findElement(By.xpath("//span[text()='category1']")).click();
	driver.findElement(By.xpath("(//div[@data-slot='base']/descendant::button[@data-slot='trigger'])[5]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[@data-slot='base']/descendant::button[@data-slot='trigger'])[6]")).click();
	driver.findElement(By.xpath("//span[text()='Martellato']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[@data-slot='base']/descendant::button[@data-slot='trigger'])[7]")).click();
	driver.findElement(By.xpath("//span[text()='Piece']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//textarea[@name='use_and_care']")).sendKeys(useAndCare);
	
	driver.findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys(productname);
	driver.findElement(By.xpath("//textarea[@name='prd_description']")).sendKeys(description);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@data-slot='trigger'][1]")).click();
	driver.findElement(By.xpath("//span[text()='vat5%']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[@data-slot='base']/descendant::button[@data-slot='trigger'])[2]")).click();
	driver.findElement(By.xpath("//span[text()='Dry']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//textarea[@name='dimensions_and_more_info']")).sendKeys(dimensions);
	driver.findElement(By.xpath("//textarea[@name='shipping_and_returns']")).sendKeys(shipping);
	driver.findElement(By.xpath("//div[@class='custombtn-label']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
	Thread.sleep(1000);
	WebElement ele = driver.findElement(By.xpath("//div[contains(text(),'Price')]"));
	Actions a=new Actions(driver);
	a.moveToElement(ele).click().perform();
	driver.findElement(By.xpath("//input[@placeholder='Price']")).sendKeys(price);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//p[normalize-space()='Inactive']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[@class='custombtn-label'])[1]")).click();
	Thread.sleep(1000);
	driver .findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
	Thread.sleep(1000);
	WebElement ele2 = driver.findElement(By.xpath("//div[normalize-space()='Inventory']"));
	Actions a2=new Actions(driver);
	a2.moveToElement(ele2).click().perform();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@placeholder='SKU']")).sendKeys(sku);
	driver.findElement(By.xpath("//input[@placeholder='EIN Code']")).sendKeys(ein);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@placeholder='Item Code']")).sendKeys(itemcode);
	driver.findElement(By.xpath("//div[@class='custombtn-label']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='custombtn-label']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
	driver.close();
	
}
	@DataProvider 
	public String[][] getData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/product additoin.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet2");
		int numofrows=sh.getLastRowNum();
		int numofcols=sh.getRow(0).getLastCellNum();
		String value[][]=new String[numofrows][numofcols];
		for(int i=0;i<numofrows;i++)
		{
			for(int j=0;j<numofcols;j++)
			{
				DataFormatter df=new DataFormatter();
				value[i][j]=df.formatCellValue(sh.getRow(i+1).getCell(j));
				System.out.println("Row " + i + " Col " + j + " : " + value[i][j]);
			}
		}
		wb.close();
		fis.close();
		return value;
	}
}