package area;
import java.util.Scanner;
public class marksheet {
public void Average(double total,int n){
	double avg=total/n;
	System.out.println("The average of all grades is"+avg);
}
public void maxgrade(int max){
	System.out.println("The max grade is"+max);
}
public void mingrade(int min){
	System.out.println("The min grade is"+min);
}
public void percentagepassstudent(int temp,int n){
	int pp=(temp/n*100);
	System.out.println("The percentage of pass students is"+pp);
}
public static void main (String args[]){
	System.out.println("enter the  no of students");
	Scanner sc=new Scanner(System.in);
	double total=0,grade;
	int max=0,grd,min=99999,temp=0,grad;
	 int n=sc.nextInt();
	 for(int i=0;i<n;i++){
		 System.out.println("enter the grades of student"+(i+1));
		 grade=sc.nextDouble();
		 grd=(int)grade;
		 grad=(int)grade;
		 max=Math.max(max, grd);
		 min=Math.min(min, grad);
		 if(grade>40){
			 temp++;
		 }
		 total+=grade;
	 }
	 marksheet m=new marksheet();
	 for(int z=1;z>0;z++){
			System.out.println("Enter 1 to get average of all grades \nEnter 2 to find max grade\nEnter 3 to minimum grade\nEnter 4 to get percentage of pass students\nEnter 5 to exit ");
			int choi=sc.nextInt();
			switch(choi){
			case 1:
				m.Average(total,n);
			break;
			case 2:
				m.maxgrade(max);
			break;
			case 3:
			    m.mingrade(min);
		    break;
			case 4:m.percentagepassstudent(temp,n);
			break;
			case 5:z=-1;
			break;
			default:
				System.out.println("Invalid Choice");
}
	 }
}
}