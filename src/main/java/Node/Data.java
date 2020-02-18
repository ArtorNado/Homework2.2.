package Node;
import Node.Tree.KnotNode;
import java.util.ArrayList;

public class Data {

    private static Data instatce;

    public Data() {
    }

    public static Data getInstance() {
        if (instatce == null) instatce = new Data();
        return instatce;
    }

    public ArrayList<KnotNode> roots = new ArrayList<>();
    public ArrayList<KnotNode> regions = new ArrayList<>();
    public ArrayList<KnotNode> areas = new ArrayList<>();
    public ArrayList<KnotNode> towns = new ArrayList<>();
    public ArrayList<KnotNode> streets = new ArrayList<>();
    public ArrayList<KnotNode> townsTatarstan = new ArrayList<>();
    public ArrayList<KnotNode> townsLenin = new ArrayList<>();
    public ArrayList<KnotNode> regionsPriv = new ArrayList<>();
    public ArrayList<KnotNode> regionsSev = new ArrayList<>();

    public void initData() {
        roots.add(new KnotNode("Russia", null, areas, Type.COUNTRY, 1));
        areas.add(new KnotNode("Приволжский", roots.get(0), regionsPriv, Type.AREA, 3));
        areas.add(new KnotNode("Северо-западный", roots.get(0), regionsSev, Type.AREA, 2));
        regionsPriv.add(new KnotNode("Tatarstan", areas.get(0), townsTatarstan, Type.REGION, 3));
        regionsSev.add(new KnotNode("Ленинградская область", areas.get(1), townsLenin, Type.REGION, 2));
        townsLenin.add(new KnotNode("Санкт-Петербург", regionsSev.get(0), streets, Type.REGION, 1));
        townsTatarstan.add(new KnotNode("Казань", regionsPriv.get(0), streets, Type.REGION, 2));
    }
}
