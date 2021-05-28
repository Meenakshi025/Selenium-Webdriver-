import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*1) How To Handle Browser Windows in Selenium WebDriver?
2) What is the Difference between getWindowHandle() & getWindowHandles() methods?
3) How To Switch between Multiple Browser Windows?
4) What is the difference between close() and quite() methods?
5) How to close All browser Windows?
6) How To close Specific Browser Window by choice?*/
public class HandleBrowserWindow {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		//getWindowHandle
		//getWindowHandles
		String windowId = driver.getWindowHandle();
				
		WebElement orangeHRmIncLink = driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']"));
		orangeHRmIncLink.click();
		
		Set<String> WindowIDs = driver.getWindowHandles();
		Iterator<String> it = WindowIDs.iterator();
		
		/*String parentWindowId = it.next();
		String childWindowId = it.next();
		
		System.out.println("Parent Window ID : "+parentWindowId);
		System.out.println("child Window ID : "+childWindowId);
		
		//How To Switch between Multiple Browser Windows?
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent Window Title : "+driver.getTitle());
		
		driver.switchTo().window(childWindowId);
		System.out.println("Child Window Title : "+driver.getTitle());*/
		
		for(String winId : WindowIDs) {
			
			String title = driver.switchTo().window(winId).getTitle();
			System.out.println("window title : "+title);
		}
		
		driver.quit();
		

	}

}
