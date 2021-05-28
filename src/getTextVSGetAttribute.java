import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextVSGetAttribute {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("Title of the page " +title );
		
		//Enter email in email field
		WebElement inputText = driver.findElement(By.id("Email"));
	
		System.out.println("Result of get Attribute "+inputText.getAttribute("value"));
		
		inputText.clear();
		
		System.out.println("==================================================================================");
		inputText.sendKeys("Test@gmail.com");
		
		WebElement loginbutton = driver.findElement(By.className("login-button"));
		
		//Get text method will fetch the entered text in email
		System.out.println("Fetching the text of button using getText method "+loginbutton.getText());
		
		
		
		driver.quit();
		
		

	}

}
