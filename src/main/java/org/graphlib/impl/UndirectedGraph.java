package org.graphlib.impl;

import org.graphlib.Graph;
import org.graphlib.exception.NoSuchVertexException;
import org.graphlib.exception.VertexExistsException;

/**
 * Undirected graph.
 * @param <Vertex> type of the vertices.
 */
public class UndirectedGraph<Vertex> implements Graph<Vertex> {
   private final Digraph<Vertex> delegate;

    public UndirectedGraph() {
        delegate = new Digraph<>();
    }

    @Override
    public void addEdge(Vertex v, Vertex w) throws NoSuchVertexException {
        delegate.addEdge(v, w);
        delegate.addEdge(w, v);
    }

    @Override
    public void addVertex(Vertex v) throws VertexExistsException {
        delegate.addVertex(v);
    }

    @Override
    public Iterable<Vertex> adj(Vertex v) throws NoSuchVertexException {
        return delegate.adj(v);
    }

    public int indegree(Vertex v) throws NoSuchVertexException {
        return delegate.indegree(v);
    }
}
