import POM.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

@Listeners(Utilities.ListenerTest.class)

public class ConsoleApplication extends GitHubSearchPage {
    public GitHubSearchPage gitHubSearchPage;
    boolean result;

    public static void setUp() {
        driver = getDriver();
    }

    public static void main(String args[]) throws IOException {
        setUp();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter the repository name : ");
        String name = br.readLine();
        driver.get("https://github.com/" + name);
        String releases = driver.findElement(By.xpath(".//a[contains(text(),'Releases')]/span")).getText();
        String stars = driver.findElement(By.xpath(".//a[contains(@class,'social-count js-social-count')]")).getText();
        driver.findElement(By.xpath(".//span[contains(text(),'Latest')]/parent::div/span[contains(text(),'release')]")).click();
        String latest = driver.getCurrentUrl();
        System.out.println("Stars: "+stars);
        System.out.println("Releases: "+releases);
        System.out.println("Last Release: "+latest);
    }
}