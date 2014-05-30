package edu.csupomona.cs.cs241.prog_assgmnt_sandbox;

public class RedBlackTree implements BinaryTree {
	
	public static enum Color {RED, BLACK};
	
	private Node root;
	private int elemCount = 0;
	private int numOfLeaves = 0;

	public void add(int key) {
		if(elemCount == 0) {
			root = new Node(key, Color.BLACK);
			root.left = new Node(-1, null, null, root, Color.BLACK);
			numOfLeaves++;
			root.right = new Node(-1, null, null, root, Color.BLACK);
			numOfLeaves++;
		}
		else if(lookup(key)) {
			System.out.println("Cannot accept duplicate values");
		}
		else {
			do {
				if(key <= root.key) {
					root = root.left;
				}
				else {
					root = root.right;
				}			
				
			} while (root.key != -1);
			root.key = key;
			root.color = Color.RED;
			root.left = new Node(-1, null, null, root, Color.BLACK);
			root.right = new Node(-1, null, null, root, Color.BLACK);
			numOfLeaves++;
			fixTree(root);
		}
		elemCount++;
		resetRoot();
		
	}

	private void resetRoot() {
		while(root.parent != null)
			root = root.parent;
	}

	private void fixTree(Node node) {
		
		if(node.parent == null) { // if we reached the root
			node.color = Color.BLACK;
		}
		
		else if(node.parent.color == Color.BLACK) { }
		
		else {
			
			Node uncle = uncle(node);
			
			// Case 1: Parent is red and Uncle is red
			if(node.parent.color == Color.RED && uncle.color == Color.RED) {
				node.parent.parent.left.color = Color.BLACK;
				node.parent.parent.right.color = Color.BLACK;	
				node.parent.parent.color = Color.RED;
				fixTree(node.parent.parent);					
			}
			
			// Case 2: Parent is red and Uncle is black
			else {
				
				// Uncle is left & node is right
				if(!isRightChild(uncle) && isRightChild(node)) {
					leftRotate(node.parent.parent);
					node.parent.color = Color.BLACK;
					node.parent.left.color = Color.RED;
				}
				
				// Uncle is left & node is left
				else if(!isRightChild(uncle) && !isRightChild(node)) {
					rightRotate(node.parent);
					fixTree(node.parent);
				}
				
				// Uncle is right & node is right
				else if(isRightChild(uncle) && isRightChild(node)) {
					leftRotate(node.parent);
					fixTree(node.parent);
				}
				
				// Uncle is right & node is left
				else if(isRightChild(uncle) && !isRightChild(node)) {
					rightRotate(node.parent.parent);
					node.parent.color = Color.BLACK;
					node.parent.right.color = Color.RED;
				}
				
				
			}
			
			
		}
		
	}
	
	private void leftRotate(Node x) {
		/*x.right.left.parent = x;
		x.right.left = x;
		x.right.parent = x.parent;
		x.parent = x.right;
		x.right = x.right.left;
		*/
		
		x.right = x.right.left;
		x.right.parent.left = x;
		x.right.parent.parent = x.parent;
		x.parent = x.right.parent;
		x.right.parent = x;
		
		if(x.parent.parent != null) {
			if(x.parent.key <= x.parent.parent.key) {
				x.parent.parent.left = x.parent;
			}
			else if(x.parent.key > x.parent.parent.key) {
				x.parent.parent.right = x.parent;
			}
		}
	}
	
	private void rightRotate(Node x) {
		x.left = x.left.right;
		x.left.parent.right = x;
		x.left.parent.parent = x.parent;
		x.parent = x.left.parent;
		x.left.parent = x;
		
		if(x.parent.parent != null) {
			if(x.parent.key <= x.parent.parent.key) {
				x.parent.parent.right = x.parent;
			}
			else if(x.parent.key > x.parent.parent.key) {
				x.parent.parent.left = x.parent;
			}
		}
	}

	private boolean isRightChild(Node node) {
		if(node.key > node.parent.key)
			return true;
		else 
			return false;
	}

	private Node uncle(Node node) {
		if(node.parent.key <= node.parent.parent.key)
			return node.parent.parent.right;
		else
			return node.parent.parent.left;
	}

	public int remove(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean lookup(int key) {
		
		// If the tree is empty, return false
		if(elemCount == 0) {
			return false;
		}
		
		// If the tree is not empty, traverse the tree
		else {
			resetRoot();
			do { 
				if(key == root.key) {
					resetRoot();
					return true;
				}
				else if(key < root.key) {
					root = root.left;
				}
				else {
					root = root.right;
				}
			} while(root.key != -1);

			resetRoot();
			return false;
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
