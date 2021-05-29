import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//How to open a link in new tab?

public class OpenLinkInNewTab {

    static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		String TAB = Keys.chord(Keys.CONTROL,Keys.RETURN);
		
		driver.findElement(By.xpath("//a[text()='Register']")).sendKeys(TAB);
		Thread.sleep(3000);
		driver.quit();
	}

}
