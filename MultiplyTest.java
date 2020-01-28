package com.metacube.animeshassignment7;


import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MultiplyTest {

	private int fInput[][];
	private int fInput2[][];
	private int fExpected[][];
	private int n1;
	private int m1;
	private int n2;
	private int m2;
	
	public MultiplyTest(int input[][],int input2[][],int expected[][],int n1,int m1,int n2,int m2){
		this.fInput=input;
		this.fInput2=input2;
		this.fExpected=expected;
		this.n1=n1;
		this.m1=m1;
		this.n2=n2;
		this.m2=m2;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[][] { {1,2},{3,4} },new int[][] { {1,1},{1,1} },new int[][] { {3,3},{7,7} },2,2,2,2}
			});
	}

	@Test
	public void test() {
		Matrix matrix=new Matrix(fInput,fInput2);
		assertArrayEquals(fExpected,matrix.Multiply(n1,m1,n2,m2));
	}

	private void assertArrayEquals(int[][] fExpected2, int[][] multiply) {
		// TODO Auto-generated method stub
		
	}
	

	
}
