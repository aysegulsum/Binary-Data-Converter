public class deneme {

    public static void main(String[] args) {

        double decimalValue = 0;
        double sign = 0;
        double bias = -511;
        double signBit = sign - 48;
        double mantissa = 0.75;

        decimalValue = (double) (Math.pow(-1, signBit)) * Math.pow(2, 1 - bias) * mantissa;

        System.out.println(decimalValue);

        /*
         * double decimalValue = 0;
         * int signBit = Integer.parseInt("0");
         * double Exponent2 = 0;
         * double Exponent3 = 0;
         * double bias = 511;
         * double bias4 = -511;
         * if (Integer.parseInt(UnsignedInteger.unsignedInteger("0000000000")) == 0) {
         * if (1 - bias < 0) {
         * if (bias4 - 1 > Double.MIN_VALUE) {
         * double bias2 = Math.log(512) / Math.log(2) - 1;
         * Exponent2 = (double) Math.pow(2, (bias2 - 1));
         * System.out.println("Bura çalışıyor");
         * System.out.println(bias2);
         * System.out.println(Exponent2);
         * }
         * 
         * } else {
         *
         * double bias3 = Math.log(512) / Math.log(2) - 1;
         * Exponent3 = (double) Math.pow(2, (1 - bias3));
         * System.out.println("Bura çalışıyor2");
         * System.out.println(bias3);
         * System.out.println(Exponent3);
         * }
         * }
         * decimalValue = (double) Math.pow(-1, signBit) * 0.75;
         * if (1 - bias < 0) {
         * decimalValue *= Exponent2;
         * } else {
         * decimalValue *= Exponent3;
         * }
         * System.out.println(decimalValue);
         * }
         */

    }
}