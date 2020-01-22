package fcfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public interface Calculator {

	public String Add(String first, String second);

	public String Sub(String first, String second);

	public String Mul(String first, String second);

	public String Div(String first, String second);

	public boolean Equal(String first, String second);

	public boolean LessThan(String first, String second);

	public boolean GreaterThan(String first, String second);

}

class HexCalc implements Calculator {
	public String Add(String first, String second) {
		if ((HexadecimalToDecimal(first) != -1)&& (HexadecimalToDecimal(second) != -1)) {
			int sum = HexadecimalToDecimal(first)
					+ HexadecimalToDecimal(second);
			String sum1 = DecimalToHexadecimal(sum);
			return sum1;
		} else {
			System.out.println("Invalid");
			return "Invalid";
		}
	}

	public String Sub(String first, String second) {
		if ((HexadecimalToDecimal(first) != -1)&& (HexadecimalToDecimal(second) != -1)) {
			int diff= HexadecimalToDecimal(first)- HexadecimalToDecimal(second);
			String diff1 = DecimalToHexadecimal(diff);
			return diff1;
		} else {
			System.out.println("Invalid");
			return "Invalid";
		}
	}

	public String Mul(String first, String second) {
		if ((HexadecimalToDecimal(first) != -1)
				&& (HexadecimalToDecimal(second) != -1)) {
			int product = HexadecimalToDecimal(first)* HexadecimalToDecimal(second);
			String product1 = DecimalToHexadecimal(product);
			return product1;
		} else {
			System.out.println("Invalid");
			return "Invalid";
		}
	}

	public String Div(String first, String second) {
		if (HexadecimalToDecimal(second) == 0) {
			System.out.println("Cannot be divided by zero");
			return "Invalid";
		}
		if ((HexadecimalToDecimal(first) != -1)
				&& (HexadecimalToDecimal(second) != -1)) {
			int quotient = HexadecimalToDecimal(first)/ HexadecimalToDecimal(second);
			String quotient1 = DecimalToHexadecimal(quotient);
			return quotient1;
		} else {
			System.out.println("Invalid");
			return "Invalid";
		}
	}

	public boolean Equal(String first, String second) {
		int result = first.compareTo(second);
		if (result == 0)
			return true;
		else
			return false;
	}

	public boolean LessThan(String first, String second) {
		int result = first.compareTo(second);
		if (result < 0)
			return true;
		else
			return false;
	}

	public boolean GreaterThan(String first, String second) {
		int result = first.compareTo(second);
		if (result > 0)
			return true;
		else
			return false;
	}

	private int HexadecimalToDecimal(String first) {
		int digit = 0, intValue = 0;
		int length = first.length();
		char[] firstNumber = first.toCharArray();

		for (int i = (length - 1), p = 0; i >= 0; i--, p++) {
			if (firstNumber[i] >= '0' && firstNumber[i] <= '9') {
				digit = firstNumber[i] - 0x30;
			} else if ((firstNumber[i] >= 'A' && firstNumber[i] <= 'F')|| (firstNumber[i] >= 'a' && firstNumber[i] <= 'f')) {
				switch (firstNumber[i]) {
				case 'A':
				case 'a':
					digit = 10;
					break;
				case 'B':
				case 'b':
					digit = 11;
					break;

				case 'C':
				case 'c':
					digit = 12;
					break;

				case 'D':
				case 'd':
					digit = 13;
					break;

				case 'E':
				case 'e':
					digit = 14;
					break;

				case 'F':
				case 'f':
					digit = 15;
					break;

				}
			} else {
				System.out.println("Invalid");
				return -1;
			}
			intValue += digit * Math.pow(16, p);
		}
		return intValue;
	}

	private String DecimalToHexadecimal(int n) {
		if (n == 0)
			return "0";
		String hexadecimalNum = "";
		while (n != 0) {
			int temp = 0;
			temp = n % 16;
			if (temp < 10) {
				hexadecimalNum += (char) (temp + 48);
			} else {
				hexadecimalNum += (char) (temp + 55);
			}
			n = n / 16;
		}

		String hex = "";
		char[] hexadecimalNumArray = hexadecimalNum.toCharArray();
		for (int k = hexadecimalNumArray.length - 1; k >= 0; k--) {
			hex = hex + hexadecimalNumArray[k];
		}
		return hex;
	}

	public int HexaToDeciHelper(String first) {
		int deci = HexadecimalToDecimal(first);
		return deci;
	}

	public String DeciToHexaHelper(int n) {
		String hexa = DecimalToHexadecimal(n);
		return hexa;
	}

