package ru.edu.quickfind;
/******************************************************************************
 *  Compilation:  javac DepthFirstPaths.java
 *  Execution:    java DepthFirstPaths G s
 *  Dependencies: Graph.java Stack.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/41graph/tinyCG.txt
 *                https://algs4.cs.princeton.edu/41graph/tinyG.txt
 *                https://algs4.cs.princeton.edu/41graph/mediumG.txt
 *                https://algs4.cs.princeton.edu/41graph/largeG.txt
 *
 *  Run depth first search on an undirected graph.
 *  Runs in O(E + V) time.
 *
 *  %  java Graph tinyCG.txt
 *  6 8
 *  0: 2 1 5
 *  1: 0 2
 *  2: 0 1 3 4
 *  3: 5 4 2
 *  4: 3 2
 *  5: 3 0
 *
 *  % java DepthFirstPaths tinyCG.txt 0
 *  0 to 0:  0
 *  0 to 1:  0-2-1
 *  0 to 2:  0-2
 *  0 to 3:  0-2-3
 *  0 to 4:  0-2-3-4
 *  0 to 5:  0-2-3-5
 *
 ******************************************************************************/

import ru.edu.quickfind.model.Graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * The {@code DepthFirstPaths} class represents a data type for finding
 * paths from a source vertex <em>s</em> to every other vertex
 * in an undirected graph.
 * <p>
 * This implementation uses depth-first search.
 * The constructor takes time proportional to <em>V</em> + <em>E</em>,
 * where <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
 * It uses extra space (not including the graph) proportional to <em>V</em>.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/41graph">Section 4.1</a>
 * of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class DepthFirstPaths {
    private static boolean[] marked;    // marked[v] = is there an s-v path?
    private int maxLength = 0;         // source vertex

    private DepthFirstPaths() {
    }

    public static int countConnectedNodes(Graph graph, int v) {
        marked = new boolean[graph.getSize() + 1];
        return dfs(graph, v);
    }

    // depth first search from v
    private static int dfs(Graph graph, int v) {
        int visitedVertices = 1;
        marked[v] = true;
        for (Integer id : graph.getNeighborsFor(v)) {
            if (!marked[id]) {
                visitedVertices += dfs(graph, id);
            }
        }
        return visitedVertices;
    }

    public static int maxLengthInGraph(Graph graph) {
        // first bfs to find one end point of
        // longest path
        BfsResult firstTry = bfs(graph, 1);
        System.out.println("first try; " + firstTry);
        //  second bfs to find actual longest path
        return bfs(graph, firstTry.getForNode()).getMax();
    }

    public static int maxLengthFor(Graph graph, int v) {
        return bfs(graph, v).getMax();
    }

    private static BfsResult bfs(Graph graph, int v) {
        int[] distance = new int[graph.getSize() + 1];
        Arrays.fill(distance, -1);
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.push(v);
        distance[v] = 0;

        while (!queue.isEmpty()) {
            Integer t = queue.poll();
            //  loop for all adjacent nodes of node-t
            for (Integer s : graph.getNeighborsFor(t)) {
                // push node into queue only if
                // it is not visited already
                if (distance[s] == -1) {
                    queue.push(s);
                    // make distance of s, one more
                    // than distance of t
                    distance[s] = distance[t] + graph.getTransTimeFor(s, t);
                }
            }
        }
        return findMaxLength(distance);
    }

    private static BfsResult findMaxLength(int[] distance) {
        int forNode = 0;
        Integer max = null;
        for (int i = 0, n = distance.length; i < n; ++i) {
            int value = distance[i];
            if (max != null && value <= max)
                continue;
            max = value;
            forNode = i;
        }
        return new BfsResult(max, forNode);
    }


    /**
     * Is there a path between the source vertex {@code s} and vertex {@code v}?
     *
     * @param v the vertex
     * @return {@code true} if there is a path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }
}

