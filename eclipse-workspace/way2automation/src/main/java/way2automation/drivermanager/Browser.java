package way2automation.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import way2automation.file.readers.PropertyReader;

public class Browser {
	public static WebDriver getDriver() {
		WebDriver driver;
		switch (PropertyReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			throw new IllegalArgumentException(PropertyReader.getProperty("browser") + "Browser is not supported");

		}
		driver.manage().window().maximize();
		return driver;

	}

	public void quitDriver(WebDriver driver) {
		driver.quit();
	}
}
