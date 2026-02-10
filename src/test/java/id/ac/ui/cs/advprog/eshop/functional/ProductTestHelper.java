package id.ac.ui.cs.advprog.eshop.functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class ProductTestHelper {

    private final String baseUrl;

    public ProductTestHelper(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void createProduct(ChromeDriver driver, String name, String quantity) {
        driver.get(baseUrl + "/product/create");
        driver.findElement(By.name("productName")).sendKeys(name);
        driver.findElement(By.name("productQuantity")).sendKeys(quantity);
        submitForm(driver);
    }

    public void navigateToEditPage(ChromeDriver driver, String productName) {
        clickProductActionButton(driver, productName, "btn-warning");
    }

    public void updateProductDetails(ChromeDriver driver, String newName, String newQuantity) {
        clearAndSendKeys(driver.findElement(By.name("productName")), newName);
        clearAndSendKeys(driver.findElement(By.name("productQuantity")), newQuantity);
        submitForm(driver);
    }

    public void deleteProduct(ChromeDriver driver, String productName) {
        clickProductActionButton(driver, productName, "btn-danger");
        driver.switchTo().alert().accept();
    }

    public boolean productExists(ChromeDriver driver, String productName) {
        return Objects.requireNonNull(driver.getPageSource()).contains(productName);
    }

    private void clickProductActionButton(ChromeDriver driver, String productName, String buttonClass) {
        String xpath = String.format("//tr[td[contains(text(), '%s')]]//descendant::*[contains(@class, '%s')]",
                productName, buttonClass);
        driver.findElement(By.xpath(xpath)).click();
    }

    private void clearAndSendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    private void submitForm(ChromeDriver driver) {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}