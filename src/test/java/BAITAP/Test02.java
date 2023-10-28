package BAITAP;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
@Test
public class Test02 {
    public static void test02() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Open target page
            driver.get("http://live.techpanda.org/");

            driver.findElement(By.linkText("MOBILE")).click();
            Thread.sleep(2000);


            WebElement SonyPriceElement = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]"));
            String SonyPrice = SonyPriceElement.getText();

            Thread.sleep(2000);


            WebElement SonyXperia = driver.findElement(By.xpath("//a[@title='Sony Xperia']"));
            SonyXperia.click();

            Thread.sleep(2000);


            WebElement SonyXperiaDetailPriceElement = driver.findElement(By.xpath("//span[@class='price']"));
            String SonyPriceDetail = SonyXperiaDetailPriceElement.getText();

            Thread.sleep(2000);


            if (SonyPrice.equals( SonyPriceDetail)) {
                System.out.println("Equal Price: " + SonyPriceDetail);
            } else {
                System.out.println("Prices do not equal.");
            }
            Thread.sleep(2000);

            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
<<<<<<< HEAD
            String png = ("E:\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\test02.png");
=======
            String png = ("C:\\Users\\huyth\\Desktop\\SWT302\\selenium-webdriver-java\\src\\test\\java\\BAITAP\\test02.png");
>>>>>>> 604fa0a28721d65138f95308e9f55a45781df945
            FileUtils.copyFile(srcFile, new File(png));




        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}




