package ru.edu.quickfind;

import ru.edu.quickfind.model.Cable;
import ru.edu.quickfind.model.Graph;

public class Main {
    public static void main(String[] args) {
        init();
    }

    private static void init() {
//        Graph graph = example();
        Graph graph = test3();

        int checkConnection = DepthFirstPaths.countConnectedNodes(graph, 1);
        System.out.println(checkConnection);
        boolean b = checkConnection == graph.getSize();
        System.out.println("is connected: " + b);
        int maxLengthFor = DepthFirstPaths.maxLengthFor(graph, 1);
        System.out.println("Max length for = " + maxLengthFor);
        System.out.println(graph.getLeafsId());

        System.out.println("Max length in graph = " + DepthFirstPaths.maxLengthInGraph(graph));
    }

    private static Graph example() {
        Graph graph = new Graph(6);
        graph.addCab(new Cable(1, 2, 2));
        graph.addCab(new Cable(2, 5, 8));
        graph.addCab(new Cable(2, 3, 6));
        graph.addCab(new Cable(3, 4, 4));
        graph.addCab(new Cable(3, 6, 5));
        System.out.println(graph);
        return graph;
    }

    private static Graph test3() {
        Graph graph = new Graph(9);
        graph.addCab(new Cable(2, 7, 1));
        graph.addCab(new Cable(6, 7, 1));
        graph.addCab(new Cable(7, 5, 1));
        graph.addCab(new Cable(5, 9, 1));
        graph.addCab(new Cable(5, 1, 1));
        graph.addCab(new Cable(1, 4, 1));
        graph.addCab(new Cable(4, 3, 1));
        graph.addCab(new Cable(4, 8, 1));
        System.out.println(graph);
        return graph;
    }
}
