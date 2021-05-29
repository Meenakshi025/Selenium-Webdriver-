import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleSlider {

static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		WebElement minSlider = driver.findElement(By.xpath("//span[1]"));
		System.out.println("Location of the slider : "+minSlider.getLocation());
		System.out.println("Location of the slider : "+minSlider.getSize());
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(minSlider, 100, 0).perform();
		
		WebElement maxSlider = driver.findElement(By.xpath("//span[2]"));
		System.out.println("Location of the slider : "+maxSlider.getLocation());
		System.out.println("Location of the slider : "+maxSlider.getSize());
		
		action.dragAndDropBy(maxSlider, -100, 0).perform();
		
		driver.quit();

	}

}
