package browsing_history.pages.page;

import browsing_history.pages.position.Position;

import java.util.List;
import java.util.Map;

public interface Page {

    List<Page> getLinks();

    String getName();

    Map<Integer, Position> getPositions();

}
