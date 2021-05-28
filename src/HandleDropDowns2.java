import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDowns2 {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Get Method
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();

		// Clicking on live posting text
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();

		WebElement searchBox = driver.findElement(By.id("autocomplete"));
		searchBox.clear();

		searchBox.sendKeys("Toronto, OH, USA");

		String text;
		do {
			searchBox.sendKeys(Keys.ARROW_DOWN);
			text = searchBox.getAttribute("value");
			if (text.equals("Toronto")) {
				searchBox.sendKeys(Keys.ENTER);
				break;
			}

		} while (!text.isEmpty());
		driver.quit();
	}

}
