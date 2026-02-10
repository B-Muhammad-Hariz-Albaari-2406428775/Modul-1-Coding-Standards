package id.ac.ui.cs.advprog.eshop.functional;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductListFunctionalTest extends BaseFunctionalTest {

    @Test
    void testProductListTitle(ChromeDriver driver) {
        driver.get(baseUrl + "/product/list");

        assertEquals("Product List", driver.getTitle());
    }

    @Test
    void testProductListHeader(ChromeDriver driver) {
        driver.get(baseUrl + "/product/list");

        String header = driver.findElement(By.tagName("h2")).getText();
        assertEquals("Product List", header);
    }
}