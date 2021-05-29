import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyActions2 {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		WebElement inputText1 = driver.findElement(By.name("text1"));
		inputText1.sendKeys("Welcome to selenium");
		
		WebElement inputText2 = driver.findElement(By.name("text2"));
		
		//CTRL + A
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(3000);
		
		//CTRL + C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("C");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(3000);
		
		//TAB
		act.sendKeys(Keys.TAB);
		act.perform();
		Thread.sleep(3000);
		
		//CTRL + V		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("V");
		act.keyUp(Keys.CONTROL);
		act.perform();
		Thread.sleep(3000);
		
		if(inputText1.getAttribute("value").equals(inputText2.getAttribute("value"))) {
			System.out.println("Text copied");
		}else {
			System.out.println("Text copied");
		}
		
		String mesg = (inputText1.getAttribute("value").equals(inputText2.getAttribute("value"))) ? "Text copied" : "Text copied";
		
		driver.quit();
	}

}
