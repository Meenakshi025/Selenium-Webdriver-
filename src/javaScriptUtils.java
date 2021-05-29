import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javaScriptUtils {

	public static void drawBorder(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='2px solid red'", ele);
	}
	
	public static void backgroundHighlight(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.background='yellow'", ele);
	}

	public static String getTitleByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String Title = js.executeScript("return document.title;").toString();
		return Title;
	}
	
	public static String getDomainName(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String Title = js.executeScript("return document.domain").toString();
		return Title;
	}

	public static void clickElementByJs(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	public static void generateAlert(String message, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}
	
	public static void refreshBrowser(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
		}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
	
	public static void scrollPageUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		}
	
	public static void zomIn(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
		}

}
