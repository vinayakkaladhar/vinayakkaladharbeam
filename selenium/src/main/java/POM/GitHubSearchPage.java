package POM;

import Utilities.Utilities;
import io.cucumber.java.sl.In;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GitHubSearchPage extends Utilities {

    public GitHubSearchPage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }

    public static String amount;
    public static String publicLink;


    @FindBy(xpath = ".//input[@name='q'][@aria-label='Search GitHub']")
    public WebElement _searchBoxHomePage;

    @FindBy(xpath = ".//li[@id='jump-to-suggestion-search-global']")
    public WebElement _autoSuggestionsHomePage;

    @FindBy(xpath = ".//h3[text()='No matching files found.']")
    public WebElement _noMatchingFiles;

    @FindBy(xpath = ".//a[contains(text(),'Go to file')]")
    public WebElement _searchFile;

    @FindBy(xpath = ".//input[@type='text'][@name='query']")
    public WebElement _searchInput;

    @FindBy(xpath = ".//ul[@id='tree-browser']/li/a")
    public List<WebElement> _resultCount;

    @FindBy(xpath = ".//h1[text()='Page navigation']/parent::span//table//tr/td//span[text()='Next']")
    public WebElement _nextOption;

    @FindBy(xpath = "//div/a[text()='Settings']")
    public WebElement _settingsOption;

    @FindBy(xpath = "//div/a/span[text()='Languages']")
    public WebElement _chooseLanguageSetting;

    @FindBy(xpath = "//div[@id='langtde']//span[text()='Deutsch']")
    public WebElement _dutchLanguage;

    @FindBy(xpath = ".//div[text()='Save']")
    public WebElement _saveButton;

    @FindBy(xpath = " .//img[@src='/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png']")
    public WebElement _homePageIcon;

    public boolean gitHubHomePage(){
        return _searchBoxHomePage.isDisplayed();
    }

    public boolean verifyAutosuggestion(String text) throws InterruptedException {
        _searchBoxHomePage.sendKeys(text);
        Thread.sleep(2000);
        return _autoSuggestionsHomePage.getText().contains(text);
    }

    public void searchContent(String text){
        _searchBoxHomePage.sendKeys(text);
        _searchBoxHomePage.sendKeys(Keys.ENTER);
    }
    public boolean resultAssertion(){
        return driver.getCurrentUrl().contains("https://github.com/search?q=vinayakkaladharbeam");
    }

    public void clickOnSearchLink(String content){
        driver.navigate().refresh();
        explicitwait(String.format(".//a/em",content));
         driver.findElement(By.xpath(String.format(".//a/em",content))).click();
    }

    public void clickOnSearchFileLink(){
        explicitwait(".//a[contains(text(),'Go to file')]");
        _searchFile.click();
    }

    public void verifySearchFile(String content) throws InterruptedException {
        explicitwait(".//input[@type='text'][@name='query']");
        _searchInput.click();
        _searchInput.clear();
        _searchInput.sendKeys(content);
        Thread.sleep(2000);
    }

    public boolean verifyContentNotFound() throws InterruptedException {
        return _noMatchingFiles.isDisplayed();
    }

    public boolean verifyResultCountForFiles() throws InterruptedException {
        return _resultCount.size()>0;
    }
}
