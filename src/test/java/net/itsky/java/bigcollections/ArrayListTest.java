package net.itsky.java.bigcollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListTest extends ListTestBase {

	@Override
	protected <T> List<T> createList() {
		return new ArrayList<T>();
	}

	@Override
	protected <T> List<T> createList(int capacity) {
		return new ArrayList<T>(capacity);
	}

	@Override
	protected <T> List<T> createList(Collection<T> master) {
		return new ArrayList<T>(master);
	}

}
