public class SignedInteger extends BinaryDataConverter {

	public static String signedInteger(String binaryString) {

		int decimalValue;
		if (binaryString.charAt(0) == '0')
			decimalValue = binaryToDecimal(binaryString);

		else
			decimalValue = binaryToDecimal(twosComplemet(binaryString)) * -1;

		return decimalValue + "";
	}
}
