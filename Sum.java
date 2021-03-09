import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Sum {
    public static void main(String[] args) {
        // Using Scanner for Getting Input from file
        File file = new File(args[0]);
        int sum = 0;
        try {
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                sum += Integer.parseInt(in.nextLine());
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
