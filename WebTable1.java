import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
/*1.How many rows in table
2. How many columns in table
3. Retrive the specific row/Column data
4. Rtrive all the data from table
5. Print release date, Version numberof Java language*/
public class WebTable1 {
static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//Get Method
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		
		int row  = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
		System.out.println(" Number of row: "+ row);
		
		int column  = driver.findElements(By.xpath("//table[@class='data-list']//thead/tr/th")).size();
		System.out.println(" Number of columns: "+column);
		
		String value = driver.findElement(By.xpath("//table[@class='data-list']//tr/td")).getText();
		System.out.println("Text values : "+value);
		
		for(int r=1; r<=row ; r++) {
			for(int c=1; c<=column; c++) {
				String data = driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]/td["+c+"]")).getText();
				System.out.println(data);
			}
		}
		driver.quit();
		
	}

}
