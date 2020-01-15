package hexa;
import java.util.Scanner;
import java.io.*;
class hexconvert{
public static int hexconversion(String s) {
	String digits="0123456789ABCDEF";
	s.toUpperCase();
	int val=0;
	for(int i=0;i<s.length();i++){
		char c=s.charAt(i);
		int d=digits.indexOf(c);
		val=16*val+d;
	}
	return val;
}
    public static void Addno(){
    	try{
    		Scanner scan = new Scanner(System.in);
    		System.out.println("enter the first no");
    		String fhex=scan.nextLine();
    		fhex.toUpperCase();
    		System.out.println("enter the second no");
    		String shex=scan.nextLine();
    		shex.toUpperCase();
    	    Integer num1=Integer.parseInt(fhex,16);
    	    Integer num2=Integer.parseInt(shex,16);
    	    int sum=num1+num2;
    	    System.out.println("the sum of first"+num1+"and second no "+num2+"is"+sum);
    	    String ans =Integer.toHexString(sum);
    	    System.out.println("the sum is"+ans);
    	    scan.close();
    	}
    	catch(Exception e){                       
    		System.out.println(e.getMessage());   
    	}
    }
    	public static void multiplyno(){
        	try{
        		Scanner scan = new Scanner(System.in);
        		System.out.println("enter the first no");
        		String fhex=scan.nextLine();
        		fhex.toUpperCase();
        		System.out.println("enter the second no");
        		String shex=scan.nextLine();
        		shex.toUpperCase();
        	    Integer num1=Integer.parseInt(fhex,16);
        	    Integer num2=Integer.parseInt(shex,16);
        	    int multi=num1*num2;
        	    System.out.println("the sum of first"+num1+"and second no "+num2+"is"+multi);
        	    String ans =Integer.toHexString(multi);
        	    System.out.println("the sum is"+ans);
        	    scan.close();
        	}
        	catch(Exception e){                       
        		System.out.println(e.getMessage());   
        	}
    }
    	public static void divideno(){
        	try{
        		Scanner scan = new Scanner(System.in);
        		System.out.println("enter the first no");
        		String fhex=scan.nextLine();
        		fhex.toUpperCase();
        		System.out.println("enter the second no");
        		String shex=scan.nextLine();
        		shex.toUpperCase();
        	    Integer num1=Integer.parseInt(fhex,16);
        	    Integer num2=Integer.parseInt(shex,16);
        	    int divide=num1/num2;
        	    System.out.println("the sum of first"+num1+"and second no "+num2+"is"+divide);
        	    String ans =Integer.toHexString(divide);
        	    System.out.println("the sum is"+ans);
        	    scan.close();
        	}
        	catch(Exception e){                       
        		System.out.println(e.getMessage());   
        	}
        	
        }
    public static void main(String args[])throws IOException{
	String hexdecnum;
	int i=1,j,decnum;
	int binnum[]=new int[100];
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the hexadecimal no");
	hexdecnum=sc.nextLine();
	//hexa to decimal//
	decnum=hexconversion(hexdecnum);
	System.out.println("Converted decimal no is:");
	System.out.println(decnum);
	//decimal to binary//
	while(decnum!=0){
		binnum[i++]=decnum%2;
		decnum=decnum/2;	
		sc.close();
	}
	
	System.out.println("the converted binary no is");
	for(j=i-1;j>0;j--){
		System.out.print(binnum[j]);
	}
	for(int z=1;z>0;z++){
		System.out.println("Enter 1 to add a product\nEnter 2 to multiply\nEnter 3 to divide\nEnter 4 to exit ");
		int choi=sc.nextInt();
		switch(choi){
		case 1:Addno();
		break;
		case 2:multiplyno();
		break;
		case 3:divideno();
	    break;
		case 4:i=-1;
		break;
		default:
			System.out.println("Invalid Choice");
	}
	
}	
    }
}