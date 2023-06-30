public class Task2 {
    public static void main(String[] args) {
        String filePath = args[0];
        String result = getFilePathAndName(filePath);
        System.out.println(result);
    }
    public static String getFilePathAndName(String filePath) {
        int splash = Math.max(filePath.lastIndexOf("/"), filePath.lastIndexOf("\\"));
        String path = filePath.substring(0, splash + 1);
        String fileName = filePath.substring(splash + 1);
        if (fileName.length() == 0) {
            return "Invalid path to file entered.";
        }
        String result = "Path: " + path + "\nFile Name: " + fileName;
        return result;
    }
}
