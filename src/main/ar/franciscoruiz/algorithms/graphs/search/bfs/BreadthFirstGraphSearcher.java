package ar.franciscoruiz.algorithms.graphs.search.bfs;

import ar.franciscoruiz.algorithms.graphs.Graph;
import ar.franciscoruiz.algorithms.graphs.search.GraphSearcher;

import java.util.*;
import java.util.function.Consumer;

public final class BreadthFirstGraphSearcher implements GraphSearcher {
    @Override
    public void search(Graph graph, Consumer<Integer> consumer) {
        this.search(graph, graph.random(), consumer);
    }

    @Override
    public void search(Graph graph, Integer source, Consumer<Integer> consumer) {
        boolean[] visited = new boolean[graph.size()];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);

        while (!queue.isEmpty()) {
            Integer value = queue.poll();
            consumer.accept(value);
            visited[value] = true;

            Set<Integer> neighbours = graph.neighbours(value);
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour] && !queue.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }
    }
}
