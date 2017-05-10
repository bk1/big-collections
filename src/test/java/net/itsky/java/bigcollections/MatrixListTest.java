package net.itsky.java.bigcollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MatrixListTest extends ListTestBase {

	@Override
	protected <T> List<T> createList() {
		return new MatrixList<T>();
	}

	@Override
	protected <T> List<T> createList(int capacity) {
		return new MatrixList<T>(capacity);
	}

	@Override
	protected <T> List<T> createList(Collection<T> master) {
		return new MatrixList<T>(master);
	}

}
