import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/*How To Perform Mouse Operations in Selenium WebDriver?
How to Perform Right click Action?
How to Perform Double click Action?
How to Perform Drag and Drop Action?
How to Perform Mouse Hover Action?*/
public class MouseOperation {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Get Method
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement rightClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));

		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.contextClick(rightClickBtn).perform();
		Thread.sleep(2000);
		
		// How to Perform Double click Action?
		driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
		Thread.sleep(2000);
		driver.switchTo().frame("iframeResult");		
		
		WebElement doubleBtn = driver.findElement(By.xpath("//button[text()='Double-click me']"));
		action.doubleClick(doubleBtn).perform();
		
		//How to Perform Drag and Drop Action?
		
		driver.navigate().to("https://demoqa.com/droppable/");
		Thread.sleep(2000);				
		
		WebElement from = driver.findElement(By.id("draggable"));
		WebElement to = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(from, to).perform();
		String textTo = to.getText();
		 
		 if(textTo.equals("Dropped!")) {
		 System.out.println("PASS: Source is dropped to target as expected");
		 }else {
		 System.out.println("FAIL: Source couldn't be dropped to target as expected");
		 }
		 Thread.sleep(2000);	
		 
		 //How to Perform Mouse Hover Action
		 
		 driver.navigate().to("https://demoqa.com/menu/");
		 Thread.sleep(2000);	
		 
	     WebElement menuOption = driver.findElement(By.xpath("//a[text()='Main Item 2']"));
	     action.moveToElement(menuOption).perform();
	     System.out.println("Done Mouse hover on 'Main item 2' from Menu");
	     Thread.sleep(2000);	
	     
	     WebElement subMenuOption = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']")); 
	     action.moveToElement(subMenuOption).perform();
	     System.out.println("Done Mouse hover on 'sub item' from Menu");
	     Thread.sleep(2000);
	     
	     driver.quit();
	}

}
