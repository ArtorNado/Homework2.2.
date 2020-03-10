package browsing_history.pages.interpretator.components;

import browsing_history.pages.browser.Browser;
import browsing_history.pages.browser.HistorySavedBrowser;
import browsing_history.pages.interpretator.Context;
import browsing_history.pages.interpretator.core.anotation.CmdMapping;
import browsing_history.pages.interpretator.core.util.Commands;
import browsing_history.pages.page.Page;

public class BrowserOperations {

    @CmdMapping("goto")
    private void goTo(Context context, String[] args) {
        Commands.requireSize(args, 1);

        Browser browser = context.getAttribute("browser", Browser.class);
        String pageName = args[0];

        browser.goTo(pageName);
    }

    @CmdMapping("link")
    private void link(Context context, String[] args) {
        Commands.requireSize(args, 1);

        Browser browser = context.getAttribute("browser", Browser.class);
        String pageName = args[0];

        Page page = browser.getCurrentPage().getLinks().stream()
                .filter(p -> p.getName().equals(pageName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("no page with that name"));

        browser.link(page);
    }

    @CmdMapping("back")
    private void back(Context context, String[] args) {
        Commands.requireSize(args, 0);
        HistorySavedBrowser browser = context.getAttribute("browser", HistorySavedBrowser.class);
        browser.back();
    }

    @CmdMapping("forward")
    private void forward(Context context, String[] args) {
        Commands.requireSize(args,0);
        HistorySavedBrowser browser = context.getAttribute("browser", HistorySavedBrowser.class);
        browser.forward();
    }

    @CmdMapping("gotoposition")
    private void gotoPosition(Context context, String[] args) {
        Commands.requireSize(args, 1);
        Browser browser = context.getAttribute("browser", Browser.class);
        int position = Integer.parseInt(args[0]);
        browser.gotoPosition(position);
    }

    // gotoadv
    @CmdMapping("gotoadv")
    private void gotoAdv(Context context, String[] args) {
        Commands.requireSize(args, 0);
        Browser browser = context.getAttribute("browser", Browser.class);
        browser.getCurrentPosition().gotoAdv(browser);
    }

}
