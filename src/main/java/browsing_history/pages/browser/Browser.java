package browsing_history.pages.browser;

import browsing_history.pages.page.Page;
import browsing_history.pages.position.Position;

public interface Browser {

    void goTo(String pageName);

    void link(Page page);

    void gotoPosition(int i);

    Page getCurrentPage();

    Position getCurrentPosition();

}
