package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Selenium {

	
	

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ayaaboutwerat/Downloads/chromedriver3");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://localhost8090/");
		driver.findElement(By.xpath("email")).click();	
		driver.findElement(By.xpath("")).click();			
		driver.findElement(By.xpath("")).click();		
		
		driver.findElement(By.xpath("")).click();



		driver.findElement(By.xpath("")).click();
		
//		//maximize window

//		driver.findElement(By.id("")).click();	
//		for(int i = 0; i < 6; i++) 		
//			
			//driver.findElement(By.xpath("")).click();				
//		
		System.out.println(driver.findElement(By.xpath("")).getText());

		driver.manage().window().maximize();
	
		
		
		//driver.findElement(By.xpath("")).click();
		//*[@id="password"]
		//closing the browser
		//driver.close();
}}
