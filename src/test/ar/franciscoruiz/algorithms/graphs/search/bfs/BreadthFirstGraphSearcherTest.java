package ar.franciscoruiz.algorithms.graphs.search.bfs;

import ar.franciscoruiz.algorithms.graphs.AdjacencyMatrixGraph;
import ar.franciscoruiz.algorithms.graphs.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

final class BreadthFirstGraphSearcherTest {
	private BreadthFirstGraphSearcher searcher;

	@BeforeEach
	void setUp() {
		this.searcher = new BreadthFirstGraphSearcher();
	}

	@Test
	void it_should_search_all_vertexes() {
		Graph graph = buildGraph();

		List<Integer> expected = List.of(0, 1, 3, 4, 2, 5);
		List<Integer> actual = new ArrayList<>();
		searcher.search(graph, 0, actual::add);

		assertEquals(expected, actual);
	}

	@Test
	void it_should_search_all_vertex_with_source_random() {
		Graph graph = buildGraph();

		List<Integer> expected = List.of(0, 1, 3, 4, 2, 5);
		List<Integer> actual = new ArrayList<>();
		searcher.search(graph, actual::add);

		assertTrue(expected.contains(actual.get(0)));
	}

	private Graph buildGraph() {
		Graph graph = new AdjacencyMatrixGraph(6);

		graph.add(0, 1);
		graph.add(0, 3);
		graph.add(0, 4);
		graph.add(4, 5);
		graph.add(3, 5);
		graph.add(1, 2);
		graph.add(1, 0);
		graph.add(2, 1);
		graph.add(4, 1);
		graph.add(3, 1);
		graph.add(5, 4);
		graph.add(5, 3);

		return graph;
	}
}