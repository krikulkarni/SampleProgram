import java.util.Scanner;

public class ArrayOperations
{
	Scanner sc1=new Scanner(System.in);
	int []arr;
	int size;
	static int count=0;
	
	public void createArray()
	{
		System.out.println("Enter the Size the Array");
		size=sc1.nextInt();
		arr=new int[size];
	}

	public void traverseArray()
	{
		if(count<0)
		{
			System.out.println("Array is Empty");
			return;
		}
		else
		{
			System.out.println("Elements in Array are ");
			for(int i=0;i<count;i++)
				System.out.print(arr[i]+" ");
		}
	}

	public void insertionArray()
	{
		System.out.println("Enter the element to be inserted");
		int ele=sc1.nextInt();
		
		if(count > size)
		{
			System.out.println("Array is Full!!!!");
			return;
		}
		else
		{
			arr[count]=ele;
			count++;		
		}	
	}

	public void deletionArray()
	{
		if(count<0)
		{
			System.out.println("Array is Empty!!");
			return ;
		}
		else
		{
			int x=arr[count-1];
			count--;
			System.out.println("The Deleted Element is " + x);
		}
	}
	
	public void searchArray()
	{
		System.out.println("Enter the element you want to find out");
		int searchElement=sc1.nextInt();
		if(count<0)
			System.out.println("Array is Empty!!!");
		
		for(int i=0;i<count;i++)
		{
			if(arr[i]==searchElement)
				System.out.println("Element "+ searchElement + " found on index" + i);
			else
				System.out.println("Element not found");
		}
	}
}















