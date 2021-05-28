import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropdowns {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.manage().window().maximize();
		
		//Approach 1
		/*Select noOfEmp = new Select(driver.findElement(By.id("Form_submitForm_NoOfEmployees")));
		noOfEmp.selectByIndex(3);
		
		Select industry = new Select(driver.findElement(By.id("Form_submitForm_Industry")));
		industry.selectByValue("Computer / Technology - Reseller (inc VAR)");
		
		Select country = new Select(driver.findElement(By.id("Form_submitForm_Country")));
		country.selectByVisibleText("India");*/
		
		//Approach2
		
		WebElement noOfEmp = driver.findElement(By.id("Form_submitForm_NoOfEmployees"));
		selectOptionsFromDropDowns(noOfEmp,"11 - 15");
		
		WebElement industry = driver.findElement(By.id("Form_submitForm_Industry"));
		selectOptionsFromDropDowns(industry,"Computer / Technology - Reseller (inc VAR)");
		
		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
		selectOptionsFromDropDowns(country,"India");
		
		driver.quit();
		
	}
		
		public static void selectOptionsFromDropDowns(WebElement ele, String value) {
			Select sel = new Select(ele);
			List<WebElement> allOpions = sel.getOptions();
			
			for(WebElement options : allOpions) {
				
				if(options.getText().equals(value)) {
					options.click();
					break;
				}
			}
			
		}
	}
