package kz.edu.nu.cs.se;

public class IdleState extends State {
	
	VendingMachine vendingMachine;

	public IdleState( VendingMachine vendingMachine ) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin( int coin ) {
		
		vendingMachine.balance = vendingMachine.getBalance() + coin;
		
		vendingMachine.setCurrentState( vendingMachine.getEnteringCoinsState() );

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
		return 0;
	}

}
