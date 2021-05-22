import POM.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(Utilities.ListenerTest.class)

public class GitHubSearch extends GitHubSearchPage {
    public GitHubSearchPage gitHubSearchPage;
    boolean result;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        gitHubSearchPage = new GitHubSearchPage();
        Reporter.log("Browser Launched");
    }

    @Test(description = "Navigation to github.com" , priority = 0)
    public void verifyNavigationToGitHub() throws InterruptedException, IOException, InvalidFormatException {
        driver.get("https://github.com/");
        Reporter.log("Navigated to github.com");
        result = gitHubSearchPage.gitHubHomePage();
        Assert.assertTrue(result, "search box is available on home page");
        Reporter.log("Search box is available");
        result = result && gitHubSearchPage.verifyAutosuggestion("vinayakkaladharbeam");
        Assert.assertTrue(result, "autosuggestion verified");
        Reporter.log("Autosuggestion dialog box is displayed");
    }

    @Test(description = "Verify navigation to repository" , priority = 1)
    public void VerifyNavigationToRepository() throws InterruptedException, IOException, InvalidFormatException {
        driver.get("https://github.com/");
        Reporter.log("Navigated to github.com");
        result = gitHubSearchPage.gitHubHomePage();
        gitHubSearchPage.searchContent("vinayakkaladharbeam");
        Reporter.log("Searched repository: vinayakkaladharbeam");
        result = gitHubSearchPage.resultAssertion();
        Assert.assertTrue(result, "repository display verified");
        Reporter.log("Repository: vinayakkaladharbeam is displayed");
        gitHubSearchPage.clickOnSearchLink("vinayakkaladharbeam");
        Assert.assertTrue(driver.getCurrentUrl().contains("vinayakkaladharbeam"));
        Reporter.log("Landed on the repository page: vinayakkaladharbeam");
    }

    @Test(description = "Verify searching files inside the repository" , priority = 2)
    public void verifySearchFileFunctionality() throws InterruptedException, IOException, InvalidFormatException {
        driver.get("https://github.com/");
        Reporter.log("Navigated to github.com");
        result = gitHubSearchPage.gitHubHomePage();
        gitHubSearchPage.searchContent("vinayakkaladharbeam");
        result = gitHubSearchPage.resultAssertion();
        Assert.assertTrue(result, "repository display verified");
        gitHubSearchPage.clickOnSearchLink("vinayakkaladharbeam");
        gitHubSearchPage.clickOnSearchFileLink();
        gitHubSearchPage.verifySearchFile("vinayak");
        Reporter.log("Searching for file: vinayak");
        result = gitHubSearchPage.verifyContentNotFound();
        Assert.assertTrue(result, "No matching files found message is displayed");
        Reporter.log("No matching files found message is displayed");
        gitHubSearchPage.verifySearchFile("readme");
        Reporter.log("Searching for file: readme");
        result = gitHubSearchPage.verifyResultCountForFiles();
        Assert.assertTrue(result, "File:readme is displayed");
        Reporter.log("File:readme is displayed");
    }

    @AfterMethod
    public void closeDriver() {
    }
}