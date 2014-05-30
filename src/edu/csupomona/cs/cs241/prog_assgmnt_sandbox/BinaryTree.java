package edu.csupomona.cs.cs241.prog_assgmnt_sandbox;

public interface BinaryTree {
	
	// adds a key/value to the tree
	public void add(int key);
	
	// removes the node associated with key and returns the value
	public int remove(int key);
	
	// returns the node associated with key
	public boolean lookup(int key);
	
	// returns the number of elements in the tree
	public int size();
	
}