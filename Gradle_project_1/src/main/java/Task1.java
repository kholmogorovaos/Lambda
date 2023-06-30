public class Task1 {
    public int calculate(String s, String letter) {
        int index = s.indexOf(letter);
        if (index == -1) {
            return -1; // Буква не найдена
        }
        String substring = s.substring(0, index);
        substring = substring.replaceAll("\\s", "");
        return substring.length();
    }
}
