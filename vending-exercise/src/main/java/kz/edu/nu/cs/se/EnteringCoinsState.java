package kz.edu.nu.cs.se;

public class EnteringCoinsState extends State {
	
	VendingMachine vendingMachine;

	public EnteringCoinsState( VendingMachine vendingMachine ) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin( int coin ) {
	
		vendingMachine.balance = vendingMachine.getBalance() + coin;
		
		if( vendingMachine.balance >= 200 ) {
			vendingMachine.setCurrentState( vendingMachine.getPaidState() );
		}	

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
