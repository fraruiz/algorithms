package org.example.katas;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class Graph<T> {
    private final Map<T, List<T>> values = new HashMap<>();

    public void addVertex(T vertex) {
        values.put(vertex, new LinkedList<>());
    }

    public void addEdge(T source, T destination, boolean bidirectional) {
        if (!values.containsKey(source)) {
            addVertex(source);
        }

        if (!values.containsKey(destination)) {
            addVertex(destination);
        }
      
        values.get(source).add(destination);

        if (bidirectional) {
            values.get(destination).add(source);
        }
    }

    public Integer vertices() {
        return values.keySet().size();
    }

    public Integer edges(Boolean bidirectional) {
        int count = 0;
        for (T v : values.keySet()) {
            count = count + values.get(v).size();
        }

        if (bidirectional) {
            count = count / 2;
        }

        return count;
    }

    public Boolean containsVertex(T s) {
        return values.containsKey(s);
    }

    public Boolean containsEdge(T s, T d) {
        return values.get(s).contains(d);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T vertex : values.keySet()) {
            builder.append(vertex.toString()).append(": ");

            for (T vertices : values.get(vertex)) {
                builder.append(vertices.toString()).append(" ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }
}
