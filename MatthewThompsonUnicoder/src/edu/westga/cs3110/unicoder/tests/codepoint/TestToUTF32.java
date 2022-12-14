package edu.westga.cs3110.unicoder.tests.codepoint;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF32 {

	@Test
	public void testUTF32Normal() throws UnsupportedEncodingException {
		Codepoint codepoint = new Codepoint("0x1F682");
		assertTrue("0x0001F682".equalsIgnoreCase(codepoint.toUTF32()));
	}

	@Test
	public void testUTF32Small() throws UnsupportedEncodingException {
		Codepoint codepoint = new Codepoint("0x1");
		assertTrue("0x00000001".equalsIgnoreCase(codepoint.toUTF32()));
	}

}
