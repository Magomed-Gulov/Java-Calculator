import java.util.Scanner;

public class Main {
//    private static String str;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the expression : "); Calc.setIn(in.nextLine());


            Calc.expression();
        }
    }
}