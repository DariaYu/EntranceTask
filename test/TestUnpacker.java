import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestUnpacker {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"2[e1[2[ty]]]","etytyetyty"},
                {"a3[x2[bc]yz]4[kt]z", "axbcbcyzxbcbcyzxbcbcyzktktktktz"},
                {"2[f]","ff"},
                {"1[x]3[yz]","xyzyzyz"},
                {"a2[3[x]y2[eee]]h", "axxxyeeeeeexxxyeeeeeeh"},
                {"11[x]y","xxxxxxxxxxxy"}
        });
    }

    private Unpacker unpacker;
    private String strIn;
    private String strOut;

    public TestUnpacker(String strIn, String strOut) {
        this.strIn = strIn;
        this.strOut = strOut;
    }

    @Before
    public void initTests() {
        unpacker = new Unpacker();
    }

    @Test
    public void testUnpackString() {
        Assert.assertEquals(strOut, unpacker.unpackString(strIn));
    }
}
