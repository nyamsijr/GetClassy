package SafeInput;

import java.util.ArrayList;
import java.util.Scanner;

public class ObjInputTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> List = new ArrayList<>();



        String NonzeroString = SafeInput.getNonZeroLenString(in, "Enter a String");
        String RegexString = SafeInput.getRegExString(in, "Enter a email", "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9+_.-]+$");
        double dub = SafeInput.getDouble(in, "Enter a double");
        int integer = SafeInput.getInt(in, "Enter a int");
        double RangedDub = SafeInput.getRangedDouble(in, "Enter a Ranged Double", 1, 10);
        int RangedInt = SafeInput.getRangedInt(in, "Enter a Ranged int", 1, 10);
        boolean YN = SafeInput.getYNConfirm(in, "Do you like coding?");

        List.add(NonzeroString);
        List.add(RegexString);
        List.add(Double.toString(dub));
        List.add(Integer.toString(integer));
        List.add(Double.toString(RangedDub));
        List.add(Integer.toString(RangedInt));
        List.add(Boolean.toString(YN));

        for (String string : List) {
            System.out.println(string);

}


    }
}
