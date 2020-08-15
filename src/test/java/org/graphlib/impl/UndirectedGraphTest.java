package org.graphlib.impl;

import org.graphlib.Graph;
import org.graphlib.TestUtils;
import org.graphlib.exception.NoSuchVertexException;
import org.graphlib.exception.VertexExistsException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UndirectedGraphTest {
    @Test
    public void testPositive() throws VertexExistsException, NoSuchVertexException {
        Graph<Integer> graph = new UndirectedGraph<>();
        TestUtils.initGraph(graph);
    }

    @Test(expected = VertexExistsException.class)
    public void testDuplicateVertex() throws VertexExistsException {
        Graph<Integer> graph = new UndirectedGraph<>();
        graph.addVertex(1);
        graph.addVertex(1);
    }

    @Test(expected = NoSuchVertexException.class)
    public void testNoSuchVertex() throws NoSuchVertexException, VertexExistsException {
        Graph<Integer> graph = new UndirectedGraph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(0, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAdjImmutable() throws NoSuchVertexException, VertexExistsException {
        Graph<Integer> graph = new Digraph<>();
        TestUtils.initGraph(graph);
        List<Integer> adj = graph.adj(0);
        adj.iterator().next();
        adj.iterator().remove();
        adj.add(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAdjImmutableCannotAdd() throws NoSuchVertexException, VertexExistsException {
        Graph<Integer> graph = new Digraph<>();
        TestUtils.initGraph(graph);
        List<Integer> adj = graph.adj(0);
        adj.add(0);
    }

    @Test
    public void testAdj() throws NoSuchVertexException, VertexExistsException {
        Graph<Integer> graph = new Digraph<>();
        TestUtils.initGraph(graph);
        List<Integer> adj = graph.adj(1);
        Assert.assertEquals(2, adj.size());
    }
}

