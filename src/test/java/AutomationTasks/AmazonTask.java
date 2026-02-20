package AutomationTasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonTask {
	public static void main(String[] args) {
		
       WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	
		WebElement ele = driver.findElement(By.xpath("//div[@id='icp-nav-flyout']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		
		WebElement checkbox = driver.findElement(By.xpath("//div[@id='nav-flyout-icp']//ul[@role='list']/li/a[@href='#switch-lang=mr_IN' and @lang='mr-IN']/span/i"));
		
		
		checkbox.click();
		
		//driver.quit();
		
		System.out.println("Amazontask pushing again");
		
		
		
	}

}
