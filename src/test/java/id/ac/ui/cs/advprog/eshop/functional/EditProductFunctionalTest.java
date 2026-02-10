package id.ac.ui.cs.advprog.eshop.functional;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EditProductFunctionalTest extends BaseFunctionalTest {

    @Test
    void testEditProduct(ChromeDriver driver) {
        helper.createProduct(driver, "Product Before Edit", "10");
        helper.navigateToEditPage(driver, "Product Before Edit");
        helper.updateProductDetails(driver, "Product After Edit", "20");

        assertTrue(helper.productExists(driver, "Product After Edit"));
        assertTrue(helper.productExists(driver, "20"));
    }
}