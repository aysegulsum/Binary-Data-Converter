public class FloatingPointNumber extends BinaryDataConverter {

	char sign = ' ';
	String exponent = "";
	String fraction = "";
	int bias;

	public FloatingPointNumber(String binaryString, int size) {

		this.sign = binaryString.charAt(0);
		switch (size) {
			case 1: // 1 byte
				this.exponent = binaryString.substring(1, 5);
				this.fraction = binaryString.substring(5);
				this.bias = 7;

				break;

			case 2: // 2 byte
				this.exponent = binaryString.substring(1, 7);
				this.fraction = binaryString.substring(7);
				this.bias = 31;

				break;

			case 3: // 3 byte
				this.exponent = binaryString.substring(1, 9);
				this.fraction = binaryString.substring(9);
				this.bias = 127;

				break;

			case 4: // 4 byte
				this.exponent = binaryString.substring(1, 11);
				this.fraction = roundedFraction(binaryString.substring(11));
				this.bias = 511;

				break;
		}

	}

	public String floatingPointNumber() {

		double decimalValue = 0;
		double signBit = this.sign - 48;
		double Exponent2 = 0;

		if (Integer.parseInt(UnsignedInteger.unsignedInteger(this.exponent)) == 0) {

			decimalValue = (double) (Math.pow(-1, signBit)) * Math.pow(2, 1 - this.bias) * mantissa();
			return decimalValue + "";

		} else if (SignedInteger.signedInteger(this.exponent).equals("-1")) {

			if (binaryToDecimal(this.fraction) == 0) {
				if (this.sign == '0')
					return "+infinity";
				else
					return "-infinity";
			} else {
				return "NaN";
			}
		} else {
			if (Integer.parseInt(UnsignedInteger.unsignedInteger(this.exponent)) - this.bias < 0) {
				Exponent2 = 1
						/ Math.pow(2, -(Integer.parseInt(UnsignedInteger.unsignedInteger(this.exponent))) - this.bias);
			} else {
				Exponent2 = Math.pow(2, (Integer.parseInt(UnsignedInteger.unsignedInteger(this.exponent)) - this.bias));
			}
			decimalValue = Math.pow(-1, signBit) * Exponent2 * mantissa();
		}
		return ((int) (decimalValue * 100000) / 100000.0) + "";
	}

	public double mantissa() {

		double sum = 0;
		for (int i = 0; i < this.fraction.length(); i++) {
			if (this.fraction.charAt(i) == '1') {
				double positionValue = 1.0 / Math.pow(2, i + 1.0);
				sum += positionValue;
			}
		}
		if (Integer.parseInt(UnsignedInteger.unsignedInteger(this.exponent)) == 0) {
			sum = sum + 0;
		} else if (Integer.parseInt(UnsignedInteger.unsignedInteger(this.exponent)) != -1) {
			sum++;
		}
		return sum;
	}

	public String roundedFraction(String fraction) {

		String rounded = fraction.substring(0, 13);
		String rounding = fraction.substring(13);

		int dec13 = binaryToDecimal(rounded);
		int dec8 = binaryToDecimal(rounding);

		if (dec8 == 128 && dec13 % 2 == 1)
			dec13 = dec13 + 1;

		else if (dec8 > 128)
			dec13 = dec13 + 1;

		rounded = decimalToBinary(dec13);
		if (rounded.length() < 13) {

			while (rounded.length() < 13) {
				rounded = '0' + rounded;

			}
		}

		return rounded;
	}
}
