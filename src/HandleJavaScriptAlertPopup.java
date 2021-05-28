import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleJavaScriptAlertPopup {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//Click for JS alert
		/*WebElement jsAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		jsAlert.click();
		
		Alert alert = driver.switchTo().alert();
		//alert.accept();
				
		System.out.println(alert.getText());
		alert.accept();*/
		
		//Click for js confirm
		/*WebElement ConfmjsAlert = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		ConfmjsAlert.click();
		
		Alert alert1 = driver.switchTo().alert();
	
		System.out.println(alert1.getText());
		alert1.accept();*/
		//alert1.dismiss();
		
		//Click for js prompt
		WebElement ConfmjsAlert = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		ConfmjsAlert.click();
		
		Alert alert1 = driver.switchTo().alert();
	
		System.out.println(alert1.getText());
		alert1.sendKeys("Meenakshi");
		alert1.accept();
		
		driver.quit();
		
		
		
	}

}
