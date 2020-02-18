package Node;
import Node.Tree.KnotNode;
import facade.FacadeForXML;
import iterator.IteratorDFS;

import java.util.ArrayList;

public class TestClass {

    public static ArrayList<KnotNode> roots = new ArrayList<>();

    public static String TypeToString(Type type){
        return type.toString();
    }

    public static void main(String[] args) {
        ArrayList<KnotNode> regions = new ArrayList<>();
        ArrayList<KnotNode> areas = new ArrayList<>();
        ArrayList<KnotNode> towns = new ArrayList<>();
        ArrayList<KnotNode> streets = new ArrayList<>();
        ArrayList<KnotNode> townsTatarstan = new ArrayList<>();
        ArrayList<KnotNode> townsLenin = new ArrayList<>();
        ArrayList<KnotNode> regionsPriv = new ArrayList<>();
        ArrayList<KnotNode> regionsSev = new ArrayList<>();
        roots.add(new KnotNode("Russia", null, areas, Type.COUNTRY, 1));
        areas.add(new KnotNode("Приволжский", roots.get(0), regionsPriv, Type.AREA, 3));
        areas.add(new KnotNode("Северо-западный", roots.get(0), regionsSev, Type.AREA, 2));
        regionsPriv.add(new KnotNode("Tatarstan", areas.get(0), townsTatarstan, Type.REGION, 3));
        regionsSev.add(new KnotNode("Ленинградская область", areas.get(1), townsLenin, Type.REGION, 2));
        townsLenin.add(new KnotNode("Санкт-Петербург", regionsSev.get(0), streets, Type.TOWN, 1));
        townsLenin.add(new KnotNode("Шпильсбург", regionsSev.get(0), streets, Type.TOWN, 1));
        townsTatarstan.add(new KnotNode("Казань", regionsPriv.get(0), streets, Type.TOWN, 2));

        KnotNode newelement =KnotNode.newBuilder()
                .setChildrenList(regionsPriv)
                .setParentReference(areas.get(0))
                .setTitle("BlaBla")
                .setType(Type.AREA)
                .setPriority(123)
                .build();

        Data data = Data.getInstance();
        data.initData();
        FacadeForXML facadeForXML = FacadeForXML.getInstance();
        facadeForXML.writeInXML(data.roots.get(0));
        facadeForXML.readXML("XMLnode.xml");
        /*Interpreter interpreter = new Interpreter(data);
        interpreter.doCommand("add <Russia> <название ноды> <AREA> <1>");*/
    }
}
