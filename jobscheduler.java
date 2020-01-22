package com.metacube.Animeshassignment2;

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class jobscheduler {

	public void Sorter(int[][] process) {
		Arrays.sort(process, new Comparator<int[]>() {
			public int compare(final int[] entry1, final int[] entry2) {
				if (entry1[0] > entry2[0])
					return 1;
				else
					return -1;
			}
		});
	}

	public void completion(int[][] process, int number, int[] turnAroundTime,int[] completionTime) {
		for (int i = 0; i < number; i++) {
			completionTime[i] = turnAroundTime[i] + process[i][0];
		}
	}

	public void waiting(int[][] process, int[] waitingTime, int number) {
		waitingTime[0] = 0;
		for (int i = 1; i < number; i++) {
			waitingTime[i] = waitingTime[i - 1] + process[i - 1][1]+ process[i - 1][0];
			waitingTime[i] = waitingTime[i] - process[i][0];
		}
	}

	public void turnAround(int[][] process, int[] waitingTime, int number,
			int[] turnAroundTime) {
		for (int i = 0; i < number; i++) {
			turnAroundTime[i] = waitingTime[i] + process[i][1];
		}
	}

	public float avgwaitingTime(int[] waitingTime, int number) {
		float avg = 0;
		for (int i = 0; i < number; i++) {
			avg = avg + waitingTime[i];
		}
		avg = avg / number;
		return avg;
	}

	public int maxwaiting(int[] waitingTime, int number) {
		int maxi = waitingTime[0];
		for (int i = 1; i < number; i++) {
			if (waitingTime[i] > maxi)
				maxi = waitingTime[i];
		}

		return maxi;
	}

	public void display(int[] arr, int number) {
		for (int i = 0; i < number; i++) {
			System.out.println("For " + (i + 1) + "th process,it is " + arr[i]+ " units\n");
		}
		System.out.println();
	}

}

class Tester {
	public static void main(String args[]) throws IOException {
		jobscheduler job = new jobscheduler();
		System.out.println("Enter the number of processes that you want to give");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int number = Integer.parseInt(br.readLine());

			int[] waitingTime = new int[number];
			int[] turnAroundTime = new int[number];
			int[] completionTime = new int[number];
			int[][] process = new int[number][2];

			// so we take input from user of arrival time and burst time and we return values of turnaround time,completion time and waiting time
			for (int i = 0; i < number; i++) {
				System.out.println("Enter the arrival time of " + (i + 1)+ "th process");
				try {
					process[i][0] = Integer.parseInt(br.readLine());
				} catch (Exception e) {
					System.out.println("Invalid input");
					i = i - 1;
					continue;
				}
				System.out.println("Enter the burst time of " + (i + 1)
						+ "th process");
				try {
					process[i][1] = Integer.parseInt(br.readLine());
				} catch (Exception e) {
					System.out.println("Invalid input");
					i = i - 1;
					continue;
				}
			}
			job.Sorter(process);

			System.out.println("\n--waiting TIME--");
			job.waiting(process, waitingTime, number);
			job.display(waitingTime, number);

			System.out.println("--TURN AROUND TIME--");
			job.turnAround(process, waitingTime, number, turnAroundTime);
			job.display(turnAroundTime, number);

			System.out.println("--completion TIME--");
			job.completion(process, number, turnAroundTime, completionTime);
			job.display(completionTime, number);

			System.out.println("--AVG. waiting TIME--");
			float res = job.avgwaitingTime(waitingTime, number);
			System.out.println("The avg waiting time is: " + res + " units\n");

			System.out.println("--MAX. waiting TIME--");
			int res2 = job.maxwaiting(waitingTime, number);
			System.out.println("The max waiting time is: " + res2 + " units\n");
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
}
