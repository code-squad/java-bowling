package bowling;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class OptionalTest {
	
	private Optional<String> hi;
	
	@Before
	public void setUp() {
		this.hi = Optional.ofNullable("hi Link");
	}
	
	@Test
	public void 옵셔널하이() {
		assertTrue(this.hi.isPresent());
		
	}

}
