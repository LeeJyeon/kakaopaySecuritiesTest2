import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("insert input");
        String input = sc.next();

        while (input.contains("[") == true) {
            String repeat = "";
            String saveRepeat = "";
            int sPoint = 0;
            int ePoint = 0;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) <= '9' && input.charAt(i) >= '0') {
                    repeat += input.charAt(i);
                } else if (input.charAt(i) == '[' || input.charAt(i) == ']') {
                    if (!repeat.equals("")) {
                        saveRepeat = repeat;
                    }
                } else {
                    repeat = "";
                }

                if (input.charAt(i) == '[') {
                    sPoint = i;
                } else if (input.charAt(i) == ']') {
                    ePoint = i;
                    break;
                }
            }

            String midInput = "";
            if (repeat.equals("")) {
                repeat = saveRepeat;
            }

            for (int r = 0; r < Integer.parseInt(repeat); r++) {
                midInput += input.substring(sPoint + 1, ePoint);
            }

            input = input.substring(0, sPoint - repeat.length()) + midInput + input.substring(ePoint + 1, input.length());
        }

        System.out.println("input = " + input);
    }
}
