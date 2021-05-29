import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDatePicker {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Get Method
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();

		String year = "2021";
		String month = "July";
		String day = "10";

		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();

		while (true) {
			String monthyear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			String arr[] = monthyear.split(" ");
			String mon = arr[0];
			String yr = arr[1];

			if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
				break;
			else
				driver.findElement(By.xpath("//button[normalize-space()='>']")).click();
		}

		// Date Selection

		List<WebElement> allDate = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		for (WebElement ele : allDate) 
		{
			String dt = ele.getText();
			if (dt.equals(day))
				ele.click();
			break;
		}
		
		driver.quit();

	}

}
