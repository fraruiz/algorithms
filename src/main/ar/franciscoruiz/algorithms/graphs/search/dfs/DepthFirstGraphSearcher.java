package ar.franciscoruiz.algorithms.graphs.search.dfs;

import ar.franciscoruiz.algorithms.graphs.Graph;
import ar.franciscoruiz.algorithms.graphs.search.GraphSearcher;

import java.util.Random;
import java.util.function.Consumer;

public final class DepthFirstGraphSearcher implements GraphSearcher {
    private boolean[] visited;

    @Override
    public void search(Graph graph, Consumer<Integer> consumer) {
        this.search(graph, graph.random(), consumer);
    }

    @Override
    public void search(Graph graph, Integer source, Consumer<Integer> consumer) {
        ensureVertexesVisit(graph);

        visited[source] = true;
        consumer.accept(source);
        graph.neighbours(source).forEach(vertex -> visit(graph, consumer, visited, vertex));
    }

    private void ensureVertexesVisit(Graph graph) {
        if (visited == null) {
            visited = new boolean[graph.size()];
        }
    }

    private void visit(Graph graph, Consumer<Integer> consumer, boolean[] visited, Integer vertex) {
        if (!visited[vertex]) {
            search(graph, vertex, consumer);
        }
    }
}
