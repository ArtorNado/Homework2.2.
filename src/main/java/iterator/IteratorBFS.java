package iterator;


import Node.Tree;
import Node.Tree.KnotNode;

import javax.swing.*;
import java.util.*;

public class IteratorBFS implements Iterator {

    private Set<KnotNode> visited = new HashSet<>();
    private Queue<KnotNode> queue = new LinkedList<>();
    private Deque<String> deque = new LinkedList<>();

    public IteratorBFS(KnotNode startingVertex) {
        this.queue.add(startingVertex);
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public KnotNode next() {
        if (!hasNext()) throw new NoSuchElementException();
        KnotNode next = queue.remove();
        for (KnotNode neighbor : next.getChildrenList()) {
            if (!visited.contains(neighbor)) {
                queue.add(neighbor);
                visited.add(neighbor);
            }
        }
        return next;
    }

    public String getPath(KnotNode element) {
        deque.clear();
        while (element.getParentReference() != null) {
            KnotNode parent = element.getParentReference();
            deque.addFirst(parent.getTitle());
            element = parent;
        }
        if (deque == null) return "Not parents";
        else{
            return String.join(", ", deque);
        }
    }

    private KnotNode searchByTitle(String title) throws NullPointerException {
        if (hasNext()) {
            KnotNode element = next();
            if (element.getTitle().equals(title)) {
                return element;
            } else {
                return searchByTitle(title);
            }
        } else {
            return null;
        }
    }

    public ArrayList<KnotNode> getChildrens(String type, String title) {
        KnotNode next;
        if (!hasNext()) throw new NoSuchElementException();
        next = queue.remove();
        while (!(next.getType().name().equals(type) && next.getTitle().equals(title))) {
            for (KnotNode neighbor : next.getChildrenList()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
            if (hasNext()) next = queue.remove();
            else return null;
        }
        return next.getChildrenList();
    }
}
