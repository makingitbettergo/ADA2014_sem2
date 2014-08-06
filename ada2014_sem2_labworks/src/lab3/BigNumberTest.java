package lab3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BigNumberTest {

	private BigNumber bn;

	@Before
	public void setUp() throws Exception {
		bn = new BigNumber();
	}

	@After
	public void tearDown() throws Exception {
		bn = null;
	}

	@Test
	public void testAddWhenAddingPositiveNumber() {
		assertEquals("123", bn.add("100", "23"));
	}

}
