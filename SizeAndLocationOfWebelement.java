import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//How to capture Size & Location of the WebElement?
public class SizeAndLocationOfWebelement {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebElement googleImg = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
		
		System.out.println("Loation of (X,Y) : "+googleImg.getLocation());
		System.out.println("Loation of (X) : "+googleImg.getLocation().getX());
		System.out.println("Loation of (Y) : "+googleImg.getLocation().getY());
		
		System.out.println("size of (Width,Height) : "+googleImg.getSize());
		System.out.println("Size of (Width) : "+googleImg.getSize().getHeight());
		System.out.println("Size of (Height) : "+googleImg.getSize().getWidth());
		
		driver.quit();

	}

}
