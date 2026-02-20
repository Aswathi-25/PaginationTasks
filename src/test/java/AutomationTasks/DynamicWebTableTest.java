package AutomationTasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicWebTableTest {
	public static void main(String[] args) {
		
WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ele = driver.findElement(By.xpath("//div[@id='laptops']"));
		
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
		
		String browser = "Chrome";
		
	
		WebElement broname = driver.findElement(By.xpath("//table[@id='taskTable']//tbody[@id='rows']/tr/td[text()='"+browser+"']"));
		
		
	    String cpuperc = driver.findElement(By.xpath("//table[@id='taskTable']//tbody[@id='rows']/tr/td[text()='"+browser+"']/following-sibling::td[contains(text(),'%')]")).getText();
	
	
	    System.out.println("cpu percentage of "+browser+": "+cpuperc);
		
		
		
	
	

		
	}

}
