package ar.franciscoruiz.algorithms.graphs;

import java.util.*;

public final class AdjacencyListGraph extends Graph {
	private final Map<Integer, Set<Integer>> values;

	public AdjacencyListGraph(Integer vertexQuantity) {
		this.values = new HashMap<>();

		for (int i = 0; i <= vertexQuantity; i++) {
			this.values.put(i, new HashSet<>());
		}
	}

	@Override
	public void add(Integer source, Integer destination){
		ensureVertexExists(source);
		ensureVertexExists(destination);
		ensureEdgeValid(source, destination);

		this.values.get(source).add(destination);
	}

	@Override
	public void delete(Integer source, Integer destination){
		ensureVertexExists(source);
		ensureVertexExists(destination);
		ensureEdgeValid(source, destination);

		this.values.get(source).remove(destination);
	}

	@Override
	public Boolean exists(Integer source, Integer destination){
		ensureVertexExists(source);
		ensureVertexExists(destination);
		ensureEdgeValid(source, destination);

		return this.values.get(source).contains(destination);
	}

	@Override
	public Set<Integer> neighbours(Integer vertex) {
		ensureVertexExists(vertex);

		return this.values.get(vertex);
	}

	@Override
	public Integer size() {
		return this.values.size();
	}
}
