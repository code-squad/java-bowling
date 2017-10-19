import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	Queue<Integer> test3;

	@Before
	public void setup() {
		test3 = new LinkedList<>();
	}

	@Test
	public void arrayDequeTest() {
		test3.add(2);
		test3.add(0);
		test3.add(3);
		assertEquals((Integer) 2, test3.poll());
		assertEquals(2, test3.size());
	}

}
