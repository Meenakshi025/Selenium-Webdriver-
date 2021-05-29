import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardAction {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://the-internet.herokuapp.com/key_presses?");
		driver.manage().window().maximize();
		
		Actions act =new Actions(driver);
		
		act.sendKeys(Keys.ENTER).perform();
		String enter = driver.findElement(By.id("result")).getText();
		System.out.println(enter);
		Thread.sleep(3000);
		
		String space = driver.findElement(By.id("result")).getText();
		act.sendKeys(Keys.SPACE).perform();
		System.out.println(space);
		Thread.sleep(3000);
		
		String escape = driver.findElement(By.id("result")).getText();
		act.sendKeys(Keys.ESCAPE).perform();
		System.out.println(escape);
		Thread.sleep(3000);
		
		String rightarrow = driver.findElement(By.id("result")).getText();
		act.sendKeys(Keys.ARROW_RIGHT).perform();
		Thread.sleep(3000);
		System.out.println(rightarrow);
		driver.quit();
	}

}
