package com.thoughtworks.gauge.maven;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class LoginUsingTable {

    public WebDriver driver;

    @Step("Navigate to application url")
    public void LaunchApplication() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suchita\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Step("Login as user and password <Table>")
    public void LoginToApplication(Table table) throws InterruptedException {

        List<TableRow> rows = table.getTableRows();
        List<String> columnNames = table.getColumnNames();
        for (TableRow row : rows) {
            String cell1=row.getCell(columnNames.get(0));
            WebElement userid = driver.findElement(By.id("txtUsername"));
            userid.sendKeys(cell1);
            String cell2=row.getCell(columnNames.get(1));
            WebElement pass = driver.findElement(By.id("txtPassword"));
            pass.sendKeys(cell2);
            driver.findElement(By.name("Submit")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[@id='welcome']")).click();
            Thread.sleep(2000);
            WebElement logout=driver.findElement(By.xpath("//a[text()='Logout']"));
            logout.click();
            Thread.sleep(1500);
            driver.close();


        }

    }



}
