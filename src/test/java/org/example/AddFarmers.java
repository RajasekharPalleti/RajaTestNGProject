package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class AddFarmers {

  @Test
  public void addFarmers() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));

    // wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
    FluentWait<WebDriver> wait1 = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1));

    driver.get("https://cloud.cropin.in/");
    driver.manage().window().maximize();

    driver.findElement(By.xpath("//input[@name = 'domainName']")).sendKeys("asp");
    driver.findElement(By.xpath("//span[contains(text(), ' Continue ')]")).click();

    driver.findElement(By.xpath("//div/input[@id = 'username']")).sendKeys("9649964096");
    driver.findElement(By.xpath("//div/input[@id = 'password']")).sendKeys("123456");
    driver.findElement(By.xpath("//div/button[@id = 'kc-login' and @type = 'submit']")).click();

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(driver.getCurrentUrl(), "https://cloud.cropin.in/dashboard-farm/aggregation-level", "Wrong URL");
    wait1.until(ExpectedConditions.urlToBe("https://cloud.cropin.in/dashboard-farm/aggregation-level"));
    driver.findElement(By.xpath("//div/mat-icon[contains(text(),'assignment')]")).click();
    driver.findElement(By.xpath("//a[@href = '/farmer-farm']")).click();

    for (int i = 21; i <= 30; i++) {
      String farmerName = "RajaSeleniumFarmer ";
      String farmercode = "RajaSeleniumFarmer ";
      long farmerMobile = 9649900000L + i;
      wait1.until(ExpectedConditions.urlToBe("https://cloud.cropin.in/farmer-farm"));
      wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span//mat-icon[contains(text(), 'add')]")));
      driver.findElement(By.xpath("//span//mat-icon[contains(text(), 'add')]")).click();
      driver.findElement(By.xpath("//input[@id ='firstName']")).sendKeys(farmerName + i);
      driver.findElement(By.xpath("//input[@id ='farmerCode']")).sendKeys(farmercode + i);
      driver.findElement(By.xpath("//farm-mat-mobile-number//child::farm-mat-select-search")).click();
      driver.findElement(By.xpath("//input[@data-placeholder = 'Search...']")).sendKeys("+91");
      driver.findElement(By.xpath("//mat-option[contains(@id, 'mat-option')][99]")).click();
      driver.findElement(By.xpath("//div/input[@name = 'mobileNumber']")).sendKeys(String.valueOf(farmerMobile));
      driver.findElement(By.xpath("//mat-select[@id= 'assignedTo']")).click();
      driver.findElement(By.xpath("//div[@class = 'mat-form-field-infix' ]/input[@data-placeholder = 'Search']")).sendKeys("Rajasekhar User");
      driver.findElement(By.xpath("//span[contains(text(),'Rajasekhar User')]")).click();
      driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);
      driver.findElement(By.xpath("//span/mat-panel-title[contains(text(), ' Location Information')]")).click();
      driver.findElement(By.xpath("//div/input[@data-placeholder = 'Enter a location' or @name = 'formattedAddress' ]")).sendKeys("Cropin Technology");

      List<WebElement> elements = wait1.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//span[contains(text(), '16th Main Road')]"))));
      if(elements.size()>1){
        System.out.println("If Block");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", elements.get(0));
      }
      else{
        System.out.println("Else Block");
        elements.get(0).click();
      }

      driver.findElement(By.xpath("//mat-panel-title[contains(text(), ' additional information')]")).click();
      driver.findElement(By.xpath("//mat-select[@id = 'farmeradditionl2']")).click();
      driver.findElement(By.xpath("//mat-option//span[contains(text(),'A')]")).click();
      driver.findElement(By.xpath("//span[@class = 'mat-checkbox-label']")).click();
      wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@color = 'primary']"))).click();
      Thread.sleep(2000);
      driver.get("https://cloud.cropin.in/farmer-farm");
    }
  }
}