package org.graphlib;

import org.graphlib.exception.NoSuchVertexException;

public interface AdjacentProvider<Vertex> {
    Iterable<Vertex> adj(Vertex from) throws NoSuchVertexException;
}
