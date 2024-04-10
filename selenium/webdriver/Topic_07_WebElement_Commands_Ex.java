package webdriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Commands_Ex {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if(osName.contains("Windows")){
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        }
    @Test
    public void TC_01_KiemTraPhanTuHienThi_Display() {
        //Step 01: Truy cập trang https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //Step 02: Kiểm tra các phần tử sau hiển thị trên trang: Email/Age(under 18)/Education
        //step 03: Kiểm tra các phần tử sau không hiển thị trên trang: Name: User5
        //Nếu có hiển thị thì:
        // + Nhập giá trị Automation Testing vào trường Email và Education
        // + Click chọn Age = Under 18
        // + In ra màn hình phần tử đó có hiển thị trên trang hay không
        // Có: Element is displayed
        // Không: Element is not displayed
//        Assert.assertTrue(driver.findElement(By.id("mail")).isDisplayed());//email
//        Assert.assertTrue(driver.findElement(By.xpath("//label[text()= 'Under 18']")).isDisplayed());//Age
//        Assert.assertTrue(driver.findElement(By.id("edu")).isDisplayed());//Education

        if(driver.findElement(By.id("mail")).isDisplayed()){
            driver.findElement(By.id("mail")).sendKeys("Automation Testing");
            System.out.println("Email is displayed");
        } else {
            System.out.println("Emal is not displayed");

        }

        if(driver.findElement(By.xpath("//label[text()= 'Under 18']")).isDisplayed()){
            driver.findElement(By.xpath("//label[text()= 'Under 18']")).click();
            System.out.println("Age under 18 is displayed");
        } else {
            System.out.println("Age under 18 is not displayed");

        }

        if(driver.findElement(By.id("edu")).isDisplayed()){
            driver.findElement(By.id("edu")).sendKeys("Automation Testing");
            System.out.println("Education is displayed");
        } else {
            System.out.println("Education is not displayed");

        }


    }

    @Test
    public void TC_02_KiemTraPhanTu_Enable_Disable() {
        //Step 01: Truy cập trang https://automationfc.github.io/basic-form/index.html
        driver.get("https://automationfc.github.io/basic-form/index.html");

        //Step 02: Kiểm tra các phần tử sau enable trên trang: Email/Age(under 18)/Education/Job role 01
        //Job role 02/Interests (Development) checkbox/Slider 01
        //Step 04: In ra màn hình các phần tử có hiển thị hay không

        if(driver.findElement(By.xpath("//input[@id='email']")).isEnabled()){
            System.out.println("Email is enabled");
        } else {
            System.out.println("Email is disable");
        }

        if(driver.findElement(By.xpath("//input[@id='under_18']")).isEnabled()){
            System.out.println("Age under 18 is enabled");
        } else {
            System.out.println("Age under 18 is disable");
        }

        if(driver.findElement(By.xpath("//textarea[@id='edu']")).isEnabled()){
            System.out.println("Education is enabled");
        } else {
            System.out.println("Education is disable");
        }

        if(driver.findElement(By.xpath("//select[@id='job1']")).isEnabled()){
            System.out.println("Job role 01 is enabled");
        } else {
            System.out.println("Job role 01 is disable");
        }

        if(driver.findElement(By.xpath("//select[@id='job2']")).isEnabled()){
            System.out.println("Job role 02 is enabled");
        } else {
            System.out.println("Job role 02 is disable");
        }

        if(driver.findElement(By.xpath("//input[@id ='development']")).isEnabled()){
            System.out.println("Interests (Development) checkbox is enabled");
        } else {
            System.out.println("Interests (Development) checkbox is disable");
        }

        if(driver.findElement(By.xpath("//input[@id ='slider-1']")).isEnabled()){
            System.out.println("Slider 01 is enabled");
        } else {
            System.out.println("Slider 02 is disable");
        }

        //Step 03: Kiểm tra phần tử disable trên trang: Password/ Age (Radio button is disabled)/Biography
        //Job Role 03/ Interests (Checkbox is disabled)/Slider 02 (Disabled)
        if(driver.findElement(By.xpath("//input[@id='disable_password']")).isEnabled()){
            System.out.println("Password is enabled");
        } else {
            System.out.println("Password is disable");
        }

    }


    @Test
    public void TC_03_KiemTraPhanTu_Selected() {

        //Step 01: truy cập vào trang https://automationfc.github.io/basic-form/index.html
        //Step 02: Click chọn Age (Under 18) Radio button
        //          Click chọn "Languagues: Java" checkbox
        //Step 03: Kiểm tra các phần tử tại step 02 đã được chọn
        //Step 04: Click để bỏ chọn "Languagues: Java" checkbox
        //Step 05: Kiểm tra phần tử "Languagues: Java" checkbox đã được bỏ chọn

        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.xpath("//label[text()= 'Under 18")).click();
        Assert.assertTrue( driver.findElement(By.xpath("//label[text()= 'Under 18")).isSelected());

        WebElement javaCheckbox  = driver.findElement(By.xpath("//input[@id='java']"));
        javaCheckbox.click();
        Assert.assertTrue( javaCheckbox.isSelected());

        javaCheckbox.click();
        Assert.assertTrue( javaCheckbox.isSelected());

    }


    @Test
    public void TC_04_Register_Function_at_MailChimp() {

        //Step 01: truy cập link https://login.mailchimp.com/signup/
        driver.get("https://login.mailchimp.com/signup/");

        //Step 02: nhập dữ liệu hợp lệ vào trường email (trường username tự động lấy dữ liệu nhập ở trường email)
        driver.findElement(By.cssSelector("input#email")).sendKeys("anhnn.apd@gmail.com");

        //Step 03: nhập dữ liệu trường password lần lượt
        // nhập số/nhập chữ thường/nhập chữ hoa/nhập ký tự đặc biệt/nhập > 8 ký tự
        //Các trường tiêu chí sẽ đổi text màu xanh khi 1 tham số được nhập hợp lệ

        WebElement passWord = driver.findElement(By.cssSelector("input#new_password"));
        //nhập số
        passWord.sendKeys("8");

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = '8-char not-completed']")).isDisplayed());


        //nhập chữ thường
        passWord.clear();
        passWord.sendKeys("a");

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'lowercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = '8-char not-completed']")).isDisplayed());

        //nhập chữ hoa
        passWord.clear();
        passWord.sendKeys("A");

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'uppercase-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = '8-char not-completed']")).isDisplayed());

        //nhập ký tự đặc biệt

        passWord.clear();
        passWord.sendKeys("#%^%$^");

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'number-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'special-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = '8-char not-completed']")).isDisplayed());

        //nhập lớn hơn 8 ký tự
        passWord.clear();
        passWord.sendKeys("9999999999");

        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'number-char completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'lowercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'uppercase-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = 'special-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class = '8-char completed']")).isDisplayed());

        //Khi nhập thỏa mãn tất cả các trường thông tin

        passWord.clear();
        passWord.sendKeys("An*020497");

        Assert.assertFalse(driver.findElement(By.cssSelector("li[class = 'number-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class = 'lowercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class = 'uppercase-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class = 'special-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class = '8-char completed']")).isDisplayed());

    }


    @Test
    public void TC_05() {

    }


    @Test
    public void TC_06() {

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

}
