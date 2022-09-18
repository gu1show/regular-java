import org.junit.Assert;
import org.junit.Test;

public class RegularProcessingTest {
    @Test
    public void testIsIpAddressCorrect1(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("127.0.0.1"));
    }

    @Test
    public void testIsIpAddressCorrect2(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("255.255.255.255"));
    }

    @Test
    public void testIsIpAddressCorrect3(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("0.0.0.0"));
    }

    @Test
    public void testIsIpAddressCorrect4(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("1.10.255.128"));
    }

    @Test
    public void testIsIpAddressCorrect5(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("20.0.5.1"));
    }

    @Test
    public void testIsIpAddressCorrect6(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("18.100.29.138"));
    }

    @Test
    public void testIsIpAddressIncorrect1(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress(" 18.100.29.138"));
    }

    @Test
    public void testIsIpAddressIncorrect2(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("18.100.29.138 "));
    }

    @Test
    public void testIsIpAddressIncorrect3(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("256.34.29.138"));
    }

    @Test
    public void testIsIpAddressIncorrect4(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("183..0.81"));
    }

    @Test
    public void testIsIpAddressIncorrect5(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("25 75 2 130"));
    }

    @Test
    public void testIsIpAddressIncorrect6(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("18..0.98.46"));
    }

    @Test
    public void testIsIpAddressIncorrect7(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("18.01.98.100"));
    }

    @Test
    public void testIsIpAddressIncorrect8(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("l8.1.98.100"));
    }

    @Test
    public void testIsIpAddressIncorrect9(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("-1.1.9.1"));
    }
}