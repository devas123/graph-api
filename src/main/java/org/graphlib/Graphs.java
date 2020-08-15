package org.graphlib;

import org.graphlib.exception.NoSuchVertexException;

import java.util.*;

public class Graphs {
    private Graphs() {
    }

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
