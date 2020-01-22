package area;

import java.util.Scanner;

public class string {
	/**
	 * checks two string are equal or not
	 * 
	 * @param s1
	 * @param s2
	 * @return 1 if equal
	 * @return 0 if unequal
	 */
	public static void compareString(String s1, String s2) {
		if (s1.equals(s2)) {
			System.out.println("1");
			;
		} else {
			System.out.println("0");
		}
	}

	/**
	 * To reverse a string
	 * 
	 * @param reverse
	 * @return reverse
	 */
	public void reverseString(String reverse) {
		System.out.println("the reverse of string is\n" + reverse);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		string s = new string();
		for (int z = 1; z > 0; z++) {
			System.out.println("Enter 1 to compare two string \nEnter 2 to reverse a string \nEnter 3 to convert lowercase to uppercase\nEnter 4 to find max String\nEnter 5 to exit ");
			int choi = sc.nextInt();
			switch (choi) {
			case 1:
				System.out.println("enter the first string");
				String s1 = sc.next();
				System.out.println("enter the second string");
				String s2 = sc.next();
				s.compareString(s1, s2);
				break;
			case 2:
				String s3 = sc.next();
				String reverse = "";
				for (int i = s3.length() - 1; i >= 0; i--) {
					reverse = reverse + s3.charAt(i);
				}
				s.reverseString(reverse);
				break;

			case 3:
				System.out.println("Enter the string to be cheked");
				String s4 = sc.next();
				char[] s5 = s4.toCharArray();
				int ln = s4.length();
				int temp;
				for (int j = 0; j < ln; j++) {
					char c = s5[j];
					if (Character.isLowerCase(c)) {
						temp = (int) c;
						temp = temp - 32;
						s5[j] = (char) temp;
					} else {
						temp = (int) c;
						temp = temp + 32;
						s5[j] = (char) temp;

					}
				}
				String sk = "";
				for (int k = 0; k < ln; k++) {
					sk += s5[k];
				}
				System.out.println("the converted string is " + sk);
				break;
			case 4:
				System.out.println("enter the  string out of which you want to find the max word");
				sc.next();//waits for next input
				String str = sc.nextLine();
				String[] words = str.split(" ");
				int length = 0;
				for (String word : words) {
					if (length < word.length()) {
						length = word.length();
					}
				}
				System.out.println("The length of max word is" + length);
				break;
			case 5:
				z = -1;
				break;
			default:
				System.out.println("invalid choice");
			}
		}
	}

}
