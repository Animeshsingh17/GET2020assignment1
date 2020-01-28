package com.metacube.animeshassignment7;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SymmetricTest {

	private int fInput[][];
	private int fInput2[][];
	private boolean fExpected;
	private int n;
	private int m;
	
	public SymmetricTest(int input[][],int input2[][],boolean expected,int n,int m){
		this.fInput=input;
		this.fInput2=input2;
		this.fExpected=expected;
		this.n=n;
		this.m=m;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{new int[][] { {1,2,3},{4,5,6},{7,8,9} },new int[][] {{}},false,3,3}
			});
	}

	@Test
	public void test() {
		Matrix matrix=new Matrix(fInput,fInput2);
		assertEquals(fExpected,matrix.Symmetric(n,m));
	}
	

}
