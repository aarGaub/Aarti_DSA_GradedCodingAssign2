package gca2.q2.mymnc.managetransactions.tnode;

 public class TransactionNode {

	
	private int transactionData;
	
	public TransactionNode left;
	public TransactionNode right;
	
	public TransactionNode(int tData){
		 
		transactionData = tData;
		left = right = null;
		
	}
	
	public int getTransactionData() {
		return transactionData;
	}
	public void setTransactionData(int transactionData) {
		this.transactionData = transactionData;
	}

}
