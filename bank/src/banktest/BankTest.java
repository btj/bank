package banktest;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import bank.Account;
import bank.BankClient;

class BankTest {

	@Test
	void test() {
		BankClient client1 = new BankClient("C. Lient1");
		Account account1 = new Account(BigInteger.valueOf(1000), client1);
		BankClient client2 = new BankClient("C. Lient2");
		account1.transferOwnershipTo(client2);
	}

}
