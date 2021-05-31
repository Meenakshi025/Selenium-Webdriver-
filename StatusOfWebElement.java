import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElement {

	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.id("checkboxes"));
		System.out.println(ele.isDisplayed());
		
		System.out.println(ele.isEnabled());
		
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\'checkboxes\']/input[2]"));
		System.out.println(ele.isSelected());
		Thread.sleep(2000);
		checkbox.click();
		Thread.sleep(2000);
		System.out.println(ele.isSelected());
		
		driver.quit();

	}

}
