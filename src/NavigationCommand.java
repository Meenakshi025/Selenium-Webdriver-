import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationCommand {

static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		
		//Browser forward
		driver.navigate().forward();
		System.out.println("Browser forwarded");
		
		//browser Back
		driver.navigate().back();
		System.out.println("Browser back performed");
		
		//browser refresh
		driver.navigate().refresh();
		System.out.println("Browser refresh performed");
		
		//browser navigate to other browser
		driver.navigate().to("https://www.google.com/");
		System.out.println("Navigated to google.com");
		
		//browser close		
		driver.quit();

	}

}
