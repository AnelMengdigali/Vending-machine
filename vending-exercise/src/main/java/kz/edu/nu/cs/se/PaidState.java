package kz.edu.nu.cs.se;

public class PaidState extends State {

	VendingMachine vendingMachine;
	
	public PaidState( VendingMachine vendingMachine ) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin( int coin ) {
		vendingMachine.balance = vendingMachine.getBalance() + coin;
	}

	@Override
	public int refund() {
		
		int refundedAmount = vendingMachine.getBalance();
		
		vendingMachine.balance = 0;
		vendingMachine.setCurrentState( vendingMachine.getIdleState() );
		
		return refundedAmount;
		
	}

	@Override
	public int vend() {
		
		vendingMachine.balance = vendingMachine.getBalance() - 200;
		vendingMachine.setCurrentState( vendingMachine.getIdleState() );
		
		return vendingMachine.balance;
	
	}

}
