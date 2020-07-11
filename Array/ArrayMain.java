import java.util.Scanner;

public class ArrayMain extends ArrayOperations
{
	public static void main(String []as)
	{
		Scanner sc=new Scanner(System.in);
		ArrayOperations ao= new ArrayOperations();
		int ch;
		
		do
		{
			System.out.print("Enter the choice\n1.Create\n2.Insertion\n3.Deletion\n4.Traverse\n5.Search\n6.Exit\t");
			ch=sc.nextInt();
			switch (ch){
			case 1:
				ao.createArray();
				break;
			case 2:
				ao.insertionArray();
				break;
			case 3:
				ao.deletionArray();										break;
			case 4:
				ao.traverseArray();
				break;
			case 5:
				ao.searchArray();
				break;
			case 6:
				return;
				//break;
			default :
				System.out.println("Invalid Choice");
				break;		
			}
		}while(ch<6 && ch>0);
	}
}