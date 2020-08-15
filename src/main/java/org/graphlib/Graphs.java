package org.graphlib;

import org.graphlib.exception.NoSuchVertexException;

import java.util.*;

/**
 * Operations on graphs.
 */
public class Graphs {
    private Graphs() {
    }

    /**
     * Get path from vertex {@code from} to the vertex {@code to} in the {@code graph}
     *
     * @param graph - the graph
     * @param from - start vertex.
     * @param to - end vertex.
     * @return list of vertices connecting {@code from} (inclusive) and {@code to} (inclusive)
     * @throws NoSuchVertexException if {@code from} or {@code to} is not part of the graph.
     */
    public static <Vertex> List<Vertex> getPath(AdjacentProvider<Vertex> graph, Vertex from, Vertex to) throws NoSuchVertexException {
        Objects.requireNonNull(graph);
        Objects.requireNonNull(from);
        Objects.requireNonNull(to);
        Queue<Vertex> bfsQueue = new LinkedList<>();
        Set<Vertex> visited = new HashSet<>();
        HashMap<Vertex, Vertex> prev = new HashMap<>();
        bfsQueue.add(from);
        while (!bfsQueue.isEmpty()) {
            Vertex v = bfsQueue.poll();
            visited.add(v);
            if (v.equals(to)) {
                return calculatePath(prev, from, to);
            }
            for (Vertex child : graph.adj(v)) {
                if (!visited.contains(child)) {
                    prev.put(child, v);
                    bfsQueue.add(child);
                }
            }
        }
        return Collections.emptyList();
    }

    private static <Vertex> List<Vertex> calculatePath(HashMap<Vertex, Vertex> prev, Vertex from, Vertex to) {
        List<Vertex> result = new LinkedList<>();
        Vertex tmp = to;
        while (tmp != from) {
            result.add(tmp);
            tmp = prev.get(tmp);
        }
        result.add(tmp);
        Collections.reverse(result);
        return result;
    }
}
