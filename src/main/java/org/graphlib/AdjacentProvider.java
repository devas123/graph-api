package org.graphlib;

import org.graphlib.exception.NoSuchVertexException;

import java.util.List;

public interface AdjacentProvider<Vertex> {

    /**
     * Returns the vertices adjacent from vertex {@code from} in this digraph.
     *
     * @param from the vertex
     * @return the vertices adjacent from vertex {@code from} in this digraph, as an iterable
     * @throws NoSuchVertexException if {@code v} is {@code null} or not part of the graph.
     */
    List<Vertex> adj(Vertex from) throws NoSuchVertexException;
}
