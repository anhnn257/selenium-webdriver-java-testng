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

//    String urlStep01 = "http://live.techpanda.org/";
//    String registerPage = "http://live.techpanda.org/customer/account/create/";
//    String loginPage = "http://live.techpanda.org/index.php/customer/account/login/";

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
    @Test
    public void TC_02_Verify_Title(){
        //Step 01: truy cập trang http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        //Step 02: click MY ACCOUNT link tại footer
        driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();

        //Step 03: Verify title của Login Page = Customer Login
        Assert.assertEquals(driver.getTitle(),"Customer Login");

        //Step 04: Click CREATE AN ACCOUNT button
        driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();

        //Step 05: Verify title của Register Page = Create New Customer Account
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

    }
    @Test
    public void TC_03_Navigate_Function(){
        //Step 01: truy cập vào trang
        driver.get("http://live.techpanda.org/");
        //Step 02: Click MY ACCOUNT link tại footer
        driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();

        //Step 03: Click CREATE AN ACCOUNT button
        driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();

        //Step 04: Verify Url của Register Page = http://live.techpanda.org/index.php/customer/account/create/
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");

        //Step 05: Back lại trang Login Page
        driver.navigate().back();

        //Step 06: Verify url của Login Page = http://live.techpanda.org/index.php/customer/account/login/
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

        //Step 07: Forward tới trang Register Page
        driver.navigate().forward();

        //Step 08: Verify title của Register Page = Create New Customer Account
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
    }
    @Test
    public void TC_04_Get_Page_Source_Code(){
        //Step 01: truy cập vào trang http://live.techpanda.org/
        driver.get("http://live.techpanda.org/");

        //Step 02 Click MY ACCOUNT link tại footer
        driver.findElement(By.xpath("//div[@class = 'footer']//a[@title = 'My Account']")).click();

        //Step 03: Verify Login Page chứa text "Login or Create an Account"
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        //Step 04: Click CREATE AN ACCOUNT button
        driver.findElement(By.xpath("//a[@title = 'Create an Account']")).click();

        //Step 05: Verify Register Page chứa text "Create an Account"
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
    }
    @AfterClass
    public void afterClass() {

        //driver.quit();
    }

}
