package keyboardActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardAction {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(); // driver is a WebDriver Object
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		
		// sendKeys() keyboard action
		searchBox.sendKeys("Java ");
		
		// keyDown() keyboard action
		Actions actionGenerate1 = new Actions(driver); // Actions class from selenium library
		Action keydown = actionGenerate1.keyDown(Keys.CONTROL).sendKeys("a").build();
		keydown.perform();
		
		// keyUp keyboard action
		Actions actionGenerate2 = new Actions(driver);
		WebElement searchBox2 = driver.findElement(By.name("q"));
		Action keyup = actionGenerate2.keyDown(Keys.SHIFT).sendKeys(searchBox2,"hello world").keyUp(Keys.SHIFT).sendKeys(searchBox2, "  hello world").build();
		keyup.perform();
		
		Thread.sleep(2000);
		
		driver.quit();
		

	}

}
