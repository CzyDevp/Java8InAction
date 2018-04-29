package pct;

public class BinaryTree {
	static TreeNodeBt root=null;
public static void main(String[] args) {
	System.out.println("Enter Tree Expression");
	root = new TreeNodeBt();
	root.left = null;
	root.right=null;
	
}
public static class TreeNodeBt
{
  	TreeNodeBt left,right;
  	String nodeContent ;
}
}

