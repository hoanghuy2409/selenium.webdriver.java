package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    WebDriver driver;

    By addressInputlocator = By.xpath("//input[@id='billing:street1']");
    By cityInputlocator = By.xpath("//input[@id='billing:city']");
    By countryInputlocator = By.xpath("//select[@id='billing:country_id']");
    By zipInputlocator = By.xpath("//input[@id='billing:postcode']");
    By telephoneInputlocator = By.xpath("//input[@id='billing:telephone']");
    By continuebuttonLink1 = By.cssSelector("button[onclick='billing.save()']");
    By shippinginformationLink = By.cssSelector("li[id='opc-shipping'] h2");

    By continuebuttonLink2 = By.xpath("(//span[contains(text(),'Continue')])[2]");
    By continuebuttonLink3 = By.cssSelector("button[onclick='shippingMethod.save()']");
    By continuebuttonLink4 = By.cssSelector("button[onclick='payment.save()'] span span");

    By check_money_orderLink = By.cssSelector("label[for='p_method_checkmo']");
    By placeorderLink = By.cssSelector("button[title='Place Order']");
    By orderidLink = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]/a[1]");
    By selecbillingadress = By.cssSelector("#billing-address-select");
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterAddress(String address) {
        WebElement element = driver.findElement(addressInputlocator);
        element.clear();
        element.sendKeys(address);
    }

    public void enterCity(String city) {
        WebElement element = driver.findElement(cityInputlocator);
        element.clear();
        element.sendKeys(city);
    }

    public By chooseCountry() {
        WebElement country = driver.findElement(countryInputlocator);
        return countryInputlocator;
    }

    public void enterZIP(String zipid) {
        WebElement element = driver.findElement(zipInputlocator);
        element.clear();
        element.sendKeys(zipid);
    }

    public void enterTelephone(String telephone) {
        WebElement element = driver.findElement(telephoneInputlocator);
        element.clear();
        element.sendKeys(telephone);
    }

    public void clickContinuebutton() {
        driver.findElement(continuebuttonLink1).click();
    }

    public void clickshippinginformationLink() {
        driver.findElement(shippinginformationLink).click();
    }

    public void clickContinuebutton2() {
        driver.findElement(continuebuttonLink2).click();
    }

    public void clickContinuebutton3() {
        driver.findElement(continuebuttonLink3).click();
    }

    public void click_check_money_order() {
        driver.findElement(check_money_orderLink).click();
    }

    public void clickContinuebutton4() {
        driver.findElement(continuebuttonLink4).click();
    }

    public String getOrderId(){
        String OrderId = driver.findElement(orderidLink).getText();
        return OrderId;
    }

    public void clickplaceorderLink() {
        driver.findElement(placeorderLink).click();
    }

    public void clickselecbillingadress() {
        driver.findElement(selecbillingadress).click();
    }

    public By chooseAddress() {
        WebElement address = driver.findElement(selecbillingadress);
        return selecbillingadress;
    }

}