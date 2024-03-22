public class UnsignedInteger extends BinaryDataConverter {

	public static String unsignedInteger(String binaryString) {

		int decimalValue = binaryToDecimal(binaryString);
		return decimalValue + "";
	}

}