	public boolean isHex(String first) {
		try {
			Long.parseLong(first, 16);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}

class Test {
	public static void main(String args[]) throws IOException {
		int choice, num, result;
		String first, second, result2;
		HexCalc op = new HexCalc();
		System.out.println("\t\t\t\t\t\t\t\tWELCOME TO HEXCALCULATOR\n");

		for (int i = 1; i > 0; i++) {
			System.out.println("Enter 1 to perform addition,2 for subtraction,3 for multiplication,4 for division,5 for equals,6 for less than,7 for greater than,8 for dec rep,9 for hex rep,10 to stop");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:
					System.out.println("Enter 1st hexadecimal no.");
					first = br.readLine();
					if (op.isHex(first) == false) {
						System.out.println("INVALID STRING");
						continue;
					}
					System.out.println("Enter 2nd hexadecimal no.");
					second = br.readLine();
					if (op.isHex(second) == false) {
						System.out.println("INVALID STRING");
						continue;
					}
					try {
						String resultSum = op.Add(first, second);
						int resultant = resultSum.compareTo("Invalid");
						if (resultant != 0)
							System.out.println("The sum is : " + resultSum);
					} catch (Exception e) {
						System.out.println("INVALID");
					}
					break;

				case 2:
					System.out.println("Enter 1st hexadecimal no.");
					first = br.readLine();
					if (op.isHex(first) == false) {
						System.out.println("INVALID STRING");
						continue;
					}
					System.out.println("Enter 2nd hexadecimal no.");
					second = br.readLine();
					if (op.isHex(second) == false) {
						System.out.println("INVALID STRING");
						continue;
					}
					try {
						String resultDiff = op.Sub(first, second);
						int resultant = resultDiff.compareTo("Invalid");
						if ((resultant != 0)
								&& op.LessThan(first, second) == false)
							System.out.println("The difference is : "+ resultDiff);
						else
							System.out.println("Not Valid");
					} catch (Exception e) {
						System.out.println("INVALID");
					}
					break;

				case 3:
					System.out.println("Enter 1st hexadecimal no.");
					first = br.readLine();
					if (op.isHex(first) == false) {
						System.out.println("INVALID STRING");
						continue;
					}
					System.out.println("Enter 2nd hexadecimal no.");
					second = br.readLine();
					if (op.isHex(second) == false) {
						System.out.println("INVALID STRING");
						continue;
					}
					try {
						String resultMul = op.Mul(first, second);
						int resultant = resultMul.compareTo("Invalid");
						if (resultant != 0)
							System.out.println("The product is : " + resultMul);
					} catch (Exception e) {
						System.out.println("INVALID");
					}
					break;

				case 4:
					System.out.println("Enter 1st hexadecimal no.");
					first = br.readLine();
					if (op.isHex(first) == false) {
						System.out.println("INVALID STRING");
						continue;
					}
					System.out.println("Enter 2nd hexadecimal no.");
					second = br.readLine();
					if (op.isHex(second) == false) {
						System.out.println("INVALID STRING");
						continue;
					}
					try {
						String resultDiv = op.Div(first, second);
						int resultant = resultDiv.compareTo("Invalid");
						if (resultant != 0)
							System.out.println("The quotient is : " + resultDiv);
					} catch (Exception e) {
						System.out.println("INVALID");
					}
					break;

				case 5:
					System.out.println("Enter 1st hexadecimal no.");
					first = br.readLine();
					if (op.isHex(first) == false) {
						System.out.println("INVALID STRING");
						continue;
					}
					System.out.println("Enter 2nd hexadecimal no.");
					second = br.readLine();
					if (op.isHex(second) == false) {
						System.out.println("INVALID STRING");
						continue;
					}

					boolean value = op.Equal(first, second);
					if (value == true)
						System.out.println("The two numbers are equal");
					else
						System.out.println("The two numbers are not equal");
					break;

				case 6:
					System.out.println("Enter 1st hexadecimal no.");
					first = br.readLine();
					if (op.isHex(first) == false) {
						System.out.println("INVALID STRING");
						continue;
					}
					System.out.println("Enter 2nd hexadecimal no.");
					second = br.readLine();
					if (op.isHex(second) == false) {
						System.out.println("INVALID STRING");
						continue;
					}

					boolean re = op.LessThan(first, second);
					if (re == true)
						System.out.println(first + " is less than " + second);
					else
						System.out.println(first + " is not less than "+ second);
					break;

				case 7:
					System.out.println("Enter 1st hexadecimal no.");
					first = br.readLine();
					if (op.isHex(first) == false) {
						System.out.println("INVALID STRING");
						continue;
					}
					System.out.println("Enter 2nd hexadecimal no.");
					second = br.readLine();
					if (op.isHex(second) == false) {
						System.out.println("INVALID STRING");
						continue;
					}

					boolean re2 = op.GreaterThan(first, second);
					if (re2 == true)
						System.out.println(first + " is greater than " + second);
					else
						System.out.println(first + " is not greater than "+ second);
					break;

				case 8:
					System.out.println("Enter the hexadecimal number ");
					try {
						first = br.readLine();
						result = op.HexaToDeciHelper(first);
						if (result != -1)
					    System.out.println("The decimal conversion of "+ first + " is:" + result + "\n");
					} catch (Exception e) {
						System.out.println("INVALID");
					}
					break;

				case 9:
					System.out.println("Enter the decimal number ");
					try {
						num = Integer.parseInt(br.readLine());
						if (num < 0) {
							System.out.println("Number cannot be negative");
							continue;
						}
						result2 = op.DeciToHexaHelper(num);
						int resultant = result2.compareTo("Invalid");
						if (resultant != 0)
							System.out.println("The hexadecimal conversion of "+ num + " is:" + result2 + "\n");
					} catch (Exception e) {
						System.out.println("INVALID NUMBER");
					}
					break;

				case 10:
					i = -1;
					break;

				default:
					System.out.println("INVALID CHOICE");

				}
			} catch (Exception e) {
				System.out.println("Invalid input");
			}
		}
	}
}