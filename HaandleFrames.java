import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HaandleFrames {

static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/frames");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\'content\']/div/ul/li[2]/a")).click();
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("tinymce")).sendKeys("This is my first paragraph of the story");
		driver.quit();
	}

}
