package browsing_history.pages.position;

import browsing_history.pages.browser.Browser;
import browsing_history.pages.browser.HistorySavedBrowserPageStorageBased;

public interface Position {

    void gotoAdv(Browser browser);

    void show(HistorySavedBrowserPageStorageBased browser);
}
