import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Ctruh {

	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 driver = new ChromeDriver();
			driver.manage().window().maximize();
		driver.get("https://www.ctruh.com/home");
		
	}
	
	
	
	@org.testng.annotations.Test(priority = 1,description = "Test case 1")
	public void validLogin() throws InterruptedException {	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//button[.='Sign Up']")).click();
		driver.findElement(By.xpath("//a[.='Sign In']")).click();
		driver.findElement(By.name("email_id")).sendKeys("vickyvignesh959718@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Amma@2024");
		driver.findElement(By.xpath("//button[.='Continue']")).click();
		
		
		List<WebElement> until = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("//h2")));
		for(WebElement DashBoard:until) {
			String HomePagetext = DashBoard.getText();
		
		System.out.println("I have print:"+HomePagetext);
		Assert.assertEquals(HomePagetext,"Welcome Back,","Text does not match!" );
		
		}
		
	
	}
	
	
	
	
	@org.testng.annotations.Test(priority = 2,description = "Test case 2")
	public void InvalidLogin() throws InterruptedException {	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://www.ctruh.com/home");
		driver.findElement(By.xpath("//button[.='Sign Up']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[.='Sign In']")).click();
		driver.findElement(By.name("email_id")).sendKeys("vickyvignesh959718@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Amma@203");
		driver.findElement(By.xpath("//button[.='Continue']")).click();
		//Thread.sleep(4000);
		List<WebElement> until = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Invalid User Credentials.')]")));
		//WebElement Element = driver.findElement(By.xpath("//div[contains(text(),'Invalid User Credentials.')]"));
		for(WebElement mytext:until) {
			String text = mytext.getText();
		
		System.out.println("I have print:"+text);
		Assert.assertEquals(text,"Invalid User Credentials.","Text does not match!" );
		
		}
		}
	
	
	@AfterTest
	public void QC() {
		driver.quit();
		
		
		
	
	}
	
	
	
}
