package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        }
    @Test
    public void TC_01_Element() {
        //Dùng để xóa dữ liệu trong 1 field cho phép nhập
        //Textbox/TextArea/Dropdown (Editable)
        //Thường dùng trước hàm sendKeys -> để đảm bảo không bị dính dữ liệu của TC cũ
        driver.findElement(By.id("")).clear(); // *

        //Dùng để nhập dữ liệu vào các field bên trên
        driver.findElement(By.id("")).sendKeys(""); // **

        //Dùng để click lên element
        driver.findElement(By.id("")).click(); // **

        //Tìm từ node cha và node con
        driver.findElement(By.id("node cha")).findElement(By.id("node con")); // không dùng
        driver.findElement(By.cssSelector("form#form-validate input#firstname"));// thường dùng cái này hơn cái trên

        //Trả về 1 element khớp điều kiện
        WebElement fullNameTextbox = driver.findElement(By.id(""));

        //Trả về nhiều element khớp điều kiện
        List<WebElement> textBox = driver.findElements(By.cssSelector(""));

        //Java non Generic -> không cần kiểu dữ liệu cụ thể
        ArrayList name = new ArrayList();
        name.add("Automation FC");
        name.add(7);
        name.add(true);
        name.add('B');

        //Java Generic -> cần đúng kiểu dữ liệu
        ArrayList<String> address = new ArrayList<String>();
        address.add("Automation FC");
//        address.add(7); //sai kiểu dữ liệu báo lỗi
//        address.add(true);//sai kiểu dữ liệu báo lỗi
//        address.add('B');//sai kiểu dữ liệu báo lỗi

        //Dùng để verify checkbox/radio/dropdown(default) đã được chọn hay chưa
        driver.findElement(By.id("")).isSelected(); // *
        //dùng assert để kiểm tra trả về đúng hay sai
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        //Dropdown (default/custom
        //Select select = new Select(driver.findElement(By.id("")).isSelected());

        //Dùng để verify 1 element bất kỳ có hiển thị hay không
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());// **
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());

        //Dùng để verify 1 element bất kỳ có được thao tác lên hay không
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());// *
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());// *

        //Dùng để lấy ra giá trị của attribute -> truyền vào tên Attribute
        driver.findElement(By.id("")).getAttribute("title"); // *

        //Tab Acessibility/Propoties trong Elements
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("baseURL");
        driver.findElement(By.id("")).getDomProperty("outer HTML");

        //Tab Styles trong Elements (GUI)
        //Thường dùng để verify Font/Size/Color/Background...
        driver.findElement(By.id("")).getCssValue("font-size"); // *

        //Lấy ra vị trí của Element so với độ phân giải của màn hình -> kết quả trả về kiểu dữ liệu Point
        Point nameTextboxLoction = driver.findElement(By.id("")).getLocation();
        nameTextboxLoction.getX();
        nameTextboxLoction.getY();

        //Chiều cao + chiều rộng
        Dimension addressSize = driver.findElement(By.id("")).getSize();

        //lấy ra Location + size của element
        Rectangle nameTextboxRect = driver.findElement(By.id("")).getRect();
        //Location
        Point namePoint = nameTextboxRect.getPoint();
        //Size
        Dimension nameSize = nameTextboxRect.getDimension();
        nameTextboxRect.getHeight();
        nameTextboxRect.getWidth();

        //Shadow Element (học trong bài Javascript Excutor)
        driver.findElement(By.id("")).getShadowRoot();

        //Từ id/class/name/css/xpath có thể truy ra ngược lại tagname HTML
        driver.findElement(By.id("firstname")).getTagName();
        driver.findElement(By.className("firstname")).getTagName();
        driver.findElement(By.name("firstname")).getTagName();
        driver.findElement(By.cssSelector("firstname")).getTagName();
        //Đầu vào Element A -> đầu ra là tagname của element A
        String fromListTag = driver.findElement(By.xpath("//input[@id = 'firstname']")).getTagName();
        //Đầu vào của element B sẽ nhận đầu tagname của element A là tham số
        driver.findElement(By.xpath("//div[@class = 'remenber-popup']" + fromListTag));

        //Get text
        driver.findElement(By.cssSelector("address.Copyright")).getText(); // **

        //Chụp hình bị lỗi và lưu dưới dạng nào
        //BYTE
        //FILE (lưu thành 1 hình có kích thước trong ổ cứng: png, jpg,...)
        //BASE64
        driver.findElement(By.cssSelector("address.Copyright")).getScreenshotAs(OutputType.BYTES);
        driver.findElement(By.cssSelector("address.Copyright")).getScreenshotAs(OutputType.BASE64); // *
        driver.findElement(By.cssSelector("address.Copyright")).getScreenshotAs(OutputType.FILE);

        //Hành vi giống phím Enter tới các element trong cùng form
        //Enter/Rgister/Login/Search
        driver.findElement(By.id("")).submit();


















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
