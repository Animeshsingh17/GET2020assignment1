package area;
import java.util.Scanner;


class area {
	public void Areaoftriangle(double width,double height)
	{
		if(width>0&&height>0){
System.out.println("the area of triangle is"+ width*height*0.5);
}
		else{
	System.out.println("invalid input");
}
	}
	public void AreaofRectangle(double w,double h)
	{
		if(w>0&&h>0){
System.out.println("the area of triangle is"+ w*h);
}else{
	System.out.println("invalid input");
}
	}
	public void Areaofsquare(double s)
	{
		if(s>0){
System.out.println("the area of Square is"+ s*s);
}else{
	System.out.println("invalid input");
}
	}
	public void Areaofcircle(double r){
		if(r>0){
		System.out.println("The area of circle is"+3.14*r*r);}
		else{
			System.out.println("invalid input");
		}
	}
public static void main(String args[]){
	for(int i=1;i>0;i++){
		System.out.println("Enter 1 to get area of triangle\nEnter 2 to area of rectangle\nEnter 3 to get area of square\nEnter 4 to get area of circle \nEnter 5 to exit");
		Scanner sc = new Scanner(System.in);
		area a=new area();
		int choi=sc.nextInt();
		switch(choi){
		case 1:System.out.println("enter the width of triangle");
		double width=sc.nextDouble();
		System.out.println("enter the height of triangle");
		double height=sc.nextDouble();
			a.Areaoftriangle(width,height);
		break;
		case 2:System.out.println("enter the width of rectangle");
		double w=sc.nextDouble();
		System.out.println("enter the height of rectangle");
		double h=sc.nextDouble();
			a.AreaofRectangle(w,h);
		break;
		case 3:System.out.println("enter the  side of square");
		double s=sc.nextDouble();
			a.Areaofsquare(s);
	    break;
		case 4:System.out.println("enter the radius of circle");
		double r=sc.nextDouble();
			a.Areaofcircle(r);
		break;
		case 5:i=-1;
		break;
		default:
			System.out.println("Invalid Choice");
	}
}	 
	
}
}