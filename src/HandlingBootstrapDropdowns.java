import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingBootstrapDropdowns {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Get Method
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		List<WebElement> SelProdType = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
		System.out.println("Number of options " + SelProdType.size());
		selectOptionsFromDropDowns(SelProdType,"Cards");
		
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		List<WebElement> ProdType = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
		System.out.println("Number of options " + SelProdType.size());
		selectOptionsFromDropDowns(ProdType,"Credit Cards");
		Thread.sleep(2000);
		driver.quit();
		
	}
	

		public static void selectOptionsFromDropDowns(List<WebElement> options, String value) {
			
			for (WebElement ele : options) {
				if (ele.getText().equals(value)) {
					ele.click();
					break;
				}

			}
			
		}

	

}
