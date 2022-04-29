package ar.franciscoruiz.algorithms.graphs.search;

import ar.franciscoruiz.algorithms.graphs.Graph;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface GraphSearcher {
    void search(Graph graph, Consumer<Integer> consumer);
    void search(Graph graph, Integer source, Consumer<Integer> consumer);
}
