import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.fail;

public class Tests {
    private WebDriver driver = null;
    private Faker faker = new Faker();

    @BeforeEach
    void setup() throws InterruptedException {
        if(driver == null){
            //WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @AfterEach
    public void quitWebDriver(){
        if(driver != null) driver.quit();
    }

    @Test
    @DisplayName("shouldPerformRequisitionToApp")
    void testGetToApp() throws InterruptedException {
        driver.get("http://localhost:3000/");
        Thread.sleep(1500);
    }

}
