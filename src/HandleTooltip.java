import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*How to capture tooltip of the Web Element?
*/
		
public class HandleTooltip {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement ele = driver.findElement(By.xpath("//input[@id='age']"));
		
		String toolTipext = ele.getAttribute("Title");
		System.out.println(toolTipext);
		driver.quit();
	}

}
