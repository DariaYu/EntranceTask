import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestStrValid {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"a3[x2[bc]yz]4[kt]z", true},
                {"2[f]",true},
                {"1[x]3[yz]",true},
                {"a2[3[x]y2[eee]]h", true},
                {"11[x]y",true},
                {"2[3[4[gjgj]]]",true},
                {"2[3[4[gjgj]]]h2[3[4[gjgj]]]hj",true},
                {"dfgdfgdfg", true},
                {"",false},
                {"3f[xyz]4[xy]z",false},
                {"3[xy_z]4[xy]z",false},
                {"3[xy8z]4[xy]z",false},
                {"3[xyz]4[x1[]y]z",false},
                {"3[xyz]4[x]y]z",false},
                {"3[xyz]04[x]yz",false},
                {"[3[xyz]4[x]yz]",false},
                {"3[xyz]4[x]yz[fhfd5[hj]hdf]",false},

        });
    }

    private Unpacker unpacker;
    private String strIn;
    private boolean b;

    public TestStrValid(String strIn, boolean b) {
        this.strIn = strIn;
        this.b = b;
    }

    @Before
    public void initTests() {
        unpacker = new Unpacker();
    }

    @Test
    public void testUnpackString() {
        Assert.assertEquals(b, unpacker.isStringValid(strIn));
    }
}
