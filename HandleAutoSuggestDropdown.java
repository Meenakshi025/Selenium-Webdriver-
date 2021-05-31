import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAutoSuggestDropdown {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("sb_form_q")).sendKeys("selenium");
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
		System.out.println(list.size());
		
		for(WebElement ele: list) {
			if(ele.getText().contains("selenium")) {
				ele.click();
				break;
			}
		}
		
		driver.quit();

	}

}
