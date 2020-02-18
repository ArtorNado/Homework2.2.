package iterator;

import Node.Tree.KnotNode;

import java.util.*;

public class IteratorDFS implements Iterator {

    private Set<KnotNode> visited = new HashSet<>();
    private KnotNode next;
    private Stack<java.util.Iterator<KnotNode>> stack = new Stack<java.util.Iterator<KnotNode>>();

    public IteratorDFS(KnotNode startingVertex) {
        this.stack.push(startingVertex.getChildrenList().iterator());
        this.next = startingVertex;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public KnotNode next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            visited.add(next);
            return next;
        } finally {
            process();
        }
    }

    public void process() {
        java.util.Iterator<KnotNode> neighbors = stack.peek();
        do {
            while (!neighbors.hasNext()) {
                stack.pop();
                if (stack.isEmpty()) {
                    next = null;
                    return;
                }
                neighbors = stack.peek();
            }
            next = neighbors.next();
        } while (visited.contains(next));
        stack.push(next.getChildrenList().iterator());
    }
}
