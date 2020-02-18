package facade;

import Node.Tree.KnotNode;
import Node.Tree;
import iterator.IteratorBFS;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.IOException;

public class FacadeForJson {

    private static FacadeForJson instatce;

    private FacadeForJson() {
    }

    public static FacadeForJson getInstance() {
        if (instatce == null) instatce = new FacadeForJson();
        return instatce;
    }

    public void writeInJson(Tree.KnotNode startingVertex) {
        IteratorBFS iteratorBFS = new IteratorBFS(startingVertex);
        ObjectMapper mapper = new ObjectMapper();
        JSONObject object = new JSONObject();
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("write.json"));
            int i = 1;
            while (iteratorBFS.hasNext()) {
                object.put(i, iteratorBFS.next());
                i++;
            }
            writer.write(mapper.writeValueAsString(object));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<KnotNode> readJson() {
        ArrayList<KnotNode> list = new ArrayList<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get("write.json"));
            ObjectMapper mapper = new ObjectMapper();
            JsonNode parser = mapper.readTree(reader);
            for (JsonNode j : parser) {
                KnotNode node = mapper.readValue(j, KnotNode.class);
                list.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

