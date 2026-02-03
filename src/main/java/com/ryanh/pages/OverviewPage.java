package com.ryanh.pages;

import com.ryanh.base.BasePage;
import com.ryanh.components.BossCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class OverviewPage extends BasePage {
    private final By bossCards = By.cssSelector("div.flex div.grid div.border:not(.items-center)");

    public OverviewPage(WebDriver driver){
        super(driver);
    }

    public void isPageLoaded() {
        waitUntilPageLoaded();
    }

    /**
     * Get all BossCard objects on the Overview Page
     * @return List of BossCard objects
     */
    public List<BossCard> getBossCards() {
        return driver.findElements(bossCards).stream().map(root -> new BossCard(driver,root)).toList();
    }


}
