import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindelementVSFindelements {

static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebElement googleImg = driver.findElement(By.className("lnXdpd"));
		System.out.println(googleImg.getText());
		
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Sachin Tendulkar");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("List of link "+ list.size());
		Thread.sleep(2000);
		for(WebElement ele : list) {
			String linktext = ele.getText();
			System.out.println(linktext);
		}
		driver.close();

	}

}
