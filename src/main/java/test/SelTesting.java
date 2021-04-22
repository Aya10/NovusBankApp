package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SelTesting {

	
	

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/ayaaboutwerat/desktop/NovusBankApp/src/test/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:8090");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("aya@gmail.com");	
		driver.findElement(By.id("password")).sendKeys("123456");	
		driver.findElement(By.xpath("submit")).click();
//		
//		//maximize window

//		driver.findElement(By.id("")).click();	
//		for(int i = 0; i < 6; i++) 		
//			
			//driver.findElement(By.xpath("")).click();				
////		
//		System.out.println(driver.findElement(By.xpath("")).getText());
		
		//*[@id="password"]
		//closing the browser
		//driver.close();
}}
