package edu.csupomona.cs.cs241.prog_assgmnt_sandbox;

public class Node {
	
	public static enum Color {RED, BLACK};
	
	protected Integer key;
	protected Node parent;
	protected Node left;
	protected Node right;
	protected edu.csupomona.cs.cs241.prog_assgmnt_sandbox.RedBlackTree.Color color;

	public Node(int value, Node l, Node r, Node p, edu.csupomona.cs.cs241.prog_assgmnt_sandbox.RedBlackTree.Color c) {
		key = value;
		left = l;
		right = r;
		parent = p;
		color = c;
	}
	
	public Node(int v, edu.csupomona.cs.cs241.prog_assgmnt_sandbox.RedBlackTree.Color c) {
		key = v;
		left = null;
		right = null;
		parent = null;
		color = c;
	}
	

}
