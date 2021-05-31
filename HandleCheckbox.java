/*1) How To Select specific Check box?
2) How to select all the check boxes?
3) How to select multiple check boxes by choice?
4) How to select last N check boxes?
5) How to select first N check boxes?*/
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckbox {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Get Method
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();

		List<WebElement> weekCheckbox = driver.findElements(By.xpath("//input[@class='form-check-input'][@type='checkbox']"));
		System.out.println("no of days " + weekCheckbox.size());
		//Approach 1
		/*for (WebElement checkbox : weekCheckbox) 
		{
			checkbox.click();			
		}*/
		
		//Approach 2
		/*for (int i=0;i<=weekCheckbox.size(); i++) 
		{
			weekCheckbox.get(i).click();			
		}*/
		
		//Approach 3
		/*for (WebElement checkbox : weekCheckbox) 
		{
			String checkBoxName = checkbox.getAttribute("id");
			if(checkBoxName.equals("monday") || checkBoxName.equals("sunday")) {
				checkbox.click();
			}
		}*/
		
		//Approach 4
		//How to select last N check boxes?
		
		/*int totalNoOfCheckboxes = weekCheckbox.size();
		
		for(int i=totalNoOfCheckboxes-2;i<totalNoOfCheckboxes;i++) {
			weekCheckbox.get(i).click();
		}*/
		
		int totalNoOfCheckboxes = weekCheckbox.size();
		
		for(int i=0;i<=totalNoOfCheckboxes;i++) {
			if(i<2)
			weekCheckbox.get(i).click();
		}
		//driver.quit();
	}
}
