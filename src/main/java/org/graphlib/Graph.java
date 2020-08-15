package org.graphlib;

import org.graphlib.exception.NoSuchVertexException;
import org.graphlib.exception.VertexExistsException;

public interface Graph<Vertex> extends AdjacentProvider<Vertex> {

    /**
     * Adds vertex to the graph.
     *
     * @param v the vertex
     * @throws VertexExistsException if vertex already exists.
     */
    void addVertex(Vertex v) throws VertexExistsException;

    /**
     * Adds an edge from→from to this digraph.
     *
     * @param to the tail vertex
     * @param from the head vertex
     * @throws NoSuchVertexException if {@code from} or {@code from} is {@code null} or not in this graph.
     */
    void addEdge(Vertex from, Vertex to) throws NoSuchVertexException;

}
