package com.metacube.Animeshassignment3;

import java.util.Scanner;

public class marksheet{
	/**
	 * average of all grades
	 * 
	 * @param total
	 * @param n
	 * @return avg
	 */
	public void average(double total, int n) {
		double avg = total / n;
		System.out.println("The average of all grades is" + avg);
	}

	/**
	 * maximum of all grades
	 * 
	 * @param max
	 * @return max
	 */
	public void maxGrade(int max) {
		System.out.println("The max grade is" + max);
	}

	/**
	 * minimum of all grades
	 * 
	 * @param min
	 * @return min
	 */
	public void minGrade(int min) {
		System.out.println("The min grade is" + min);
	}

	/**
	 * percentage of pass students
	 * 
	 * @param temp
	 * @param n
	 * @return pp
	 */
	public void percentagePassStudent(double temp, int n) {
		double pp = (temp / n) * 100;
		System.out.println("The percentage of pass students is" + pp);
	}

	public static void main(String args[]) {
		System.out.println("enter the  no of students");
		Scanner sc = new Scanner(System.in);
		double total = 0, grade;
		int max = 0, grd, min = 99999, grad;
		double temp=0;
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("enter the grades of student" + (i + 1));
			grade = sc.nextDouble();
			grd = (int) grade;
			grad = (int) grade;
			max = Math.max(max, grd);
			min = Math.min(min, grad);
			if (grade >= 40) {
				temp++;
			}
			total += grade;
		}
		marksheet m = new marksheet();
		for (int z = 1; z > 0; z++) {
			System.out.println("Enter 1 to get average of all grades \nEnter 2 to find max grade\nEnter 3 to minimum grade\nEnter 4 to get percentage of pass students\nEnter 5 to exit ");
			int choi = sc.nextInt();
			switch (choi) {
			case 1:
				m.average(total, n);
				break;
			case 2:
				m.maxGrade(max);
				break;
			case 3:
				m.minGrade(min);
				break;
			case 4:
				m.percentagePassStudent(temp, n);
				break;
			case 5:
				z = -1;
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
