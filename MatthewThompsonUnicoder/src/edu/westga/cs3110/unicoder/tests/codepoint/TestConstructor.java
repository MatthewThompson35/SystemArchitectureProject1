package edu.westga.cs3110.unicoder.tests.codepoint;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

public class TestConstructor {

	@Test
	public void testConstructor() {
		Codepoint codepoint = new Codepoint();
		assertEquals("0x1F682", codepoint.getCodepoint());
	}

}
