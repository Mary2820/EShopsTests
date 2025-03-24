package com.solvd.ebay;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CryptoTest implements IAbstractTest {

    @Test
    public void testPlaceholdersWithEncryptionTestData() {
        assertEquals(R.TESTDATA.get("test_credentials"), "test@gmail.com/EncryptMe");
    }

    @Test
    public void testEncryption() {
        assertEquals(R.CONFIG.get("password"), "EncryptMe");
    }

    @Test
    public void testPlaceholdersWithEncryption() {
        assertEquals(R.CONFIG.get("credentials"), "test@gmail.com/EncryptMe");
    }

}
