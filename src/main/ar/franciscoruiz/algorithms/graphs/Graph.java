package ar.franciscoruiz.algorithms.graphs;

public interface Graph<T> {
    void addVertex(T vertex);

    void addEdge(T source, T destination);

    void addEdge(T source, T destination, boolean bidirectional);

    Integer vertices();

    Integer edges(Boolean bidirectional);

    Boolean containsVertex(T s);

    Boolean containsEdge(T s, T d);

    String toString();
}
