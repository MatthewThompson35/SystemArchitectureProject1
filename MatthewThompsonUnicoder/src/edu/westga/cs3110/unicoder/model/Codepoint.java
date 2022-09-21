package edu.westga.cs3110.unicoder.model;

/***
 * The Codepoint Class
 * 
 * @author mthomp35
 *
 */
public class Codepoint {
	private String codepoint;
	private String hexNotation = "0x";

	/***
	 * Constructor for the class Codepoint
	 *
	 * @param codepoint
	 */
	public Codepoint(String codepoint) {
		if (codepoint == null) {
			throw new NullPointerException("codepoint can not be null");
		}
		if (codepoint.equals("")) {
			throw new IllegalArgumentException("codepoint can not be empty");
		}
		this.codepoint = codepoint;
	}

	/***
	 * Converts this.codepoint to a UTF32 hex string
	 * 
	 * @return result the hex string
	 */
	public String toUTF32() {
		String result = this.hexNotation;
		result += ("00000000" + this.codepoint.substring(2)).substring(this.codepoint.substring(2).length());
		return result;
	}

	/***
	 * Converts this.codepoint to a UTF16 hex string
	 * 
	 * @return result the hex string
	 */
	public String toUTF16() {
		String result = "";
		String hex = this.codepoint.substring(2);
		int intValue = Integer.parseInt(hex, 16);
		if (intValue <= 0xFFFF) {
			result += this.hexNotation;
			result += ("0000" + hex).substring(hex.length());
		} else {
			intValue -= 0x10000;
			int high = (intValue >> 10) + 0xD800;
			int low = (intValue & 0x3FF) + 0xDC00;
			result += this.hexNotation
					+ ("0000" + Integer.toHexString(high)).substring(Integer.toHexString(high).length());
			result += " " + this.hexNotation
					+ ("0000" + Integer.toHexString(low)).substring(Integer.toHexString(low).length());
		}
		return result;
	}

	/***
	 * Converts this.codepoint to a UTF8 hex string
	 * 
	 * @return result the hex string
	 */
	public String toUTF8() {
		String result = "";
		String hex = this.codepoint.substring(2);
		int intValue = Integer.parseInt(hex, 16);
		int secondByte = 0xC0;
		int thirdByte = 0xE0;
		int fourthByte = 0xF0;
		int byteContinuation = 0x80;
		int mask = 0x3F;
		if (intValue <= 0x7F) {
			result += this.hexNotation + ("00" + hex).substring(hex.length());
		} else if (intValue <= 0x7FF) {
			result = this.toOneByteUTF8(result, intValue, secondByte, byteContinuation, mask);
		} else if (intValue <= 0xFFFF) {
			result = this.toThreeByteUTF8(result, intValue, thirdByte, byteContinuation, mask);
		} else {
			result = this.toFourByteUTF8(result, intValue, fourthByte, byteContinuation, mask);
		}
		return result;
	}

	/***
	 * Converts the intValue to Four Byte UTF8 hex string
	 * 
	 * @param result
	 * @param intValue
	 * @param fourthByte
	 * @param byteContinuation
	 * @param mask
	 * @return result the hex string
	 */
	private String toFourByteUTF8(String result, int intValue, int fourthByte, int byteContinuation, int mask) {
		int first = (intValue >> 18) + fourthByte;
		int second = ((intValue >> 12) & mask) + byteContinuation;
		int third = ((intValue >> 6) & mask) + byteContinuation;
		int fourth = (intValue & mask) + byteContinuation;
		result += this.hexNotation + ("00" + Integer.toHexString(first)).substring(Integer.toHexString(first).length());
		result += " " + this.hexNotation
				+ ("00" + Integer.toHexString(second)).substring(Integer.toHexString(second).length());
		result += " " + this.hexNotation
				+ ("00" + Integer.toHexString(third)).substring(Integer.toHexString(third).length());
		result += " " + this.hexNotation
				+ ("00" + Integer.toHexString(fourth)).substring(Integer.toHexString(fourth).length());
		return result;
	}

	/***
	 * Converts the intValue to Three Byte UTF8 hex string
	 * 
	 * @param result
	 * @param intValue
	 * @param thirdByte
	 * @param byteContinuation
	 * @param mask
	 * @return result the hex string
	 */
	private String toThreeByteUTF8(String result, int intValue, int thirdByte, int byteContinuation, int mask) {
		int first = (intValue >> 12) + thirdByte;
		int second = ((intValue >> 6) & mask) + byteContinuation;
		int third = (intValue & mask) + byteContinuation;
		result += this.hexNotation + ("00" + Integer.toHexString(first)).substring(Integer.toHexString(first).length());
		result += " " + this.hexNotation
				+ ("00" + Integer.toHexString(second)).substring(Integer.toHexString(second).length());
		result += " " + this.hexNotation
				+ ("00" + Integer.toHexString(third)).substring(Integer.toHexString(third).length());
		return result;
	}

	/***
	 * Converts the intValue to one byte UTF8 hex string
	 * 
	 * @param result
	 * @param intValue
	 * @param secondByte
	 * @param byteContinuation
	 * @param mask
	 * @return result the hex string
	 */
	private String toOneByteUTF8(String result, int intValue, int secondByte, int byteContinuation, int mask) {
		int first = (intValue >> 6) + secondByte;
		int second = (intValue & mask) + byteContinuation;
		result += this.hexNotation + ("00" + Integer.toHexString(first)).substring(Integer.toHexString(first).length());
		result += " " + this.hexNotation
				+ ("00" + Integer.toHexString(second)).substring(Integer.toHexString(second).length());
		return result;
	}

	public String getCodepoint() {
		return this.codepoint;
	}

}
