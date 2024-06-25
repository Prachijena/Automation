package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrg {
public static void main(String[] args) {
	WebDriver driver=new EdgeDriver();
	driver.get("http://localhost:8888/");
	//implicit wait(10sec)
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//User name
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
	//password
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
	//login button
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	//maximize
	driver.manage().window().maximize();
	//select organization
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	//create organization
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	//write organization name
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Amazons");
	//save it
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//verify whether it is save or not
	  String actText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
     if(actText.contains("Amazons")) {
    	 System.out.println("Org is created TC is pass");
     }
     else {
    	 System.out.println("TC is failed");
     }
     //logout from application
     WebElement admele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
     Actions a=new Actions(driver);
     a.moveToElement(admele).perform();
   //click on sign out button
     driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}
