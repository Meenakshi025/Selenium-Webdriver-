import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptAlertAndPopups {
  
	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("proceed")).click();
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
		if(alertText.equals("Please enter a valid user name")) {
			System.out.println("Correct alert message");
		}else {
			System.out.println("Incorrect alert message");
		}
		alert.accept();
		
		driver.quit();

	}

}
