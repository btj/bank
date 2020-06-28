package bank;

import java.math.BigInteger;

/**
 * Each instance of this class represents a bank account.
 * 
 * @invar The balance is not null
 *     | getBalance() != null
 * @invar The owner association is consistent.
 *     | getOwner() != null && getOwner().getAccount() == this
 */
public class Account {
	
	/**
	 * @invar The balance is not null
	 *    | balance != null
	 * @invar The owner association is consistent.
	 *    | owner != null && owner.account == this
	 */
	BigInteger balance;
	/** @peerObject */
	BankClient owner;
	
	public BigInteger getBalance() { return this.balance; }
	
	/** @peerObject */
	public BankClient getOwner() { return owner; }

	/**
	 * Initializes this account with the given initial balance and owner.
	 * 
	 * @pre initialBalance is not null
	 *    | initialBalance != null
	 * @pre owner is not null
	 *    | owner != null
	 * @pre The owner does not yet own an account
	 *    | owner.getAccount() == null
	 * @mutates | this
	 * @mutates_properties | owner.getAccount()
	 * @post This account's initial balance equals the given initial balance.
	 *    | getBalance().equals(initialBalance)
	 * @post This account's owner equals the given bank client.
	 *    | getOwner() == owner
	 */
	public Account(BigInteger initialBalance, BankClient owner) {
		this.balance = initialBalance; 
		this.owner = owner;
		this.owner.account = this;
	}

	/**
	 * Transfers ownership of this account to the given bank client.
	 * 
	 * @pre otherOwner is not null
	 *    | otherOwner != null
	 * @pre otherOwner does not yet own an account
	 *    | otherOwner.getAccount() == null
	 * @mutates_properties | getOwner(), getOwner().getAccount(), otherOwner.getAccount()
	 * @post This account's owner equals the given client.
	 *    | getOwner() == otherOwner
	 * @post This account's old owner no longer owns an account.
	 *    | old(getOwner()).getAccount() == null
	 */
	public void transferOwnershipTo(BankClient otherOwner) {
		this.owner.account = null;
		this.owner = otherOwner;
		otherOwner.account = this;
	}
}
