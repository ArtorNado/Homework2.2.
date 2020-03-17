package browsing_history.pages.position.video;


public class VideoAdvPosition implements Position {

    private Page adv;

    public VideoAdvPosition(Page adv) {
        this.adv = adv;
    }

    @Override
    public void gotoAdv(Browser browser) {
        browser.link(adv);
    }

    @Override
    public void show(Browser browser) {
        this.gotoAdv(browser);
    }
}
