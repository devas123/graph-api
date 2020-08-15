package org.graphlib;

import org.graphlib.exception.NoSuchVertexException;
import org.graphlib.exception.VertexExistsException;

public interface Graph<Vertex> extends AdjacentProvider<Vertex> {
    void addVertex(Vertex v) throws VertexExistsException;

    void addEdge(Vertex from, Vertex to) throws NoSuchVertexException;

}
