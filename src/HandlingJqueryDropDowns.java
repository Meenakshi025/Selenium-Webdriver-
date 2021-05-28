import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingJqueryDropDowns {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Get Method
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();

		WebElement multipleSel = driver.findElement(By.id("justAnInputBox"));
		multipleSel.click();

		// selectchoiceValues(multipleSel,"choice 1","choice 2");
		selectchoiceValues(multipleSel, "all");
		Thread.sleep(3000);
		driver.quit();
	}

	public static void selectchoiceValues(WebElement ele, String... value) {
		List<WebElement> choicelist = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement item : choicelist) {
				String text = item.getText();
				for (String val : value) {
					if (text.equals(val)) {
						item.click();
						break;
					}
				}
			}
		} 
		else 
		{
			try 
			{
				for (WebElement item : choicelist) 
				{
					item.click();
				}
			} 
			catch (Exception e) 
			{
				System.out.println(e);
			}

		}
	}

}
