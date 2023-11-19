package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndexPage {
    private WebDriver driver;

    private final String urlApp = "http://localhost:3000/";

    public IndexPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPagePet(){
        driver.get(urlApp);
        final WebElement linkPet = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/a[2]")));

        linkPet.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleIs("Paws & Care | Pets"));

        return driver.getTitle();
    }

    public String getPageClientes(){
        driver.get(urlApp + "pets");

        final WebElement linkClient = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div/div/a[1]")));

        linkClient.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.titleIs("Paws & Care | Clientes"));

        return driver.getTitle();
    }

}
