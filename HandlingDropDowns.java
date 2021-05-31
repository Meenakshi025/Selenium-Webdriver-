import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropDowns {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		
		WebElement dropdown = driver.findElement(By.id("input-country"));
		
		Select sel = new Select(dropdown);
		//sel.selectByIndex(1);
		//sel.selectByValue("India");
		//sel.selectByVisibleText("France");
		
		List<WebElement> allOpions = sel.getOptions();
		
		for(WebElement options : allOpions) {
			
			if(options.getText().equals("India")) {
				options.click();
				break;
			}
		}
		
		driver.quit();
		
		
	}

}
