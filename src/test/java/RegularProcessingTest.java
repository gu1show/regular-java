import org.junit.Assert;
import org.junit.Test;

public class RegularProcessingTest {
    @Test
    public void testBroadcastAddress(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("255.255.255.255"));
    }

    @Test
    public void testNonRoutableMetaAddress(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("0.0.0.0"));
    }

    @Test
    public void testLocalHost(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("127.0.0.1"));
    }

    @Test
    public void testUsualIpCorrect1(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("1.10.255.128"));
    }

    @Test
    public void testUsualIpCorrect2(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("20.0.5.1"));
    }

    @Test
    public void testUsualIpCorrect3(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isIpAddress("18.100.29.138"));
    }

    @Test
    public void testWithExtraSpaceBefore(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress(" 18.100.29.138"));
    }

    @Test
    public void testWithExtraSpaceAfter(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("18.100.29.138 "));
    }

    @Test
    public void testNonExistingIpAddress(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("256.34.29.138"));
    }

    @Test
    public void testWithEmptyByte(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("183..0.81"));
    }

    @Test
    public void testWithoutDots(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("25 75 2 130"));
    }

    @Test
    public void testWithExtraDots(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("18..0.98.46"));
    }

    @Test
    public void testNonSignificantZero(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("18.01.98.100"));
    }

    @Test
    public void testWithLetter(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("l8.1.98.100"));
    }

    @Test
    public void testWithNegativeByte(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isIpAddress("-1.1.9.1"));
    }

    @Test
    public void testCorrectGuid(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isGuid("e0e0a4da-b0D1-def9-cae1-afec91BAedEF"));
    }

    @Test
    public void testGuidWithSquareBrackets(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isGuid("[e0e0a4da-b0D1-def9-cae1-afec91BAedEF]"));
    }

    @Test
    public void testGuidWithRoundBrackets(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isGuid("(e0e0a4da-b0D1-def9-cae1-afec91BAedEF)"));
    }

    @Test
    public void testGuidWithCurlyBrackets(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isGuid("{e0e0a4da-b0D1-def9-cae1-afec91BAedEF}"));
    }

    @Test
    public void testGuidOnlyZeros(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isGuid("00000000-0000-0000-0000-000000000000"));
    }

    @Test
    public void testGuidOnlyF(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isGuid("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testGuidWithExtraSpaceBefore(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isGuid(" FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testGuidWithExtraSpaceAfter(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isGuid("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF "));
    }

    @Test
    public void testGuidWithExtraSpaceInside(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isGuid("FFFFFFFF -FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testGuidWithWrongSymbolInTheFirstByte(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isGuid("gFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testGuidWithExtraSymbolInTheSecondByte(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isGuid("FFFFFFF-FFFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testGuidWithWrongSeparator(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isGuid("FFFFFFF+FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testGuidWithDoubleSeparator(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isGuid("FFFFFFF--FFFF-FFFF-FFFF-FFFFFFFFFFFF"));
    }

    @Test
    public void testUrlWithSubfolder(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isValidUrl("https://tproger.ru/articles/java-regex-ispolzovanie-reguljarnyh-vyrazhenij-na-praktike/"));
    }

    @Test
    public void testUrlWithSubdomain(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isValidUrl("https://blog.example.ru/"));
    }

    @Test
    public void testUrlWithOnlyWww(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isValidUrl("www.google.com"));
    }

    @Test
    public void testUrlWithOnlyHttp(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isValidUrl("http://google.com"));
    }

    @Test
    public void testUrlWithOnlyHttpS(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isValidUrl("https://google.com"));
    }

    @Test
    public void testUrlWithoutHttpSAndWww(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isValidUrl("google.com"));
    }

    @Test
    public void testGetRequest(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertTrue(executor.isValidUrl("/test/demo_form.php?name1=value1&name2=value2"));
    }

    @Test
    public void testUrlLikeIp(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isValidUrl("192.168.1.1"));
    }

    @Test
    public void testUrlWithDomainLess2(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isValidUrl("a.b"));
    }

    @Test
    public void testUrlWithExtraSlashAfterHttps(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isValidUrl("https:///ab.b"));
    }

    @Test
    public void testUrlWithDashBeforeDomain(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isValidUrl("www.-a.b"));
    }

    @Test
    public void testUrlWithDashAfterDomain(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isValidUrl("www.a-.b"));
    }

    @Test
    public void testWrongUrl(){
        RegularProcessing executor = new RegularProcessing();
        Assert.assertFalse(executor.isValidUrl("www.-"));
    }
}