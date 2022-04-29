package ar.franciscoruiz.algorithms.graphs.search.dfs;

import ar.franciscoruiz.algorithms.graphs.AdjacencyListGraph;
import ar.franciscoruiz.algorithms.graphs.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

final class DepthFirstGraphSearcherTest {
	private DepthFirstGraphSearcher searcher;

	@BeforeEach
	void setUp() {
		this.searcher = new DepthFirstGraphSearcher();
	}

	@Test
	void it_should_search_all_vertexes() {
		Graph graph = buildGraph();

		List<Integer> expected = List.of(0, 1, 2, 4, 3);
		List<Integer> actual = new ArrayList<>();
		searcher.search(graph, 0, actual::add);

		assertEquals(expected, actual);
	}

	@Test
	void it_should_search_all_vertex_with_source_random() {
		Graph graph = buildGraph();

		List<Integer> expected = List.of(0, 1, 2, 4, 3);
		List<Integer> actual = new ArrayList<>();
		searcher.search(graph, actual::add);

		assertTrue(expected.contains(actual.get(0)));
	}

	private Graph buildGraph() {
		Graph graph = new AdjacencyListGraph(4);

		graph.add(0, 1);
		graph.add(0, 2);
		graph.add(0, 3);
		graph.add(2, 4);

		return graph;
	}
}