import java.util.Objects;

public class Calc {
    private static String in;
    private static String out;

    public static void expression() {
        int[] numbers;

        Analyzer.setArithmeticExpression(getIn());

        if (Objects.equals(Analyzer.determineTheTypeOfNumbers((byte) 0), Analyzer.determineTheTypeOfNumbers((byte) 2))) {
            String typeOfNumbers = Analyzer.determineTheTypeOfNumbers((byte) 0);
//            System.out.println(typeOfNumbers);

            if (typeOfNumbers.equals("Roman"))
                Analyzer.convertToArabicNumbers();
            numbers = Analyzer.returnNumbers();
            if ((numbers[0] < 1 || numbers[0] > 10) || (numbers[1] < 1 || numbers[1] > 10)) {
                throw new IllegalArgumentException("Входные числа только в диапозоне от 1(I) до 10(X)");
            }

            switch (Analyzer.returnOperator()) {
                case "+" -> setOut(String.valueOf((Analyzer.returnNumbers()[0] + Analyzer.returnNumbers()[1])));
                case "-" -> setOut(String.valueOf((Analyzer.returnNumbers()[0] - Analyzer.returnNumbers()[1])));
                case "*" -> setOut(String.valueOf((Analyzer.returnNumbers()[0] * Analyzer.returnNumbers()[1])));
                case "/" -> setOut(String.valueOf((Analyzer.returnNumbers()[0] / Analyzer.returnNumbers()[1])));
                default -> throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

            if (typeOfNumbers.equals("Roman"))
                setOut(Analyzer.convertToRomanNumerals(Integer.parseInt(getOut())));
        } else throw new IllegalArgumentException("Используются одновременно разные системы счисления");
        String res = getOut();
        if (res != null) {
            System.out.println(res);
        } else return;

    }

    public static void setIn(String in) {
        Calc.in = in;
    }

    public static String getIn() {
        return in;
    }

    public static void setOut(String out) {
        Calc.out = out;
    }
    public static String getOut() {
        return out;
    }
}