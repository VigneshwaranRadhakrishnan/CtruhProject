import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ctruh {

	
	
	
	
	@org.testng.annotations.Test(priority = 0,description = "Test case 1")
	public void validLogin() throws InterruptedException {	
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ctruh.com/home");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[.='Sign Up']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[.='Sign In']")).click();
		driver.findElement(By.name("email_id")).sendKeys("vickyvignesh959718@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Amma@2024");
		driver.findElement(By.xpath("//button[.='Continue']")).click();
	
	}
	
	
	@org.testng.annotations.Test(priority = 1,description = "Test case 2")
	public void InvalidLogin() throws InterruptedException {	
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ctruh.com/home");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[.='Sign Up']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[.='Sign In']")).click();
		driver.findElement(By.name("email_id")).sendKeys("vickyvignesh959718@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Amma@203");
		driver.findElement(By.xpath("//button[.='Continue']")).click();
	
	}
	
}
