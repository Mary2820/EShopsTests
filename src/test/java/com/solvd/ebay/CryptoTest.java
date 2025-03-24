package com.solvd.ebay;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CryptoTest implements IAbstractTest {

    @Test
    public void testPlaceholdersWithEncryptionTestData() {
        assertEquals(R.TESTDATA.getDecrypted("test_credentials"), "test@gmail.com/MySecretPassword123");
    }

    @Test
    public void testEncryption() {
        assertEquals(R.CONFIG.getDecrypted("password"), "MySecretPassword123");
    }

    @Test
    public void testPlaceholdersWithEncryption() {
        assertEquals(R.CONFIG.getDecrypted("credentials"), "test@gmail.com/MySecretPassword123");
    }

}
