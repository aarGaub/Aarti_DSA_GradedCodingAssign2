package gca2.q2.mymnc.managetransactions;

import gca2.q2.mymnc.managetransactions.tnode.TransactionNode;

public class TransactionBSTtoSkewed {
	
	TransactionNode node;
	TransactionNode skewedHeadNode = null;     
	TransactionNode skewedLastNode = null;    
	
	/* method to get input transaction data BST */
	void getInputTransactionBSTData() 
	{
		node = new TransactionNode(50);
		node.left = new TransactionNode(30);
		node.right = new TransactionNode(60); 
		node.left.left = new TransactionNode(10); 
		node.right.left= new TransactionNode(55);
	}
	
	/* method to convert BST into right skewed tree which will be called recursively */
	 void transactionBSTtoRightSkewed(TransactionNode root) {
		
		if(root == null)
			return;

		transactionBSTtoRightSkewed(root.left);
		
		TransactionNode rightNodeBST = root.right;
		
		if(skewedHeadNode == null) 
		{
			skewedHeadNode = root;
			root.left = null;
			skewedLastNode = root;
		}
		else
		{
			skewedLastNode.right = root;
			root.left = null;
			skewedLastNode = root;
		}
		
		transactionBSTtoRightSkewed(rightNodeBST);
		
	}
	 
	/*method to display transaction data recursively from the right skewed tree in ascending order*/
	 void getOutputTransactionSkewedData(TransactionNode root)
	 {

		 if(root == null)
			 return;

		 System.out.print(root.getTransactionData() + " ");

		 getOutputTransactionSkewedData(root.right); 
	 }
	
	public static void main(String[] args) {
		
		/*	   BST          to           Right Skewed Tree  
        50                             10
       /  \                              \30
	 30   60                                \50                             
    /     /                                    \55		   
  10     55                                       \60         */ 
		
	TransactionBSTtoSkewed main = new TransactionBSTtoSkewed();
	main.getInputTransactionBSTData();
	main.transactionBSTtoRightSkewed(main.node);
	main.getOutputTransactionSkewedData(main.skewedHeadNode);
	
	}	
	

}
