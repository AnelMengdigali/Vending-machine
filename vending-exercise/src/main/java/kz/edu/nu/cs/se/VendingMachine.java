package kz.edu.nu.cs.se;

/**
 * Context class for vending machine exercise
 *
 */
public class VendingMachine {
	
    public final State idle = new IdleState(this);
    public final State enteringCoins = new EnteringCoinsState(this);
    public final State paid = new PaidState(this);
    
    /**
     * Keep track of payments by user
     */
    int balance;
    
    private State currentState;
    
    /**
     * Make sure balance is zero and state is idle
     */
    public VendingMachine() {
    	
    	balance = 0;
    	setCurrentState( idle );
       
    }
    
    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState( State currentState ) {
        this.currentState = currentState;
    }
    
    public int getBalance() {
        return balance;
    }
    
    /**
     * Insert coin to vending machine.  Machine should only accept coins of value
     * 50 or 100.  Otherwise machine should raise 
     * an <code>IllegalArgumentException</code>.  Increment balance by
     * value of coin.  
     * 
     * If in <code>IdleState</code> then change to <code>EnteringCoinsState</code>.
     * If in <code>EnteringCoinsState</code> increment balance and if greater than 
     * or equal to 200 then change to <code>PaidState</code>.
     * 
     * If in <code>PaidState</code> then do not change state.  
     * 
     * @param coin
     */
    public void insertCoin( int coin ) {

    	if( ( coin == 50 ) || ( coin == 100 ) ) {
    		currentState.insertCoin( coin );
    	}
    		   		
    	else {
    		throw new IllegalArgumentException();
    	}
    	
    }
    
    /**
     * Refund entire balance and then set balance to zero and 
     * change state to <code>IdleState</code>.  
     * 
     * @return amount refunded
     */
    public int refund() { 
    	return currentState.refund(); 
    }
    
    /** 
     * If in <code>PaidState</code> then deduct 200 from balance and 
     * refund remainder.  Otherwise, raise an <code>IllegalStateException</code>.  
     * 
     * Return the amount refunded.  
     * 
     * @return amount refunded
     */
    public int vend() {

    	if( currentState == paid ) {    		
    		return currentState.vend();
    	}
    	
    	else {
    		throw new IllegalStateException();
    	}
    	
    }
    
    public State getIdleState() { 
    	return idle; 
    }
    public State getEnteringCoinsState() { 
    	return enteringCoins; 
    }
    public State getPaidState() { 
    	return paid; 
    }
    
}
