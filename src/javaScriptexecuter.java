import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*How To use JavaScriptExecutor in Selenium WebDriver?
--------
1) Flashing Element
2) Drawing border & take screenshot of the Element
3) Get the title of the page
4) Click action
5) Generate alert
6) Refreshing the page
7) Scrolling down page
8) Scroll up page
9) Zoom-In Zoom-Out page*/

public class javaScriptexecuter {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// JavascriptExecutor js = (JavascriptExecutor)driver;

		// Get Method
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		WebElement logoElement = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		javaScriptUtils.drawBorder(logoElement, driver);
		Thread.sleep(2000);

		// highlight the element
		javaScriptUtils.backgroundHighlight(logoElement, driver);
		Thread.sleep(2000);

		// Title of the page
		String title = javaScriptUtils.getTitleByJs(driver);
		System.out.println("Title of the page : " + title);
		Thread.sleep(2000);

		// Click element
		WebElement registerElement = driver.findElement(By.xpath("//a[text()='Register']"));
		javaScriptUtils.clickElementByJs(registerElement, driver);
		Thread.sleep(2000);

		// Get domain Name
		String domainname = javaScriptUtils.getDomainName(driver);
		System.out.println("Domain of the page : " + domainname);
		Thread.sleep(2000);

		// generating alert
		javaScriptUtils.generateAlert("This is my alert", driver);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);

		// Refresh browser
		javaScriptUtils.refreshBrowser(driver);
		Thread.sleep(2000);

		// Scrolldown Page
		javaScriptUtils.scrollPageDown(driver);
		Thread.sleep(2000);

		// ScrollUp Page
		javaScriptUtils.scrollPageUp(driver);
		Thread.sleep(2000);

		// zoomIn Page
		javaScriptUtils.zomIn(driver);
		Thread.sleep(2000);
		
		driver.quit();

	}

}
