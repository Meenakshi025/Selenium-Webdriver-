import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker_Dropdowns {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Get Method
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='dob']")).click();

		Select monthDropDown = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		monthDropDown.selectByIndex(5);

		Select yeardropDown = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		yeardropDown.selectByValue("2021");

		String date = "10";

		List<WebElement> allDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for (WebElement ele : allDate) {
			String dt = ele.getText();
			if (dt.equals(date)) {
				ele.click();
				break;
			}
		}
		driver.quit();
	}

}
