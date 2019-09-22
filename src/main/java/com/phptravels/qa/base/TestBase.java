package com.phptravels.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.phptravels.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver ;
	public static Properties prop;

	public TestBase()  {

		FileInputStream fp;
		try {
			fp = new FileInputStream("E:\\Eclipse_Workspace\\PhpTravels\\src\\main\\java\\com\\phptravels\\qa\\config\\config.properties");
			prop=new Properties();
			prop.load(fp);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	public static void initialisation() {
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\Softwares\\Selenium Softwares\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.firefox.drive", "E:\\Softwares\\Selenium Softwares\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("No Browser is given");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
