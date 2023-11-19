package pageobjects;

import org.assertj.core.api.SoftAssertionsRule;
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

    public Integer addClient(String name, String doc, String email, String tel) throws InterruptedException {
        driver.get(urlApp);

        final WebElement buttonAddClient = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div/button")));

        //verify how many lines had before
        WebElement tableBody = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/table/tbody"));
        Integer numberRowsBefore = tableBody.findElements(By.tagName("tr")).size();

        buttonAddClient.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div")));

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[1]/div[2]/input")).sendKeys(name);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/input")).sendKeys(doc);
        driver.findElement(By.xpath("//*[@id=\"portal-modal\"]/div[2]/div/div/div[2]/div[3]/div[1]/div[2]/input")).sendKeys(email);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/input")).sendKeys(tel);

        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/button[2]")).click();

        //verified if row add
        Integer numberRowsAfter = tableBody.findElements(By.tagName("tr")).size();

        return numberRowsAfter - numberRowsBefore;
    }

}
