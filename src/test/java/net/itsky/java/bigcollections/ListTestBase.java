package net.itsky.java.bigcollections;



import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.common.collect.ImmutableSortedSet;

import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.Matchers.not;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(NAME_ASCENDING)
public abstract class ListTestBase  {
	
	private static final String MAGIC_WORD = "MagicWord";

	protected abstract <T> List<T> createList();
	
	protected abstract <T> List<T> createList(int capacity);

	protected abstract <T> List<T> createList(Collection<T> master);
	
	@Test
	public void test_00100_createEmptyList() {
		List<String> list = this.<String>createList();
		// abstract test of emptyness
		assertThat(list, empty());
		// test with method isEmpty() (probably used by empty, but we want to make it explicit here)
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
	
	@Test
	public void test_00110_createEmptyListWithCapacity() {
		List<String> list = this.<String>createList(10);
		// abstract test of emptyness
		assertThat(list, empty());
		// test with method isEmpty() (probably used by empty, but we want to make it explicit here)
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
	
	@Test
	public void test_00120_createEmptyListAsCopy() {
		List<String> list = this.<String>createList((Collection<String>) ImmutableSortedSet.<String>of());
		// abstract test of emptyness
		assertThat(list, empty());
		// test with method isEmpty() (probably used by empty, but we want to make it explicit here)
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
	
	@Test
	public void test_00120_createSingletonListAsCopy() {
		List<String> list = this.<String>createList(ImmutableSortedSet.of(MAGIC_WORD));
		// abstract test of emptyness
		assertThat(list, not(empty()));
		// test with method isEmpty() (probably used by empty, but we want to make it explicit here)
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());
	}

}