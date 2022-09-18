package edu.westga.cs3110.unicoder.tests.codepoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF32 {

	@Test
	public void testConstructor() {
		Codepoint codepoint = new Codepoint();
		assertTrue("0x0001F682".equalsIgnoreCase(codepoint.toUTF32()));
	}

}
