package net.itsky.java.bigcollections;



import java.util.Collection;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.MatcherAssert.assertThat;



public abstract class ListTestBase  {
	
	protected abstract <T> List<T> createList();
	
	protected abstract <T> List<T> createList(int capacity);

	protected abstract <T> List<T> createList(Collection<T> master);
	
	@Test
	public void test_00010_createEmptyList() {
		List<String> list = this.<String>createList();
		assertThat(list, empty());
	}

}