package interpreter;

import Node.Data;
import Node.Tree.KnotNode;
import Node.Type;
import facade.FacadeForJson;
import iterator.Iterator;
import iterator.IteratorBFS;
import iterator.IteratorDFS;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {

    private Data data;
    private IteratorBFS iteratorBFS;

    public Interpreter(Data data) {
        this.data = data;
        this.iteratorBFS =  new IteratorBFS(data.roots.get(0));
    }

    public ArrayList<KnotNode> doCommand(String command) {
        this.data = Data.getInstance();
        data.initData();
        if (command.startsWith("return children")) {
            return returnChildren(command);
        }
        if (command.startsWith("add")) {
            addVertex(command);
        }
        if (command.startsWith("delete")) {
            delete(command);
        }
        if (command.startsWith("save")) {
            FacadeForJson.getInstance().writeInJson(data.roots.get(0));
        }
        return null;
    }


    public ArrayList<KnotNode> returnChildren(String command) {
        String[] subStr;
        String delimiter = " ";
        subStr = command.split(delimiter);
        String type = subStr[2];
        StringBuilder title = new StringBuilder();
        for (int i = 3; i < subStr.length; i++) {
            title.append(subStr[i]);
            if (subStr.length - 1 != i) {
                title.append(" ");
            }
        }
        return getChildren(type, title.toString());
    }

    private void delete(String command) {
        KnotNode element;
        String[] subStr;
        String delimiter = "<";
        subStr = command.split(delimiter);
        subStr = takeOff(subStr);
        String[] parentPath = subStr[0].split(", ");
        element = getElementByPath(parentPath);
        element.getParentReference().getChildrenList().remove(element);
    }


    private KnotNode addVertex(String command) {
        KnotNode element;
        String[] subStr;
        String delimiter = "<";
        subStr = command.split(delimiter);
        subStr = takeOff(subStr);
        String[] parentPath = subStr[0].split(", ");
        element = getElementByPath(parentPath);
        try {
            if (element == null) throw new Exception("Родитель не найден");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (!checkClone(element, subStr[1])) return creatElement(subStr, element);
            else throw new Exception("Вершина уже существует");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String[] takeOff(String[] subStr) {
        String regex = "(.*)(?=>)";
        Pattern p = Pattern.compile(regex);
        int i = 0;
        for (String s : subStr) {
            Matcher m = p.matcher(s);
            if (m.find()) {
                subStr[i] = m.group(1);
                i++;
            }
        }
        return subStr;
    }

    private Boolean checkClone(KnotNode element, String title) {
        for (KnotNode children : element.getChildrenList()) {
            if (children.getTitle().equals(title)) return true;
        }
        return false;
    }

    private KnotNode creatElement(String[] subStr, KnotNode parent) {
        return KnotNode.newBuilder()
                .setChildrenList(null)
                .setParentReference(parent)
                .setTitle(subStr[1])
                .setType(Type.valueOf(subStr[2]))
                .setPriority(Integer.parseInt(subStr[3]))
                .build();
    }

    public KnotNode getElementByPath(String[] parentPath) {
        KnotNode element;
        StringBuilder builder = new StringBuilder();
        int b = 0;
        while (b < parentPath.length - 1) {
            builder.append(parentPath[b]);
            b++;
            if (!(b == parentPath.length - 1)) {
                builder.append(" ");
            }
        }
        while (iteratorBFS.hasNext()) {
            element = iteratorBFS.next();
            if (iteratorBFS.getPath(element).endsWith(builder.toString()) && element.getTitle().equals(parentPath[parentPath.length - 1]))
                return element;
        }
        return null;
    }

    public ArrayList<KnotNode> getChildren(String type, String title) {
        iteratorBFS = new IteratorBFS(data.roots.get(0));
        return iteratorBFS.getChildrens(type, title);
    }

}
