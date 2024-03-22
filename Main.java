//Sena Vatansever 150119755
//Mehmet Akgun 150119061
//Mustafa Emir Utku 150119707
//Ayse Gulsum Eren 150120005

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String hexadecimal = "";
		String binaryString = "";
		String decimalValue = "";
		ArrayList<String> list = new ArrayList<>();

		Scanner input = new Scanner(System.in);
		
		System.out.println("What is input file name ?");
		String inputFileName = input.nextLine();
		
		System.out.println("What is the byte ordering type?");
		String byteOrder = input.nextLine();

		System.out.println("What is the the data type to be converted?");
		String dataType = input.nextLine();

		System.out.println("What is the size of given data type?");
		int size = input.nextInt();

		try {
			File inputReader = new File(inputFileName);
			Scanner fileInput = new Scanner(inputReader);
			FileWriter fileOutput = new FileWriter("output.txt");

			while (fileInput.hasNext()) {

				System.out.println(fileInput);

				switch (size) {
					case 1:
						hexadecimal = fileInput.next();
						binaryString = BinaryDataConverter.hexadecimalToBinary(hexadecimal);

						if (dataType.equalsIgnoreCase("Signed Integer"))
							decimalValue = SignedInteger.signedInteger(binaryString);

						else if (dataType.equalsIgnoreCase("Unsigned Integer"))
							decimalValue = UnsignedInteger.unsignedInteger(binaryString);

						else if (dataType.equalsIgnoreCase("Floating Point")) {
							FloatingPointNumber fpn = new FloatingPointNumber(binaryString, size);
							decimalValue = fpn.floatingPointNumber();

						}
						break;

					case 2:
						hexadecimal = fileInput.next() + fileInput.next();
						hexadecimal = BinaryDataConverter.littleOrBig(hexadecimal, byteOrder, size);
						binaryString = BinaryDataConverter.hexadecimalToBinary(hexadecimal);

						BinaryDataConverter.littleOrBig(binaryString, byteOrder, size);
						if (dataType.equalsIgnoreCase("Signed Integer"))
							decimalValue = SignedInteger.signedInteger(binaryString);

						else if (dataType.equalsIgnoreCase("Unsigned Integer"))
							decimalValue = UnsignedInteger.unsignedInteger(binaryString);

						else if (dataType.equalsIgnoreCase("Floating Point")) {
							FloatingPointNumber fpn = new FloatingPointNumber(binaryString, size);
							decimalValue = fpn.floatingPointNumber();

						}
						break;

					case 3:
						hexadecimal = fileInput.next() + fileInput.next() + fileInput.next();
						hexadecimal = BinaryDataConverter.littleOrBig(hexadecimal, byteOrder, size);
						binaryString = BinaryDataConverter.hexadecimalToBinary(hexadecimal);

						BinaryDataConverter.littleOrBig(binaryString, byteOrder, size);
						if (dataType.equalsIgnoreCase("Signed Integer"))
							decimalValue = SignedInteger.signedInteger(binaryString);

						else if (dataType.equalsIgnoreCase("Unsigned Integer"))
							decimalValue = UnsignedInteger.unsignedInteger(binaryString);

						else if (dataType.equalsIgnoreCase("Floating Point")) {
							FloatingPointNumber fpn = new FloatingPointNumber(binaryString, size);
							decimalValue = fpn.floatingPointNumber();

						}
						break;

					case 4:
						hexadecimal = fileInput.next() + fileInput.next() + fileInput.next() + fileInput.next();
						hexadecimal = BinaryDataConverter.littleOrBig(hexadecimal, byteOrder, size);
						binaryString = BinaryDataConverter.hexadecimalToBinary(hexadecimal);

						BinaryDataConverter.littleOrBig(binaryString, byteOrder, size);
						if (dataType.equalsIgnoreCase("Signed integer"))
							decimalValue = SignedInteger.signedInteger(binaryString);

						else if (dataType.equalsIgnoreCase("Unsigned integer"))
							decimalValue = UnsignedInteger.unsignedInteger(binaryString);

						else if (dataType.equalsIgnoreCase("Floating Point")) {
							FloatingPointNumber fpn = new FloatingPointNumber(binaryString, size);
							decimalValue = fpn.floatingPointNumber();

						}
						break;

				}
				list.add(decimalValue);

			}
			for(int i=0; i< list.size();i++) {				
				
				if(i == list.size()/3 -1 || i == list.size()*2/3 -1) {
				fileOutput.write(list.get(i) + " ");
				fileOutput.write(System.lineSeparator());
				}
			   else 
				fileOutput.write(list.get(i) + " ");
			    }
			
            input.close();
			fileInput.close();
			fileOutput.close();

		} catch (FileNotFoundException e) {
			System.out.println("Not Fount...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Can't write on file");
			e.printStackTrace();
		}

	}

}
