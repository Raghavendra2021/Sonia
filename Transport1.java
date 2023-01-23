
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.io.File;
//import java.io.IOException;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Hello_world 
{
	static ExtentReports report;
	static ExtentTest test;

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		// TODO Auto-generated method stub
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
		
		System.out.println("Just hello "+ System.getProperty("user.dir")+"\\ExtentReportResults.html");
		//Reporter.log("");
		test.log(LogStatus.PASS, "Navigated to the specified URL");
		
		report.endTest(test);
		test = report.startTest("Tc2");
		
		//test.log(LogStatus.FAIL,test.addScreenCapture(captureWebDriver(driver))+ "Test Failed");

		
		test.log(LogStatus.PASS, "Navigated to the specified URL");
		
		//Explicit wait
		Duration duration = Duration.ofSeconds(10);
		WebDriverWait wait = new WebDriverWait(driver,duration);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
		

		//Fluent Wait
		//Declare and initialise a fluent wait
		FluentWait wait = new FluentWait(driver);
		//Specify the timeout of the wait
		wait.withTimeout(10, TimeUnit.SECONDS);
		//Specify polling time
		wait.pollingEvery(2, TimeUnit.SECONDS);
		//Specify what exceptions to ignore
		//wait.ignoring(NoSuchElementException.class);
		//This is how we specify the condition to wait on.
		wait.until(ExpectedConditions.elementToBeClickable(""));
		
		this.takeSnapShot(driver, "c://test.png") ;
		
		
		report.endTest(test);
		report.flush();
	}
	
	private static By ById(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	//Fluent
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
			.withTimeout(30, TimeUnit.SECONDS) 			
			.pollingEvery(5, TimeUnit.SECONDS) 			
			.ignoring(NoSuchElementException.class);
	WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>()
	{
	
		public WebElement apply(WebDriver driver ) {
			return driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i"));
		}
	});


public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

    //Convert web driver object to TakeScreenshot

    TakesScreenshot scrShot =((TakesScreenshot)webdriver);

    //Call getScreenshotAs method to create image file

            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

            File DestFile=new File(fileWithPath);

            //Copy file at destination

            FileUtils.copyFile(SrcFile, DestFile);

}

}
