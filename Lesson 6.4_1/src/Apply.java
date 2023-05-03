public class Apply {
    static Function function = null;

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Не передано название операции");
            return;
        } else
            switch (args[0]) {
                case "Half":
                    function = new Half();
                    break;
                case "Double":
                    function = new Double();
                    break;
                case "Exact":
                    function = new Exact();
                    break;
                case "Square":
                    function = new Square();
                    break;
                case "Wave":
                    function = new Function() {
                        int prev = 0;
                        @Override
                        public int evaluate(int x) {
                            int result = x + prev;
                            prev = x;
                            return result;
                        }
                    };
                    break;
                case "SquareEven":
                    function = x -> x % 2 == 0 ? x * x : x;
                    break;
                default:
                    System.out.println("Операция " + args[0] + " не поддерживается");
                    return;
            }
        if (args.length < 2 || !args[1].matches("\\d+")) {
            System.out.println("Не переданы числа для операции");
            return;
        }

        int[] numbers = new int[args.length - 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(args[i + 1]);
        }
        int[] result = applyFunction(numbers, function);

        System.out.println("Исходная последовательность:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        System.out.println("Последовательность после применения функции:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static int[] applyFunction(int[] numbers, Function function) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = function.evaluate(numbers[i]);
        }
        return result;
    }
}



