package org.graphlib.impl;

import org.graphlib.Graph;
import org.graphlib.TestUtils;
import org.graphlib.exception.NoSuchVertexException;
import org.graphlib.exception.VertexExistsException;
import org.junit.Test;

public class DigraphTest {
    @Test
    public void testPositive() throws VertexExistsException, NoSuchVertexException {
        Graph<Integer> graph = new Digraph<>();
        TestUtils.initGraph(graph);
    }

    @Test(expected = VertexExistsException.class)
    public void testDuplicateVertex() throws VertexExistsException {
        Graph<Integer> graph = new Digraph<>();
        graph.addVertex(1);
        graph.addVertex(1);
    }

    @Test(expected = NoSuchVertexException.class)
    public void testNoSuchVertex() throws NoSuchVertexException, VertexExistsException {
        Graph<Integer> graph = new Digraph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(0, 1);
    }
}
