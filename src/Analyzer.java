import java.util.Arrays;

public class Analyzer {
    public static final String[] romanNumerals = new String[]{"I","V","X"};

    private static String[] arithmeticExpression;

    public static void convertToArabicNumbers () {
        int numOne = RomanNumeral.romanToArabic(getArithmeticExpression()[0]);
        int numTwo = RomanNumeral.romanToArabic(getArithmeticExpression()[2]);

        String result = numOne+" "+returnOperator()+" "+numTwo;

        setArithmeticExpression(result);
    }
    public static String convertToRomanNumerals (int num) {
        return RomanNumeral.arabicToRoman(num);
    }//
    public static String determineTheTypeOfNumbers (byte index) {
        String s = String.valueOf(getArithmeticExpression()[index].charAt(0));
        if (Arrays.asList(romanNumerals).contains(s)) {
            return "Roman";
        } else return "Arabic";
    }
    public static String returnOperator () {
        return getArithmeticExpression()[1];
    }
    public static int[] returnNumbers () {
        return new int[]{
                Integer.parseInt(getArithmeticExpression()[0]),
                Integer.parseInt(getArithmeticExpression()[2])
        };
    }
    public static void setArithmeticExpression (String arithmeticExpression) {
        Analyzer.arithmeticExpression = arithmeticExpression.split(" ");
        if (getArithmeticExpression().length < 3) {
            throw new IllegalArgumentException("Строка не является математической операцией");
        } else if (getArithmeticExpression().length > 3) {
            throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
    public static String[] getArithmeticExpression () {
        return arithmeticExpression;
    }
}
