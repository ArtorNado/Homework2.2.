package browsing_history.pages.position.video;

import browsing_history.pages.page.Page;
import browsing_history.pages.position.Position;
import browsing_history.pages.position.PositionFactory;

public class VideoAdvFactory implements PositionFactory {
    @Override
    public Position create(Page adv) {
        return new VideoAdvPosition(adv);
    }
}
