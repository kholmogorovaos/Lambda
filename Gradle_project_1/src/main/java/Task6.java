public class Task6 {
    public static int toInt(String str) {
        int number = 0;
        int sign = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i == 0 && ch == '-') {
                sign = -1;
                continue;
            }
            if (ch < '0' || ch > '9') {
                throw new NumberFormatException("Input string is not a number");
            }
            number = number * 10 + (ch - '0');
        }
        return number * sign;
    }
    public static void main(String[] args) {
        int number = toInt(String.valueOf(args[0]));
        System.out.println(number * 2);
    }
}
