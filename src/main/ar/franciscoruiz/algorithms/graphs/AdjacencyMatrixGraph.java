package ar.franciscoruiz.algorithms.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class AdjacencyMatrixGraph extends Graph {
	private final boolean[][] values;

	public AdjacencyMatrixGraph(Integer vertexQuantity) {
		this.values = new boolean[vertexQuantity][vertexQuantity];
	}

	@Override
	public void add(Integer source, Integer destination){
		ensureVertexExists(source);
		ensureVertexExists(destination);
		ensureEdgeValid(source, destination);

		this.values[source][destination] = true;
		this.values[destination][source] = true;
	}

	@Override
	public void delete(Integer source, Integer destination){
		ensureVertexExists(source);
		ensureVertexExists(destination);
		ensureEdgeValid(source, destination);

		this.values[source][destination] = false;
		this.values[destination][source] = false;
	}

	@Override
	public Boolean exists(Integer source, Integer destination){
		ensureVertexExists(source);
		ensureVertexExists(destination);
		ensureEdgeValid(source, destination);

		return this.values[source][destination] && this.values[destination][source];
	}

	@Override
	public Set<Integer> neighbours(Integer vertex) {
		ensureVertexExists(vertex);

		Set<Integer> values = new HashSet<>();
		for(int source = 0; source < this.size(); ++source) {
			if(source != vertex && this.exists(vertex, source)) {
				values.add(source);
			}
		}

		return values;
	}

	@Override
	public Integer size() {
		return this.values.length;
	}
}
