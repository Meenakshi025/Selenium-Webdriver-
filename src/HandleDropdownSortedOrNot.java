import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdownSortedOrNot {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Get Method
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();

		// Clicking on live posting text
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();

		WebElement allDropdown = driver.findElement(By.name("category_id"));
		Select dropSel = new Select(allDropdown);

		List<WebElement> options = dropSel.getOptions();

		ArrayList originalList = new ArrayList();

		ArrayList tempList = new ArrayList();

		for (WebElement opt : options) {
			originalList.add(opt.getText());
			tempList.add(opt.getText());
		}
		System.out.println("Original List" + originalList);
		System.out.println("Temp List" + tempList);

		Collections.sort(tempList);

		System.out.println("Original List" + originalList);
		System.out.println("Temp List" + tempList);

		if (originalList.equals(tempList))
			System.out.println("Dropdown Sorted");
		else 
			System.out.println("Dropdown unsorted");
		
		driver.close();
	}

}
