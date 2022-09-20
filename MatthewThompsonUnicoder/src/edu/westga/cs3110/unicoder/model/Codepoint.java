package edu.westga.cs3110.unicoder.model;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Stack;

public class Codepoint {
	String codepoint;

	public Codepoint(String codepoint) {
		if (codepoint == null) {
			throw new NullPointerException("codepoint can not be null");
		}
		if (codepoint == "") {
			throw new IllegalArgumentException("codepoint can not be empty");
		}
		this.codepoint = codepoint;
	}

	public String toUTF32() {
		String result = "0x";
		result += ("00000000" + this.codepoint.substring(2)).substring(this.codepoint.substring(2).length());
		return result;
	}

	public String toUTF16() {
		String result = "";
		String hex = this.codepoint.substring(2);
		int intValue = Integer.parseInt(hex, 16);
		if (intValue <= 0xFFFF) {
			result += "0x";
			result += ("0000" + hex).substring(hex.length());
		} else {
			intValue -= 0x10000;
			int high = (intValue >> 10) + 0xD800;
			int low = (intValue & 0x3FF) + 0xDC00;
			result += "0x" + ("0000" + Integer.toHexString(high)).substring(Integer.toHexString(high).length());
			result += " 0x" + ("0000" + Integer.toHexString(low)).substring(Integer.toHexString(low).length());
		}
		System.out.println(result);
		return result;
	}

	public String toUTF8() {
		String result = "";
		String hex = this.codepoint.substring(2);
		int hexInt = Integer.parseInt(hex, 16);
		int secondByte = 11000000;
		int thirdByte = 11100000;
		int fourthByte = 11110000;
		int byteContinuation = 10000000;
		int mask = 00111111;
		if (hexInt <= 0x7F) {
			result += "0x" + ("00" + hex).substring(hex.length());
		} else if (hexInt <= 0x7FF) {
			int first = (hexInt >> 6) + secondByte;
			int second = (hexInt & mask) + byteContinuation;
			result += "0x" + ("00" + Integer.toHexString(first)).substring(Integer.toHexString(first).length());
			result += " 0x" + ("00" + Integer.toHexString(second)).substring(Integer.toHexString(second).length());
		} else if (hexInt <= 0xFFFF) {
			int first = (hexInt >> 12) + thirdByte;
			int second = ((hexInt >> 6) & mask) + byteContinuation;
			int third = (hexInt & mask) + byteContinuation;
			result += "0x" + ("00" + Integer.toHexString(first)).substring(Integer.toHexString(first).length());
			result += " 0x" + ("00" + Integer.toHexString(second)).substring(Integer.toHexString(second).length());
			result += " 0x" + ("00" + Integer.toHexString(third)).substring(Integer.toHexString(third).length());
		} else {
			int first = (hexInt >> 18) + fourthByte;
			int second = ((hexInt >> 12) & mask) + byteContinuation;
			int third = ((hexInt >> 6) & mask) + byteContinuation;
			int fourth = (hexInt & mask) + byteContinuation;
			result += "0x" + ("00" + Integer.toHexString(first)).substring(Integer.toHexString(first).length());
			result += " 0x" + ("00" + Integer.toHexString(second)).substring(Integer.toHexString(second).length());
			result += " 0x" + ("00" + Integer.toHexString(third)).substring(Integer.toHexString(third).length());
			result += " 0x" + ("00" + Integer.toHexString(fourth)).substring(Integer.toHexString(fourth).length());
		}
		return result;
	}

	public String getCodepoint() {
		return this.codepoint;
	}

}
