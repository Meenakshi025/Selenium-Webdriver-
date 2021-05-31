import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCookies {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		
		for(Cookie cookie : cookies) {
			
			System.out.println(cookie.getName()+"  "+cookie.getValue());
		}
		Cookie obj = new Cookie("MyCookies123","12345");
		driver.manage().addCookie(obj);
		
		cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		
		driver.manage().deleteCookie(obj);
		cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		
		driver.manage().deleteCookieNamed("MyCookies123");
		cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		
		
		driver.manage().deleteAllCookies();
		cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		
		driver.quit();
	}
	
}
