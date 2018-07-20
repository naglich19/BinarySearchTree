import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Author: Eric Naglich
//Date: 4/24/15
//This program creates a Binary Search Tree that takes names and birth year from file, 
//finds age, and can search for a specific person's information.
//Name: Project 8

public class BSTMain {
	
	public static void main(String[] args) throws IOException {
			
		//input names and birth dates from file
		File file = new File("BSTInput.txt");
			Scanner sc = new Scanner(file);
			BST myTree = new BST();
			
			Scanner kb = new Scanner(System.in);
			File out = new File("BSTOutfile.txt");
			PrintWriter prw = new PrintWriter(out);
			
			String a;
			String b;
			String c;
			
			//separate and define names and dates
			while (sc.hasNext()) {
				a = sc.next();
				b = sc.next();
				c = sc.next();
				
				//input data into tree (lastname, firstname, date born)
				System.out.println(a + " " + b + " " + c);
				BSTNode t = new BSTNode(b, a, c);
				myTree.insert(t);
			}
			
			myTree.iprint(prw);
			System.out.println(" ");
			myTree.printinorder(null, prw);
	
			int choice = 999;
	
			while (choice != 0)	{
				choice = Menu();
	
				switch (choice) {
				case 1:					
					System.out.println("Enter last name for Search");
					String value = kb.nextLine();
						
					//send input name to search
					myTree.searching(value, prw);
					break;
	
				case 0:					
					System.out.println("Program Ended");
					break;
	
				default:					
					System.out.println("Error, Enter A Valid Choice");
					break;
					
				}
			}
			prw.close();
		}

	public static int Menu() {

		@SuppressWarnings("resource")
		Scanner user = new Scanner(System.in);
		int Val = 0;

		System.out.println(" Enter your choice");
		System.out.println(" 1) Search for a person");
		System.out.println(" 0) End program");
		
		Val = user.nextInt();
		return (Val);

	}

}
