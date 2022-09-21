package edu.westga.cs3110.unicoder.tests.codepoint;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

public class TestConstructor {

	@Test
	public void testConstructor() {
		Codepoint codepoint = new Codepoint("0x1F682");
		assertEquals("0x1F682", codepoint.getCodepoint());
	}

	@Test(expected = NullPointerException.class)
	public void testNullArgument() {
		Codepoint codepoint = new Codepoint(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyNetworkNullArgument() {
		Codepoint codepoint = new Codepoint("");
	}

}
