package org.graphlib;

import org.graphlib.exception.NoSuchVertexException;
import org.graphlib.exception.VertexExistsException;
import org.graphlib.impl.Digraph;
import org.graphlib.impl.UndirectedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.graphlib.TestUtils.initGraph;

public class GraphsTest {

    @Test(expected = NullPointerException.class)
    public void testNull() throws NoSuchVertexException {
        Graphs.getPath(null, 0, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testNullVertex() throws NoSuchVertexException {
        Graph<Integer> graph = new Digraph<>();
        Graphs.getPath(graph, null, 1);
    }

    @Test(expected = NullPointerException.class)
    public void testNullVertex2() throws NoSuchVertexException {
        Graph<Integer> graph = new Digraph<>();
        Graphs.getPath(graph, 0, null);
    }
    @Test(expected = NoSuchVertexException.class)
    public void testNodExistingVertex() throws NoSuchVertexException {
        Graph<Integer> graph = new Digraph<>();
        Graphs.getPath(graph, 0, 1);
    }

    @Test
    public void testPathFoundDirected() throws NoSuchVertexException, VertexExistsException {
        Graph<Integer> graph = new Digraph<>();
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

        List<Integer> path = Graphs.getPath(graph, 0, 5);
        Assert.assertNotNull(path);
        Assert.assertArrayEquals(new Integer[]{0, 1, 4, 5}, path.toArray(new Integer[0]));
    }

    @Test
    public void testPathNotFoundDirected() throws NoSuchVertexException, VertexExistsException {
        Graph<Integer> graph = new Digraph<>();
        initGraph(graph);
        List<Integer> path = Graphs.getPath(graph, 3, 0);
        Assert.assertNotNull(path);
        Assert.assertEquals(0, path.size());
    }


    @Test
    public void testPathFoundUnDirected() throws NoSuchVertexException, VertexExistsException {
        Graph<Integer> graph = new UndirectedGraph<>();
        initGraph(graph);
        List<Integer> path = Graphs.getPath(graph, 3, 0);
        Assert.assertNotNull(path);
        Assert.assertArrayEquals(new Integer[]{3, 1, 0}, path.toArray(new Integer[0]));
    }

    @Test
    public void testPathNotFoundUnDirected() throws NoSuchVertexException, VertexExistsException {
        Graph<Integer> graph = new UndirectedGraph<>();
        initGraph(graph);
        graph.addVertex(7);
        List<Integer> path = Graphs.getPath(graph, 3, 7);
        Assert.assertNotNull(path);
        Assert.assertEquals(0, path.size());
    }
}
