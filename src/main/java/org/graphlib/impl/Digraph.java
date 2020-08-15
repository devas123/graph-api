package org.graphlib.impl;

import org.graphlib.Graph;
import org.graphlib.exception.NoSuchVertexException;
import org.graphlib.exception.VertexExistsException;

import java.util.*;

/**
 * Directed graph implementation
 *
 * @param <Vertex>
 */
public class Digraph<Vertex> implements Graph<Vertex> {
    private final Map<Vertex, List<Vertex>> adj;    // adj[v] = adjacency list for vertex v
    private final Map<Vertex, Integer> indegree;

    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Digraph() {
        adj = new HashMap<>();
        indegree = new HashMap<>();
    }


    /**
     * Initializes a new digraph that is a deep copy of the specified digraph.
     *
     * @param G the digraph to copy
     * @throws IllegalArgumentException if {@code G} is {@code null}
     */
    public Digraph(Digraph<Vertex> G) {
        if (G == null) throw new IllegalArgumentException("argument is null");


        // update adjacency lists
        adj = new HashMap<>();

        adj.putAll(G.adj);

        indegree = new HashMap<>();
        indegree.putAll(G.indegree);

        for (Map.Entry<Vertex, List<Vertex>> verticeListEntry : G.adj.entrySet()) {
            Stack<Vertex> reverse = new Stack<>();
            for (Vertex vertex : verticeListEntry.getValue()) {
                reverse.push(vertex);
            }
            ArrayList<Vertex> v = new ArrayList<>(reverse);
            adj.put(verticeListEntry.getKey(), v);
        }
    }

    private void validateVertex(Vertex v) throws NoSuchVertexException {
        if (v == null || !adj.containsKey(v))
            throw new NoSuchVertexException("Vertex " + v + " is not in the graph");
    }

    /**
     * Adds the directed edge v→w to this digraph.
     *
     * @param v the tail vertex
     * @param w the head vertex
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    @Override
    public void addEdge(Vertex v, Vertex w) throws NoSuchVertexException {
        validateVertex(v);
        validateVertex(w);
        adj.get(v).add(w);
        indegree.put(w, indegree.getOrDefault(w, 0) + 1);
    }

    protected int indegree(Vertex v) throws NoSuchVertexException {
        validateVertex(v);
        return indegree.getOrDefault(v, 0);
    }


    /**
     * Adds the directed edge v→w to this digraph.
     *
     * @param v the tail vertex
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    @Override
    public void addVertex(Vertex v) throws VertexExistsException {
        if (adj.putIfAbsent(v, new ArrayList<>()) == null) {
            indegree.put(v, 0);
        } else {
            throw new VertexExistsException("Vertex" + v + " already exists");
        }
    }

    /**
     * Returns the vertices adjacent from vertex {@code v} in this digraph.
     *
     * @param v the vertex
     * @return the vertices adjacent from vertex {@code v} in this digraph, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    @Override
    public Iterable<Vertex> adj(Vertex v) throws NoSuchVertexException {
        validateVertex(v);
        return Collections.unmodifiableList(adj.get(v));
    }
}

