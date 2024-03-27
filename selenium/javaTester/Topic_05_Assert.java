package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {
    WebDriver driver;

    @Test
    public void verifyTestNG (){
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        //Trong java có nhiều thư viện để Verify dữ liệu
        //gọi là Testing Framework (Unit test, Integration test, UI automation)
        //JUnit 4, TestNG, JUnit 5, Hamcrest, AssertJ,..
        //TestNG vừa là thư viện, vừa là test runner

        /*
        Hàm Assert True
        Chỉ nhận kiểu dữ liệu boolean (true/false)
        Khi mong muốn kiểu dữ liệu trả về là đùng thì dùng assertTrue để verify
        Khi mong muốn kiểu dữ liệu trả về là đùng thì dùng assertFalse để verify
         */
        Assert.assertTrue(driver.getPageSource().contains("Click your picture or add an account."));
        Assert.assertFalse(driver.getPageSource().contains("It's quick and easy."));

        //Các hàm trả về kiểu dữ liệu là boolean
        //Quy tắc: bắt đầu với tiền tố là isXXX
        //Webelement
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        new Select(driver.findElement(By.id(""))).isMultiple();
        //=> dùng với assertTrue/assertFalse

        /*
        Hàm AssertEquals
        Dùng khi mong đợi 1 điều kiện giống thực tế (Tuyệt đối)
         */
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

    }
}
