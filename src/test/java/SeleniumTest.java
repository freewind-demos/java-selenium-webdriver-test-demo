import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SeleniumTest {

    static {
        String driverPath = "./chrome-driver-mac/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    private WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://github.com");
    }

    @After
    public void doThis() {
        driver.quit();
    }

    @Test
    public void openLoginPage() {
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        assertThat(driver.getTitle()).isEqualTo("Sign in to GitHub · GitHub");
    }


}