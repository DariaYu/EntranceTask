import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unpacker {
    private Pattern pattern;
    private Pattern patternDig;
    private StringBuilder buildOutStr;
    private StringBuilder buildRepeatStr;

    public Unpacker() {
        pattern = Pattern.compile("[1-9]\\d*\\[[a-zA-Z]*\\]");
        patternDig = Pattern.compile("[1-9]\\d*");
        buildOutStr = new StringBuilder();
        buildRepeatStr = new StringBuilder();
    }

    //only for Valid input String
    public String unpackString(String strIn) {
        String strOut = strIn;
        while (true) {
            buildOutStr.setLength(0);
            buildRepeatStr.setLength(0);
            Matcher matcher = pattern.matcher(strOut);
            if (matcher.find()) {
                int n = getDigit(strOut.substring(matcher.start()));
                for (int i = 0; i < n; i++)
                    buildRepeatStr.append(strOut, matcher.start() + 1 + String.valueOf(n).length(), matcher.end() - 1);
                buildOutStr.append(strOut, 0, matcher.start()).append(buildRepeatStr).append(strOut, matcher.end(), strOut.length());
                strOut = buildOutStr.toString();
            } else
                break;
        }
        return strOut;
    }

    private Integer getDigit(String str) {
        Integer n = null;
        Matcher matcher = patternDig.matcher(str);
        if (matcher.find()) {
            try {
                n = Integer.valueOf(str.substring(matcher.start(), matcher.end()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return n;
    }


    //in developing..
//    public boolean isStringValid(String strIn) {
//        return false;
//    }
}
