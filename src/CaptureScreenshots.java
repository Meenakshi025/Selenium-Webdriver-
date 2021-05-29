import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshots {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Fullpage screenshots
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\ScreenShots\\homepage2.png");
        FileUtils.copyFile(src, trg);
        
        //Section of screenshot
        WebElement sectionScreenshot = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        File src1 = sectionScreenshot.getScreenshotAs(OutputType.FILE);
		File trg1 = new File(".\\ScreenShots\\FeaturedProduct1.png");
        FileUtils.copyFile(src1, trg1);
        
        WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
        File src2 = logo.getScreenshotAs(OutputType.FILE);
		File trg2 = new File(".\\ScreenShots\\logo.png");
        FileUtils.copyFile(src2, trg2);
        
        driver.quit();
        
	}

}
