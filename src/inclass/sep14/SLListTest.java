package inclass.sep14;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SLListTest {

	SLList<Integer> ls;

	@BeforeEach
	void init() { ls = new SLList<>(); }

	@Test
	void testAddFirst() {
		ls.addFirst(2);
		ls.addFirst(1);

		assertEquals((Integer) 1, ls.get(0));
		assertEquals(2, ls.size());
	}

	@Test
	void testAddLast() {
		ls.addLast(1);
		ls.addLast(2);

		assertEquals((Integer) 2, ls.get(1));
		assertEquals(2, ls.size());
	}

	@Test
	void testRemoveFirst() {
		ls.addFirst(1);
		ls.addFirst(2);
		ls.removeFirst();

		assertEquals((Integer) 1, ls.get(0));
		assertEquals(1, ls.size());
	}

	@Test
	void testRemoveLast() {
		ls.addFirst(1);
		ls.addFirst(2);
		ls.removeLast();

		assertEquals((Integer) 2, ls.get(0));
		assertEquals(1, ls.size());
	}

	@Test
	void testAdd() {
		ls.addFirst(4);
		ls.addFirst(3);
		ls.addFirst(1);
		ls.add(1, 2);
		assertEquals((Integer) 2, ls.get(1));
		assertEquals(4, ls.size());
	}

	@Test
	void testRemove() {
		ls.addFirst(3);
		ls.addFirst(2);
		ls.addFirst(1);
		ls.remove(1);

		assertEquals((Integer) 3, ls.get(1));
		assertEquals(2, ls.size());
	}

	@Test
	void testSet() {
		ls.addFirst(2);
		ls.addFirst(1);
		ls.set(1, 3);

		assertEquals((Integer) 3, ls.get(1));
	}

	@Test
	void testIndexOf() {
		ls.addFirst(3);
		ls.addFirst(2);
		ls.addFirst(1);

		assertEquals(1, ls.indexOf(2));
	}

	@Test
	void testRemoveEmpty() {
		assertEquals(false, ls.remove(0));
		assertThrows(NoSuchElementException.class, () -> { ls.removeFirst(); });
	}

	@Test
	void testIterable() {
		ls.addFirst(3);
		ls.addFirst(2);
		ls.addFirst(1);

		int count = 0;
		for (int x : ls)
			count++;
		assertEquals(ls.size(), count);
	}
}
