import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.glass.events.KeyEvent;

import io.github.bonigarcia.wdm.WebDriverManager;

public class uploadFile {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		
		WebElement uploadResume = driver.findElement(By.xpath("//span[text()='Upload Resume']"));
		uploadResume.click();
		
		//File upload using Sendkey
		WebElement selectFile = driver.findElement(By.id("file-upload"));
		/*selectFile.sendKeys("C:\\Users\\ADMIN\\Downloads\\file-sample_100kB.doc");
		
		WebElement submitButton = driver.findElement(By.className("btn"));
		//submitButton.click();
*/		
			
		//Using Robot class 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectFile);
		
		Robot rt = new Robot();
		rt.delay(2000);
		
		StringSelection ss = new StringSelection("C:\\Users\\ADMIN\\Downloads\\file-sample_100kB.doc");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rt.keyPress(KeyEvent.VK_CONTROL);
		rt.keyPress(KeyEvent.VK_V);
		
		rt.keyRelease(KeyEvent.VK_CONTROL);
		rt.keyRelease(KeyEvent.VK_V);
		
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
		
		driver.quit();
	}

}
