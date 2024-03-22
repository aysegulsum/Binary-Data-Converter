public class BinaryDataConverter {

	public static int binaryToDecimal(String binaryString) {
		int decimal = 0;
		int power = 0;
		for (int i = binaryString.length() - 1; i >= 0; i--) {
			int bit = binaryString.charAt(i) - '0';
			decimal += bit * Math.pow(2, power);
			power++;
		}

		return decimal;
	}

	public static String decimalToBinary(int decimal) {

		String binary = "";
		while (decimal != 0) {

			if (decimal % 2 == 1) {
				binary = "1" + binary;
			} else {
				binary = "0" + binary;
			}

			decimal = decimal / 2;

		}
		return binary;
	}

	public static String twosComplemet(String binaryString) {

		String temp = "";
		String nev = "";

		for (int i = binaryString.length() - 1; i >= 0; i--) {
			if (binaryString.charAt(i) == '1') {
				temp = binaryString.substring(i);
				nev = binaryString.substring(0, i);
				break;
			}
		}

		for (int i = nev.length() - 1; i >= 0; i--) {
			if (nev.charAt(i) == '1')
				temp = '0' + temp;
			else
				temp = '1' + temp;

		}
		return temp;
	}

	public static String hexadecimalToBinary(String hexadecimal) {
		String binary = "";
		String[] hexadecimalArray = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001",
				"1010", "1011", "1100", "1101", "1110", "1111" };
		for (int i = 0; i < hexadecimal.length(); i++) {
			char a = hexadecimal.charAt(i);

			if (a >= '0' && a <= '9') {
				int value = a - '0';
				binary += hexadecimalArray[value];
			} else if (a == 'a') {
				int value = 10;
				binary = binary.concat(hexadecimalArray[value]);
			} else if (a == 'b') {
				int value = 11;
				binary = binary.concat(hexadecimalArray[value]);
			} else if (a == 'c') {
				int value = 12;
				binary = binary.concat(hexadecimalArray[value]);
			} else if (a == 'd') {
				int value = 13;
				binary = binary.concat(hexadecimalArray[value]);
			} else if (a == 'e') {
				int value = 14;
				binary = binary.concat(hexadecimalArray[value]);
			} else if (a == 'f') {
				int value = 15;
				binary = binary + (hexadecimalArray[value]);
			}
		}
		return binary;
	}

	public static String binaryToHexadecimal(String binary) {
		String hexadecimal = "";
		String[] hexadecimalArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		
		while (binary.length() % 4 != 0) {
			binary = "0" + binary;
		}
		for (int i = 0; i < binary.length(); i += 4) {
			String group = binary.substring(i, i + 4);
			int value = Integer.parseInt(group, 2);
			hexadecimal += hexadecimalArray[value];
		}
		return hexadecimal;
	}

	public static String littleOrBig(String st, String byteOrder, int size) {
		if (byteOrder.equalsIgnoreCase("Little Endian")) {
			if (size == 1)
				return st;
			else if (size == 2)
				return st = st.substring(2) + st.substring(0, 2);
			else if (size == 3)
				return st = st.substring(4) + st.substring(2, 4) + st.substring(0, 2);
			else
				return st = st.substring(6) + st.substring(4, 6) + st.substring(2, 4) + st.substring(0, 2);
		} else
			return st;
	}
}
