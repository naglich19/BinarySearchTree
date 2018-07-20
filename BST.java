import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class BST {

	BSTNode root;

	public void insert(BSTNode t) {
		if (root == null)
			root = t;
		else 
			root = insert2(root, t);		
	}

	protected BSTNode insert2(BSTNode root, BSTNode newNode) {
			if (root == null) 
				root = newNode; 		
			else 			
				if ((root.lastName).compareTo(newNode.lastName) >= 1) 
					root.lTree = (insert2(root.lTree, newNode));			
				else 
					root.rTree = (insert2(root.rTree, newNode));
		return root;
	}

	public void searching(String lname, PrintWriter pw) {
		int count = 0;
		if (root == null)
			System.out.println("not found");
		else
			searchName(root, lname, count, pw);
	}

	private BSTNode searchName(BSTNode root, String name, int count, PrintWriter pw) {
	
			if (root == null) 
				System.out.println("Not found");
			
			else {
				if ((root.lastName).compareTo(name) == 0) {
					count++;
					System.out.println("Found " + root.toString() + " took " + count + " Comparisions");
					pw.println("Found " + root.toString() + " took " + count + " Comparisions");
				}
				if ((root.lastName).compareTo(name) > 0) {
					count++;
					root.lTree = (searchName(root.lTree, name, count, pw));
				}
				if ((root.lastName).compareTo(name) < 0) {
					count++;
					root.rTree = (searchName(root.rTree, name, count, pw));
				}
			}
			return root;
	}

	public void iprint(PrintWriter pw) throws IOException {
			
			if (root == null)
				System.out.println("Null");
				printinorder(root, pw);
	
	}

	public void printinorder(BSTNode t, PrintWriter pw) throws IOException {

		if (t != null) {
			printinorder(t.lTree, pw);
			System.out.println(t);
			pw.println(t);
			printinorder(t.rTree, pw);
		}

	}

}
