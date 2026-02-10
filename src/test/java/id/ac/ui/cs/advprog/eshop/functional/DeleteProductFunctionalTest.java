package id.ac.ui.cs.advprog.eshop.functional;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeleteProductFunctionalTest extends BaseFunctionalTest {

    @Test
    void testDeleteProduct(ChromeDriver driver) {
        helper.createProduct(driver, "Product To Delete", "666");

        assertTrue(helper.productExists(driver, "Product To Delete"));

        helper.deleteProduct(driver, "Product To Delete");

        assertFalse(helper.productExists(driver, "Product To Delete"));
    }
}