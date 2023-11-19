import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.IndexPage;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    @DisplayName("shouldChangeToPagePet")
    void shouldChangeToPagePet(){
        IndexPage indexPage = new IndexPage(driver);
        assertThat(indexPage.getPagePet()).isEqualTo("Paws & Care | Pets");
    }

    @Test
    @DisplayName("shouldChangeToPageClients")
    void shouldChangeToPageClients() {
        IndexPage indexPage = new IndexPage(driver);
        assertThat(indexPage.getPageClientes()).isEqualTo("Paws & Care | Clientes");
    }

    @Test
    @DisplayName("shouldReturnOneIfAddClient")
    void shouldReturnOneIfAddClient(){
        IndexPage indexPage = new IndexPage(driver);
        assertThat(indexPage.addClient(faker.name().fullName(), faker.idNumber().toString(),
                faker.internet().emailAddress(), faker.phoneNumber().toString())).isEqualTo(1);
    }

}
