package id.ac.ui.cs.advprog.eshop.functional;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateProductFunctionalTest extends BaseFunctionalTest {

    @Test
    void testCreateProduct(ChromeDriver driver) {
        helper.createProduct(driver, "Sampo Cap Bambang", "100");

        assertTrue(helper.productExists(driver, "Sampo Cap Bambang"));
        assertTrue(helper.productExists(driver, "100"));
    }
}