import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


class AddFile {

    static WebDriver driver;


    @BeforeAll
    static void globalSetup() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }


    @Test
    void FirstTest() {
        driver.navigate().to("https://disk.yandex.ru/");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/a[2]")).click();
        driver.findElement(By.name("login")).sendKeys("qa.testfatyhova");
        driver.findElement(By.id("passp:sign-in")).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
        driver.findElement(By.name("passwd")).sendKeys("testING1234");
        driver.findElement(By.id("passp:sign-in")).click();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.cssSelector(".listing-item:nth-child(2) .listing-item__fields")).click();
        driver.findElement(By.cssSelector(".groupable-buttons__visible-button_name_copy")).click();
        driver.findElement(By.cssSelector(".b-tree__name:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".confirmation-dialog__button_submit")).click();
    }

    @AfterEach
    void teardown() {
            driver.quit();
    }
}

