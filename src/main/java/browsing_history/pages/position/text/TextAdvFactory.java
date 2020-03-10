package browsing_history.pages.position.text;

import browsing_history.pages.page.Page;
import browsing_history.pages.position.Position;
import browsing_history.pages.position.PositionFactory;

public class TextAdvFactory implements PositionFactory {
    @Override
    public Position create(Page adv) {
        return new TextAdvPosition(adv);
    }
}
