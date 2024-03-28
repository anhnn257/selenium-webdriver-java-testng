package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands_Ex {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void BeforeClass(){
        if (osName.contains("Window")){
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_Verify_Url() {
        //Step 01: truy cap vao trang http://live.techpanda.org/
        //Phan tich
        //Để truy cập vào trang -> dùng get
        driver.get("http://live.techpanda.org/");

        //Step 02: Click My Account link tại footer
        //Phân tích:
        //B1: Xác định vị trí của My Account link tại footer -> dùng findElement
        //B2: click vào element -> dùng hàm .click()
        driver.findElement(new By.ByXPath("//div[@class = 'footer']//a[@title = 'My Account']")).click();

        String loginPageUrl = driver.getCurrentUrl();
        //Step 03: Verify Url của login page = http://live.techpanda.org/index.php/customer/account/login/
        //Phân tích:
        //B1: lấy ra link của Login page
        //có 2 cách lấy link Login page:
        // + click vào My Account ở Header
        // + click vào My Account ở footer -> dùng cách này do bên trên đã có sẵn kết quả
        //B2: So sánh kết quả lấy ra ở b1 với đề bài
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");

        //Step 04: Click vào CREATE AN ACCOUNT button
        //Tương tự Step 2
        driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();

        //Step 05: Verify url của Register Page = http://live.techpanda.org/index.php/customer/account/create/
        //tương tự Step 03
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");

    }
    @AfterClass
    public void afterClass() {

        //driver.quit();
    }

}
