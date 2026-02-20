package AutomationTasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PaginationTaskTest {

	public static void main(String[] args) throws InterruptedException {
		
WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ele =  driver.findElement(By.xpath("//div[@class='widget Stats']"));
		
		String name = "Wireless Mouse 20";
		boolean isFound = false;
		
		//scroll
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
		
		List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
		
		for(WebElement page:pages)
		{
			page.click();
			
			
			List<WebElement> products = driver.findElements(By.xpath("//table[@id='productTable']//tr/td[text()='"+name+"']"));
			
		for(WebElement product:products)
		{
			if(product.getText().equalsIgnoreCase(name))
			{
				WebElement checkbox = product.findElement(By.xpath("//table[@id='productTable']//tr/td[text()='"+name+"']/following-sibling::td[2]/input"));
				
				if(!checkbox.isSelected())
				{
					checkbox.click();
				}
				
				String price = product.findElement(By.xpath("//table[@id='productTable']//tr/td[text()='"+name+"']/following-sibling::td")).getText();
				System.out.println("Price of "+name+":"+price);
				System.out.println("Product found and checkbox clicked.");
				isFound = true;
				break;
			}
		}
		
		if(isFound)
		{
			break;
		}
		}
		if(!isFound)
		{
			System.out.println("Product not found in any of the pages");
		
		}
		
	System.out.println("pagination edit second time");
	//driver.quit();	
}
}