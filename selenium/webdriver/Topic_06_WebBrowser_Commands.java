package webdriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {


    //Các câu lệnh thao tác với Browser
    // driver.
    WebDriver driver;

    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");



    //Các câu lệnh thao tác với element
    // element.

    WebElement element;

    //Tổng hợp các câu lệnh hay dùng
//    driver = new FirefoxDriver();
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//**
//    driver.manage().window().maximize();
//    driver.get("https://www.facebook.com/");// **
//
//    WebElement emailAddressTextbox = driver.findElement(By.id("Email"));// **
//    List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
//
//    driver.quit();
    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        //Muốn dùng được thì phải khởi tạo
        driver = new ChromeDriver();// **
        driver = new EdgeDriver();// **

        driver = new FirefoxDriver();

        //Selenium 3/2/1 - cách dùng cũ - lỗi thời
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Các dùng mới của Selenium ver 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//**
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");// **
        }
    @Test
    public void TC_01() throws MalformedURLException {

        //Mở ra 1 URL bất kỳ
        //set biến trực tiếp
        driver.get("https://www.facebook.com/");// **

        //khai báo biến rồi gán vào sau
        //nếu như biến chỉ dùng 1 lần duy nhất thì không nên khai báo
        String homePageUrl = "https://www.facebook.com/";
        driver.get(homePageUrl);

        //đóng 1 tab
        driver.close();// *

        //đóng tất cả các tab
        driver.quit();//**

        //Thao tác với Element
        //Tìm 1 element -> trả về 1 giá trị, nếu tìm thấy nhiều hơn, sẽ trả về giá trị đầu tiên
        //Nếu không tìm thấy -> lỗi throw exception: NoSuchElementException
        WebElement emailAddressTextbox = driver.findElement(By.id("Email"));// **

        //Tìm nhiều element -> trả về 1 danh sách element nếu tìm thấy
        //Nếu không tìm thấy -> trả về danh sách rỗng (o element)
        List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type = 'checkbox']")); // **


        //Các hàm Get - đều có trả ra là dữ liệu
        //Dùng khi cần lấy dữ liệu để verify xem kết quả có đúng với mong muốn không
        //Hàm này dùng để lấy ra URL của màn hình/page hiện tại đang đứng
        driver.getCurrentUrl(); // *

        //Hàm này lấy ra page source HTML/CSS/JS của page hiện tại
        //Mục đích lấy page source để verify một cách tương đối
        driver.getPageSource();
        driver.getCurrentUrl().contains("The apple and google play logo");
        Assert.assertTrue(driver.getCurrentUrl().contains("The apple and google play logo"));

        //Hàm này dùng để lấy ra Title của page hiện tại
        driver.getTitle();

        //Lấy ra id của tab hiện tại
        //ví dụ
        //in ra id của page hiện tại
        //Sử dụng khi Handle Window/Tab
        System.out.println("ID của page là: " + driver.getWindowHandle());
        driver.getWindowHandle();// *
        driver.getWindowHandles();// *

        //Cookies - học trong bài Framework
        //driver.manage().addCookie();// *

        //Get ra những log ở Dev Tools - học trong bài Framework
        driver.manage().logs().get(LogType.DRIVER );// *

        //Apply cho việc tìm Element (findElement/findElements) - duy nhất
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //**

        //Chờ cho page được load xong
        //driver.manage().timeouts().getPageLoadTimeout(Duration.ofSeconds(30));

        //Set trước khi dùng với thư viện JavaScriptExecutor
        //Inject 1 đoạn code JS vào trong Browser/Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        //Chạy full màn hình
        driver.manage().window().fullscreen();
        driver.manage().window().maximize(); // **
        driver.manage().window().minimize();

        //Test Responsive
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().window().getSize();

        //Set cho Browser ở vị trí nào trên màn hình
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().getPosition();

        //Điều hướng trang web - ít dùng trong thực tế
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://www.facebook.com"); //giống driver.get(URL) nhưng dùng cho history nhiều hơn
        driver.navigate().to(new URL("https://www.facebook.com"));

        //Alert/Window (Tab)/Frame (IFrame) // *
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("");

        //Handle window/tab // *
        String homePageWindowID = driver.getWindowHandle();
        driver.switchTo().window(homePageWindowID);

        //Handle Fram/IFrame // *
        driver.switchTo().frame(0);
        driver.switchTo().frame("0089796");
        driver.switchTo().frame(driver.findElement(By.id("")));


        //Các verify dữ liệu
        //Nếu chỉ dùng 1 lần thì không cần khai báo biến
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com");
        //Nếu dùng nhiều lần thì khai báo biến
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl,"https://www.facebook.com");




    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
