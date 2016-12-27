package TextToNlpTrainingDataConvertor.tokenizing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Oliver on 12/10/2016.
 */
public class TokenizerImpl implements Tokenizer {

    public String removeBrackets(String token, char bracket1, char bracket2) {
        StringBuilder filteredSentence = new StringBuilder();
        char[] chars = token.toCharArray();
        boolean isNestedSequence = false;
        for (int i = 0; i < chars.length; i++) {
            if (bracket1 == chars[i]) {
                isNestedSequence = true;
            } else if (bracket2 == chars[i]) {
                isNestedSequence = false;
            } else if (bracket1 != chars[i] && !isNestedSequence) {
                filteredSentence.append(String.valueOf(chars[i]));
            }
        }
        return filteredSentence.toString();
    }

    public String removeDoubleQuotes(String string) {
        return string.replace("\"", "");
    }

    public String removeEmptyStrings(String string) {
        List<String> list = Arrays.asList(string.split("\\ "));
        final List<String> newList = new ArrayList<String>();
        StringBuilder newString = new StringBuilder();
        for (final String s : list) {
            if (!(s.equals(""))) {
                newList.add(s);
            }
        }

        for (int i = 0; i < newList.size(); i++) {
            newString.append(newList.get(i));
            if (i < newList.size() - 1) {
                newString.append(" ");
            }
        }
        return newString.toString();
    }

    public String removeCommaDotQuestExplMark(String sentence) {
        char[] charTmp;
        charTmp = sentence.toCharArray();
        final char[] charToken = new char[charTmp.length - 1];
        for (int i = 0; i < charTmp.length - 1; i++) {
            if(',' != charTmp[i] && '.' != charTmp[i] && '?' != charTmp[i] && '!' != charTmp[i])
            charToken[i] = charTmp[i];
        }
        final String filteredSentence = new String(charToken);
        return filteredSentence;
    }

}