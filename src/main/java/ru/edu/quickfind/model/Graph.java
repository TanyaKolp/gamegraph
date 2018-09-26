package ru.edu.quickfind.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
    private int size;
    private int[] nodes;
    private List<Cable> cables;

    public Graph(int size) {
        cables = new ArrayList<>(size + 1);
        this.size = size;
        this.nodes = new int[size + 1];
    }

    public void addCab(Cable cable) {
        cables.add(cable);
        nodes[cable.getFirstNodeId()] += 1;
        nodes[cable.getSecondNodeId()] += 1;
    }

    public void removeCable(int id){
        Cable cable = cables.get(id);
        nodes[cable.getFirstNodeId()] -= 1;
        nodes[cable.getSecondNodeId()] -= 1;
        cables.remove(cable);
    }

    public int getSize() {
        return this.size;
    }

    public List<Integer> getNeighborsFor(int vId) {
        List<Integer> neighbors = new ArrayList<>(size);
        for (Cable cable : cables) {
            if (cable.getFirstNodeId() == vId) {
                neighbors.add(cable.getSecondNodeId());
                continue;
            }
            if (cable.getSecondNodeId() == vId) {
                neighbors.add(cable.getFirstNodeId());
            }
        }
        if (neighbors.isEmpty()) {
            return Collections.emptyList();
        }
        return neighbors;
    }

    public List<Integer> getLeafsId() {
        List<Integer> leafs = new ArrayList<>(nodes.length);
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == 1) {
                leafs.add(i);
            }
        }
        return leafs;
    }

    public List<Integer> getNodesWithNCables(int nCables) {
        List<Integer> leafs = new ArrayList<>(nodes.length);
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == nCables) {
                leafs.add(i);
            }
        }
        return leafs;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "cables=" + cables +
                '}';
    }
}
