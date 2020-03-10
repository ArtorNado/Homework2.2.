package browsing_history.pages.position.text;

import browsing_history.pages.browser.Browser;
import browsing_history.pages.page.Page;
import browsing_history.pages.position.Position;


public class TextAdvPosition implements Position {

    private Page page;

    public TextAdvPosition(Page page) {
        this.page = page;
    }

    @Override
    public void gotoAdv(Browser browser) {
        browser.link(page);
    }

    @Override
    public void show(Browser browser) {
        // just "show"
    }
}
