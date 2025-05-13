package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import pages.DownloadPage;

public class DownloadSteps {
    private static final Logger logger = LogManager.getLogger();
    private final TestContext testContext;
    private final DownloadPage downloadPage;

    public DownloadSteps(TestContext testContext) {
        this.testContext = testContext;
        this.downloadPage = new DownloadPage(testContext.getDriver());
    }
    @When("User clicks Download tab")
    public void user_clicks_download_tab() {
        downloadPage.clickDownloadTab();
        logger.info("Clicked on Download tab.");
    }

    @Then("The user should see the message Download some videos to find them here.")
    public void the_user_should_see_the_message_no_downloaded_videos_found() {
        String message = downloadPage.getNoDownloadedVideosText();
        logger.info("Message displayed: {}", message);
        Assert.assertTrue(message.contains("Download some videos to find them here."), "Expected message not found.");
    }
    @When("User clicks on three dots in any video")
    public void user_clicks_on_three_dots_in_any_video() {
        downloadPage.dismissStartupPopupsIfPresent();
        downloadPage.clickThreeDotsForDownload();
        logger.info("Clicked on three dots.");
    }

    @Then("User should see the Download option")
    public void user_should_see_the_download_option() {
        String downloadText = downloadPage.getDownloadText();
        logger.info("Download option text: {}", downloadText);
        Assert.assertTrue(downloadText.contains("Download"), "Download option not visible.");
    }
    @Given("User open any video")
    public void user_opens_any_video() {
        downloadPage.dismissStartupPopupsIfPresent();
        logger.info("App launched and popups dismissed.");
    }

    @When("User clicks on any video")
    public void user_clicks_on_any_video() {
        downloadPage.dismissStartupPopupsIfPresent();
        downloadPage.clickVideo();
        logger.info("Clicked on a video.");
    }
    @Then("User should see the Download button")
    public void user_should_see_the_download_button() {
        String actualText = downloadPage.getDownloadText();
        System.out.println("Download button text retrieved: " + actualText);
        Assert.assertTrue(actualText.equalsIgnoreCase("Download"), "Download button not displayed");
    }


    @When("clicks on Download")
    public void clicks_on_download() {
        downloadPage.dismissStartupPopupsIfPresent();
        downloadPage.clickDownload();
        downloadPage.clickAllowDownloadIfPresent();
        downloadPage.allowToAccessIfPresent();
        logger.info("Clicked on Download.");
    }

    @Then("Toast message Download should be displayed")
    public void toast_message_download_should_be_displayed() {
        boolean toastShown = downloadPage.waitForToastMessage("Downloading");
        Assert.assertTrue(toastShown, "Download toast message not displayed");
        logger.info("Download toast message verified.");
    }

    @When("User clicks on three dots in Downloaded video")
    public void user_clicks_on_three_dots_in_downloaded_video() {
        downloadPage.dismissStartupPopupsIfPresent();
        downloadPage.clickThreeDotsForDownload();
        downloadPage.clickDownload();
        downloadPage.clickAllowDownloadIfPresent();
        downloadPage.allowToAccessIfPresent();
        downloadPage.dismissStartupPopupsIfPresent();
        downloadPage.allowToAccessIfPresent();
        downloadPage.clickAllowDownloadIfPresent();
        downloadPage.clickThreeDotsForDownload();

    }

    @Then("User should see the DeleteDownload option")
    public void user_should_see_the_deletedownload_option() {
        String deleteDownloadText = downloadPage.getDeleteDownloadText();
        logger.info("Delete Download option text: {}", deleteDownloadText);
        Assert.assertTrue(deleteDownloadText.contains("Delete"), "Delete Download option not visible.");
    }

    @When("clicks on DeleteDownload button")
    public void clicks_on_deletedownload_button() {
        downloadPage.clickDeleteDownload();
        logger.info("Clicked on Delete Download button.");
    }

    @Given("User opens an already Downloaded video")
    public void user_opens_an_already_downloaded_video() {
        downloadPage.dismissStartupPopupsIfPresent();
        downloadPage.clickDownloadTab(); // assuming this shows downloaded videos
        downloadPage.clickVideo();
        logger.info("Opened an already downloaded video.");
    }

    @Then("User should see the Delete Download option")
    public void user_should_see_the_delete_download_option() {
        boolean visible = downloadPage.isDeleteDownloadOptionVisible();
        Assert.assertTrue(visible, "Delete Download option is not visible");
        logger.info("Verified presence of Delete Download option.");
    }

    @Then("User should see the Delete Download button")
    public void user_should_see_the_delete_download_button() {
        boolean visible = downloadPage.isDeleteDownloadOptionVisible();
        Assert.assertTrue(visible, "Delete Download button is not visible");
        logger.info("Verified presence of Delete Download button.");
    }

    @When("User clicks on Delete Download")
    public void user_clicks_on_delete_download() {
        downloadPage.clickDeleteDownload();
        logger.info("Clicked on Delete Download.");
    }
    @And("Clicks on three dots in Downloaded tab")
    public void clicks_on_three_dots_in_downloaded_tab() {
        downloadPage.clickThreeDotsForDownload();
        logger.info("Clicked on three dots in Downloaded tab.");
    }

    @When("User clicks on DeleteDownload in Downloaded tab")
    public void user_clicks_on_deletedownload_in_downloaded_tab() {
        downloadPage.clickDeleteDownloadInDownloadedTab();
        logger.info("Clicked on Delete Download in Downloaded tab.");
    }

    @Then("Toast message Delete Downloaded should be displayed")
    public void toast_message_delete_downloaded_should_be_displayed() {
        boolean toastShown = downloadPage.waitForToastMessage("Delete");
        Assert.assertTrue(toastShown, "Delete toast message not displayed");
        logger.info("Delete toast message verified.");
    }
}
