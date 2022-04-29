package ar.franciscoruiz.algorithms.graphs;

import java.util.Objects;

public final class Node<T extends Comparable<?>> {
	private final T value;

	public Node(T value) {
		this.value = value;
	}

	public T value() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Node<?> node = (Node<?>) o;
		return Objects.equals(value, node.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "Vertex{" + "value=" + value + '}';
	}
}
