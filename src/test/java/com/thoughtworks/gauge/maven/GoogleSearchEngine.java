package com.thoughtworks.gauge.maven;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;


public class GoogleSearchEngine {

    public static WebDriver driver;

    @Step("Navigate to url")
    public void navigateTo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suchita\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.co.in");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Step("Enter selenium automation in the search box and submit")
    public void enterQuery() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium automation");
        searchBox.submit();
        Thread.sleep(2000);
    }

    @Step("Verify result as 'selenium automation - Google Search' as result")
    public void verifySearchResult() {
        String result = driver.getTitle();
        Assert.assertEquals(result , "selenium automation - Google Search");
        driver.close();
    }


}
