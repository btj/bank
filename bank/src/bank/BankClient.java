package bank;

/**
 * Each instance of this class represents a client of the bank.
 * 
 * @invar The name is not null
 *     | getName() != null
 * @invar The account association is consistent.
 *     | getAccount() == null
 *     |   || getAccount().getOwner() == this
 */
public class BankClient {
	
	/**
	 * @invar The name is not null
	 *     | name != null
	 * @invar The account association is consistent.
	 *     | account == null || account.owner == this
	 */
	String name;
	/** @peerObject */
	Account account;
	
	public String getName() { return this.name; }
	
	/** @peerObject */
	public Account getAccount() { return this.account; }
	
	/**
	 * Initializes this bank client with the given name.
	 * 
	 * @throws IllegalArgumentException if name is null
	 *     | name == null
	 * @mutates | this
	 * @post This client's name equals the given name.
	 *     | getName().equals(name)
	 * @post This client does not yet own an account.
	 *     | getAccount() == null
	 */
	public BankClient(String name) {
		if (name == null)
			throw new IllegalArgumentException("name is null");
		this.name = name;
	}

}
