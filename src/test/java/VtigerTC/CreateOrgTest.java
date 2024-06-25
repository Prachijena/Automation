package VtigerTC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertiesFileUtility;
import GenericUtilities.Webdriverutility;
import ObjectRepositories.CreateNewOrganizationPage;
import ObjectRepositories.Homepage;
import ObjectRepositories.Login_page;
import ObjectRepositories.OrganizationInfoPage;
import ObjectRepositories.OrganizationPage;
import practise.Loginpage;

public class CreateOrgTest {
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;

PropertiesFileUtility putil=new PropertiesFileUtility();
ExcelFileUtility eutil=new ExcelFileUtility();
Webdriverutility wutil=new Webdriverutility();
JavaUtility jutil=new JavaUtility();
//Fetch Browser Name
String BROWSER = putil.readDataFromPf("browser");
System.out.println(BROWSER);

//Launch Browser
if(BROWSER.equals("edge")) {
	 driver=new EdgeDriver();
}
else if(BROWSER.equals("chrome")) {
	 driver=new ChromeDriver();
}
else if(BROWSER.equals("firefox")) {
	 driver=new FirefoxDriver();
}
else {
	System.out.println("INVALID BROWSER NAME");
}
wutil.maximizeWindow(driver);
wutil.waitForPageLoad(driver);
//fetch url
String URL = putil.readDataFromPf("url");
driver.get(URL);
//Login to app
String UN = putil.readDataFromPf("un");
String PWD = putil.readDataFromPf("pwd");
//Create object of login page POM class
Loginpage lp=new Loginpage(driver);
lp.loginToApp(UN,PWD);
//Create object of home page
Homepage h=new Homepage(driver);
h.clickOnOrganizationLink();
//click on orgLookup img
OrganizationPage op=new OrganizationPage(driver);
op.clickOnCeateOrgLookUpImg();	
//give org name
String orgname = eutil.readDatafromExcl("Sheet1", 0, 0);
CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
cnop.createNewOrganization(orgname+jutil.getRandonNum());	
//click on save btn
cnop.getSaveBtn();
//create object of OrganizationInfpage
OrganizationInfoPage oip=new OrganizationInfoPage(driver);
String header = oip.getHeader();
if(header.contains(orgname)) {
	System.out.println("Org is created and TC is pass");
}
else{
	System.out.println("TC is failed");
}
//logout from app
h.logOutOfApp(driver);

}	

}
