import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        for (String s : Arrays.asList("3[xyz]4[xy]z", "2[3[x]y]", "a3[x2[eb]yz]4[kt]z", "11[x]y")) {
            System.out.println(new Unpacker().unpackString(s));
        }
    }
}


