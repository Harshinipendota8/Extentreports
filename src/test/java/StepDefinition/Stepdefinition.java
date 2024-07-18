package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Stepdefinition {
	
	public static WebDriver driver;
	@BeforeStep
	public void beforestep()
	{
		System.out.println("this is before step");
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.get("https://www.saucedemo.com/");	
		
	}

	@Then("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.name("user-name")).sendKeys("standard_user");
		 driver.findElement(By.name("password")).sendKeys("secret_sauce");
	}
	
	
	@AfterStep
	public static void tearDown(Scenario scenario) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String MonthandYear = new SimpleDateFormat("mmyyyy").format(new Date());
		String path=System.getProperty("user.dir")+"//Screenshot//"+MonthandYear+".png";
		FileUtils.copyFile(src, new File(path));
		byte[] b = FileUtils.readFileToByteArray(new File(path));
		scenario.attach(b, "image/png", path);
	}
	
	
//	@Then("user clicks selcets on on item or click on add to cart")
//	public void user_clicks_selcets_on_on_item_or_click_on_add_to_cart() {
////	      driver.findElement(By.id("login-button")).submit();
////			driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")).click();
////	
//	System.out.println("here is the extra code ");	
//	}
//	@Then("user click on the cart button")
//	public void user_click_on_the_cart_button() {
//		  //driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
//			System.out.println("here is the extra code ");	
//
//	}



	
	
}
