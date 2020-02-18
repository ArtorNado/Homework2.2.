package iterator;

import Node.Tree.KnotNode;

import java.util.*;

public class IteratorBFSPriority implements Iterator {

    private ArrayList<KnotNode> list;
    private Set<KnotNode> visited = new HashSet<>();
    private Queue<KnotNode> queue = new LinkedList<>();

    public IteratorBFSPriority(ArrayList<KnotNode> list, KnotNode startingVertex) {
        this.list = list;
        this.queue.add(startingVertex);
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public KnotNode next() {
        if(!hasNext()) throw new NoSuchElementException();
        KnotNode next = queue.remove();
        ArrayList<KnotNode> sortedChildrens = sort(next.getChildrenList());
        for (KnotNode neighbor: sortedChildrens){
            if(!visited.contains(neighbor)){
                queue.add(neighbor);
                visited.add(neighbor);
            }
        }
        return next;
    }

    private void swap(ArrayList<KnotNode> childrenList, int ind1, int ind2) {
        KnotNode tmp = childrenList.get(ind1);
        childrenList.set(ind1, childrenList.get(ind2));
        childrenList.set(ind2, tmp);
    }

    private ArrayList<KnotNode> sort(ArrayList<KnotNode> childrenList){
        for (int i = 1; i < childrenList.size(); i++) {
            if (childrenList.get(i).getPriority() < childrenList.get(i-1).getPriority()) {
                swap(childrenList, i, i-1);
            }
        }
        return childrenList;
    }
}
