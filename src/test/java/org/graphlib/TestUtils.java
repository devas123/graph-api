package org.graphlib;

import org.graphlib.exception.NoSuchVertexException;
import org.graphlib.exception.VertexExistsException;

public class TestUtils {
    private TestUtils() {}

    public static <Vertex> void initGraph(Graph<Integer> graph) throws VertexExistsException, NoSuchVertexException {
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 4);
        graph.addEdge(4, 5);
    }

}
