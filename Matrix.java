package com.metacube.animeshassignment7;

public final class Matrix {

	final int[][] matrix1;
	final int[][] matrix2;
	
	/**
	 * Constructor initializing the input matrices
	 * @param input1 denotes 1st matrix
	 * @param input2 denotes 2nd matrix
	 */
	public Matrix(int[][] input1,int[][] input2)
	{
		this.matrix1=input1;
		this.matrix2=input2;
	}
	
	/**
	 * Returns the transpose matrix of the input matrix
	 * @param n denotes dimension of matrix
	 * @param m denotes dimension of matrix
	 * @return transpose matrix of the input matrix
	 */
	public int[][] Transpose(int n,int m)
	{
		int[][] resultant=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				resultant[i][j]=matrix1[j][i];
			}
		}
		
		return resultant;
	}
	
	/**
	 * Returns true if the input matrix is symmetric else false
	 * @param n denotes dimension of matrix
	 * @param m denotes dimension of matrix
	 * @return true if the input matrix is symmetric else false
	 */
	public boolean Symmetric(int n,int m)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(matrix1[i][j]!=matrix1[j][i])
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns addition matrix of the two input matrices
	 * @param n denotes dimension of matrix
	 * @param m denotes dimension of matrix
	 * @return addition matrix of the two input matrices
	 */
	public int[][] Add(int n,int m)
	{
		int sum[][]=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				sum[i][j]=matrix1[i][j]+matrix2[i][j];
			}
		}
		return sum;
	}
	
	/**
	 * Returns product matrix of the two input matrices
	 * @param n1 denotes dimension of  1st matrix
	 * @param m1 denotes dimension of 1st matrix
	 * @param n2 denotes dimension of 2nd matrix
	 * @param m2 denotes dimension of 2nd matrix
	 * @return product matrix of the two input matrices
	 */
	public int[][] Multiply(int n1,int m1,int n2,int m2)
	{
		int[][] resu=new int[n1][m1];
		for(int i=0;i<n1;i++)
		{
			for(int j=0;j<m1;j++)
			{
				resu[i][j]=0;
				for(int k=0;k<n1;k++)
				{
					resu[i][j]+=matrix1[i][k]*matrix2[k][j];
				}
			}
		}
		return resu;
	}
	
}
