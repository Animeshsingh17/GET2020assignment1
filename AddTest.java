package com.metacube.animeshassignment7;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AddTest {

	private int fInput[][];
	private int fInput2[][];
	private int fExpected[][];
	private int n;
	private int m;
	
	public AddTest(int input[][],int input2[][],int expected[][],int n,int m){
		this.fInput=input;
		this.fInput2=input2;
		this.fExpected=expected;
		this.n=n;
		this.m=m;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[][] { {1,2,3},{4,5,6},{7,8,9} },new int[][] { {1,2,3},{4,5,6},{7,8,9} },new int[][] { {2,4,6},{8,10,12},{14,16,18} },3,3}
			});
	}

	@Test
	public void test() {
		Matrix matrix=new Matrix(fInput,fInput2);
		assertArrayEquals(fExpected,matrix.Add(n,m));
	}

	private void assertArrayEquals(int[][] fExpected2, int[][] add) {
		// TODO Auto-generated method stub
		
	}
	

}
