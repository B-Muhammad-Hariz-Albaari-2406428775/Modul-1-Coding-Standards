package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
class EshopApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testMain() {
        try (var mockedSpringApplication = mockStatic(SpringApplication.class)) {
            mockedSpringApplication.when(() -> SpringApplication.run(EshopApplication.class, new String[] {}))
                    .thenReturn(null);

            EshopApplication.main(new String[] {});

            mockedSpringApplication.verify(() -> SpringApplication.run(EshopApplication.class, new String[] {}),
                    times(1));
        }
    }

}
