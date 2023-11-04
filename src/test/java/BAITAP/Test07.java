package BAITAP;

import POM.CartPage;
import POM.CheckoutPage;
import POM.LoginPage;
import POM.RegisterPage;
import driver.driverFactory;
import driver.driverFactory_Firefox;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import java.io.File;
import org.openqa.selenium.support.ui.Select;

import static org.testng.AssertJUnit.assertEquals;

@Test
public class Test07 {
    public static void test07() {


        String email_address ="thh@gmail.com";
        String password = "hoanghuy";




        WebDriver driver = driverFactory_Firefox.getFireFoxDriver();
        try {

            driver.get("http://live.techpanda.org/");
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(1000);

            loginPage.clickMyAccountLink();
            Thread.sleep(2000);


            loginPage.enterEmail(email_address);
            Thread.sleep(1000);
            loginPage.enterPassword(password);
            Thread.sleep(1000);
            loginPage.clickloginButton();
            Thread.sleep(1000);

            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }
            CartPage cartPage = new CartPage(driver);
            Thread.sleep(1000);
            cartPage.clickemyorderLink();
            Thread.sleep(1000);
            cartPage.vieworderLink();
            Thread.sleep(1000);
            cartPage.printorderLink();
            Thread.sleep(2000);

            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }
            Thread.sleep(2000);
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("E:\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\test07.png");
            FileUtils.copyFile(srcFile, new File(png));
            Thread.sleep(2000);





        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}




