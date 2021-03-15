import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        for (String s : Arrays.asList("2[d3[ft2[e]l]p]k", "a3[x2[eb]yz]4[kt]z", "11[x]y","2[e1[2[ty]]]")) {
            System.out.println(new Unpacker().unpackString(s));
        }
    }
}


