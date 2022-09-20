package edu.westga.cs3110.unicoder.tests.codepoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

import org.junit.jupiter.api.Test;

class TestToUTF16 {

	@Test
	public void testUTF16MaxValue() {
		Codepoint codepoint = new Codepoint("0x10FFFF");
		assertTrue("0xDBFF 0xDFFF".equalsIgnoreCase(codepoint.toUTF16()));
	}

	@Test
	public void testUTF16LowerBound0() {
		Codepoint codepoint = new Codepoint("0x0");
		assertTrue("0x0000".equalsIgnoreCase(codepoint.toUTF16()));
	}

	@Test
	public void testUTF16UpperBoundD7FF() {
		Codepoint codepoint = new Codepoint("0xD7FF");
		assertTrue("0xD7FF".equalsIgnoreCase(codepoint.toUTF16()));
	}
	
	@Test
	public void testUTF16LowerBound10000() {
		Codepoint codepoint = new Codepoint("0x10000");
		assertTrue("0xD800 0xDC00".equalsIgnoreCase(codepoint.toUTF16()));
	}
	
	
	@Test
	public void testUTF16UpperBoundE000() {
		Codepoint codepoint = new Codepoint("0xE000");
		assertTrue("0xE000".equalsIgnoreCase(codepoint.toUTF16()));
	}

	@Test
	public void testUTF16RandomValue() {
		Codepoint codepoint = new Codepoint("0x1F682");
		assertTrue("0xD83D 0xDE82".equalsIgnoreCase(codepoint.toUTF16()));
	}

}
