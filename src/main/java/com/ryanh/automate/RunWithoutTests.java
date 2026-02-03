package com.ryanh.automate;

import com.ryanh.pages.HomePage;
import com.ryanh.pages.LoginPage;
import com.ryanh.utils.DriverFactory;
import org.openqa.selenium.WebDriver;


public class RunWithoutTests {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver(DriverFactory.BrowserTypes.CHROME);

        driver.get("https://wowutils.com/viserio-cooldowns");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.navigateToLogin();
        loginPage.login(System.getenv("BATTLENET_EMAIL_TEST"), System.getenv("BATTLENET_PASSWORD_TEST"));
    }
}
