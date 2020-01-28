package com.metacube.animeshassignment5;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NqueenTest {
	private int finput[][];
	private int frow;
	private int fdimension;
	private boolean fExpected;

	public NqueenTest(int input[][], int row, int dimension, boolean expected) {
		this.finput = input;
		this.frow = row;
		this.fdimension = dimension;
		this.fExpected = expected;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { {
				new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 } }, 0, 4, true } });
	}

	@Test
	public void test() {
		Nqueen nqueen = new Nqueen();
		assertEquals(fExpected, nqueen.nQueen(finput, frow, fdimension));
	}

}
