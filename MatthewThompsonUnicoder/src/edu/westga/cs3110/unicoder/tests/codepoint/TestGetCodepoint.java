package edu.westga.cs3110.unicoder.tests.codepoint;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestGetCodepoint {

	@Test
	void testGetCodepoint() {
		Codepoint codepoint = new Codepoint("0x1F682");
		assertEquals("0x1F682", codepoint.getCodepoint());
	}

}
