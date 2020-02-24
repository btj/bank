package bank;

import java.math.BigInteger;

/**
 * @invar The balance is not null
 *     | getBalance != null
 * @invar The owner association is consistent.
 *     | getOwner() != null && getOwner().getAccount() == this
 */
public class BankAccount {
	
	/**
	 * @invar The balance is not null
	 *    | balance != null
	 * @invar The owner association is consistent.
	 *    | owner != null && owner.account == this
	 */
	private BigInteger balance;
	private BankClient owner;
	
	public BigInteger getBalance() { return this.balance; }
	
	public BankClient getOwner() { return owner; }

	/**
	 * @pre initialBalance is not null
	 *    | initialBalance != null
	 * @pre owner is not null
	 *    | owner != null
	 * @pre The owner does not yet own an account
	 *    | owner.getAccount() == null
	 */
	public BankAccount(BigInteger initialBalance, BankClient owner) {
		this.balance = initialBalance; 
		this.owner = owner;
		this.owner.setAccount(this);
	}

	/**
	 * @pre otherOwner is not null
	 *    | otherOwner != null
	 * @pre otherOwner does not yet own an account
	 *    | otherOwner.getAccount() == null
	 */
	public void setOwner(BankClient otherOwner) {
		this.owner.setAccount(null);
		this.owner = otherOwner;
		otherOwner.setAccount(this);
	}
}
