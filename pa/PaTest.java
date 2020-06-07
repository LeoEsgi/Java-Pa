package pa;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaTest {


    @Test
    public void testCreateAccount() {

        Account A = new Account("jean", "petigros","Marseille", "France", Account.AccountType.CUSTOMER, true);

        assertEquals(A.getFirstname(), "jean");
        assertEquals(A.getLastname(), "petigros");
        assertEquals(A.getCity(), "Marseille");
        assertEquals(A.getCountry(), "France");
        assertEquals(A.getType(), Account.AccountType.CUSTOMER);
        assertEquals(A.isActivated(), true);

    }


}
