import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrokenLinks {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Get Method
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		int brokenLinks = 0;
		for (WebElement ele : linklist) {

			String url = ele.getAttribute("href");

			if (url == null || url.isEmpty()) {
				System.out.println("URL is empty");
			}

			URL link = new URL(url);
			try {
				HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
				httpConn.connect();
				if (httpConn.getResponseCode() >= 400) {
					Thread.sleep(2000);
					System.out.println(httpConn.getResponseCode()+url+ " : is broken link");
					brokenLinks++;
					
				}
				else {
					System.out.println(httpConn.getResponseCode() +url+ " : is valid link");
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("No of broken links : " + brokenLinks);
		driver.quit();
	}

}
