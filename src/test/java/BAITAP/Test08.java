package BAITAP;

import POM.CartPage;
import POM.CheckoutPage;
import POM.LoginPage;
import driver.driverFactory_Firefox;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.File;


@Test
public class Test08 {
    public static void test08() {


        String email_address ="thh@gmail.com";
        String password = "hoanghuy";
        String QTY = "10";
        String country = "United States";
        String provice = "Florida";
        String zipid = "1234";
        String address ="Long Thanh - Vinh Loi - Bac Lieu";
        String city = "TP Bac Lieu";
        String telephone = "0812281545";
        String newadress = "New Address";




        WebDriver driver = driverFactory_Firefox.getFireFoxDriver();
        try {

            driver.get("http://live.techpanda.org/");
            LoginPage loginPage = new LoginPage(driver);
            Thread.sleep(1000);

            loginPage.clickMyAccountLink();

            loginPage.enterEmail(email_address);


            loginPage.enterPassword(password);

            loginPage.clickloginButton();
            Thread.sleep(1000);

            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }
             CartPage cartPage = new CartPage(driver);
            Thread.sleep(1000);
            cartPage.clickReOrderLink();
            Thread.sleep(2000);
            String GrandBefore = cartPage.getGrandTotalBefore();
            System.out.println("Giá khi chưa thay đổi số lượng là: " + GrandBefore);
            cartPage.clickQTyLink();
            Thread.sleep(2000);
           cartPage.enterQTy(QTY);
            Thread.sleep(1000);
          cartPage.clickUpdateLink();
            String GrandAfter = cartPage.getGrandTotalBefore();
            System.out.println("Giá khi cập nhật số lượng là: " + GrandAfter);


            Select drpCountry = new Select(driver.findElement(cartPage.chooseCountry()));
            drpCountry.selectByVisibleText(country);
            Thread.sleep(1000);
            Select drpProvice = new Select(driver.findElement(cartPage.chooseProvice()));
            drpProvice.selectByVisibleText(provice);
            Thread.sleep(1000);
            cartPage.enterZIP(zipid);
            Thread.sleep(1000);
            cartPage.clickestimateLink();
            Thread.sleep(1000);
            String totalwithoutshipcost = cartPage.gettotalWithoutshipcost();
            System.out.println("Giá tổng số khi chưa có chi phí vận chuyển là: " + totalwithoutshipcost);
            Thread.sleep(1000);
            String cost = cartPage.getShippingcost();
            Thread.sleep(1000);
            System.out.println("Giá vận chuyển sau khi ước tính là: " + cost);
            Thread.sleep(1000);
            cartPage.clickefixedLink();
            Thread.sleep(1000);
            cartPage.clickupdatetotalLink();
            Thread.sleep(1000);
            String grandtotalwithupdate = cartPage.getgrandtotal();
            System.out.println("Giá tổng số sau khi cập nhật chi phí vận chuyển là: " + grandtotalwithupdate);
            Thread.sleep(1000);
            cartPage.clickproceedLink();
            Thread.sleep(2000);

            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }

            CheckoutPage checkOutPage = new CheckoutPage(driver);
            checkOutPage.clickselecbillingadress();
            Thread.sleep(1000);
            Select drpselect = new Select(driver.findElement(checkOutPage.chooseAddress()));
            drpselect.selectByVisibleText(newadress);
            Thread.sleep(1000);
            checkOutPage.enterAddress(address);
            Thread.sleep(1000);
            checkOutPage.enterCity(city);
            Thread.sleep(1000);
            checkOutPage.enterZIP(zipid);
            Thread.sleep(1000);
            Select chooseCountry = new Select(driver.findElement(checkOutPage.chooseCountry()));
            chooseCountry.selectByIndex(1);
            Thread.sleep(1000);
            checkOutPage.enterTelephone(telephone);
            Thread.sleep(1000);
            checkOutPage.clickContinuebutton();
            Thread.sleep(2000);
            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }
            checkOutPage.clickshippinginformationLink();
            Thread.sleep(2000);
            checkOutPage.clickContinuebutton2();
            Thread.sleep(2000);
            checkOutPage.clickContinuebutton3();
            Thread.sleep(2000);
            checkOutPage.click_check_money_order();
            Thread.sleep(2000);
            checkOutPage.clickContinuebutton4();
            Thread.sleep(2000);
            checkOutPage.clickplaceorderLink();
            Thread.sleep(3000);

            String OrderId = checkOutPage.getOrderId();
            System.out.println("Đơn hàng đã được tạo với ID: " + OrderId);
            for(String handle: driver.getWindowHandles()){
                driver.switchTo().window(handle);
            }

            Thread.sleep(2000);
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png = ("E:\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\test08.png");
            FileUtils.copyFile(srcFile, new File(png));
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}




