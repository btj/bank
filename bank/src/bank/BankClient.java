package bank;

/**
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
	private String name;
	private BankAccount account;
	
	public String getName() { return this.name; }
	
	public BankAccount getAccount() { return this.account; }
	
	/**
	 * @throws IllegalArgumentException name is null
	 *     | name == null
	 */
	public BankClient(String name) {
		if (name == null)
			throw new IllegalArgumentException("name is null");
		this.name = name;
	}
	
	void setAccount(BankAccount account) {
		this.account = account;
	}

}
