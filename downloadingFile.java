import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class downloadingFile {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		String locations = System.getProperty("user.dir")+"\\Downloads\\";
		
		HashMap Preferences = new HashMap();
		Preferences.put("download.default_directory", locations);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", Preferences);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		
		//Get Method
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"table-files\"]/tbody/tr[1]/td[5]/a[1]")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
