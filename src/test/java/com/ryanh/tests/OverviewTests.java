package com.ryanh.tests;
import com.ryanh.base.BaseTest;
import com.ryanh.pages.HomePage;
import com.ryanh.pages.OverviewPage;
import org.testng.annotations.Test;

public class OverviewTests extends BaseTest{

    /**
     * Navigate to the overview page, find the first available note, click edit button
     * replace the current note text with "This is a note"
     */
    @Test
    public void editBossNote(){
        HomePage homePage = new HomePage(driver);
        OverviewPage overviewPage = new OverviewPage(driver);

//        replace with a getter method
//        BossCard bossCard = new BossCard(driver, root);

        homePage.navigateToOverview();

        overviewPage.isPageLoaded();
        String text = "This is a note";

//        bossCard.editNote(text);
    }
}
