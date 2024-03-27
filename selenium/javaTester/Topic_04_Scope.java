package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Scope {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    String homePageUrl;

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        }
    @Test
    public void TC_01() {
        //Các biến được khai báo trong 1 hàm/block -> biến cục bộ (local)
        //Phạm vi sử dụng: trong hàm/block mà nó khai báo
        String homePageUrl = "https://www.facebook.com/";


        //trong 1 hàm nếu như có 2 biến cùng tên (Global/Local) -> sẽ ưu tiên lấy biến local dùng
        // 1 biến local nếu như gọi tới dùng mà chưa được khởi tạo thì sẽ báo lỗi ngay (ở giai đoạn compile code)
        this.driver.get(homePageUrl);

        //trong 1 hàm nếu như có 2 biến cùng tên (Global/Local) mà muốn lấy biến Global để dùng -> dùng "this"
        //biến global chưa khởi tạo mà đã lấy ra dùng thì sẽ không báo lỗi ở bước compile code
        //nhưng sẽ báo lỗi khi run
        this.driver.get(this.homePageUrl);
    }


    @Test
    public void TC_02() {

    }


    @Test
    public void TC_03() {

    }


    @Test
    public void TC_04() {

    }


    @Test
    public void TC_05() {

    }


    @Test
    public void TC_06() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
