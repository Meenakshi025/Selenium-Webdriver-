import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*How To Locate links in Selenium WebDriver?
What is the difference between LinkText() and PartialLinkText()?
How to capture all the links from Web Page?
What is Broken Link? How to check it?*/
public class HandleLinks {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		//Using linkText
		//WebElement linkText = driver.findElement(By.linkText("Electronics"));
		//linkText.click();
		
		//Using Partial linkText
		WebElement linkText = driver.findElement(By.partialLinkText("ectronics"));
		linkText.click();
		
		List <WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(WebElement ele : links) {
			
			String likText = ele.getText();
			System.out.println(likText);
		}
		
	}

}
