import java.util.Scanner;

public class StringRotationChecker {
    public static boolean Rotation(String low1, String low2) {

        if (low1.length() != low2.length()) {
            return false;

        }else{

            String concatenated = low1 + low1;
            return concatenated.contains(low2);
        }
    }


    public static void main(String[] args) {

        Scanner a = new Scanner(System.in);

        System.out.print("Enter the Word 1 : ");
        String s1 = a.nextLine();
        String low1 = s1.toLowerCase();
        System.out.print("Enter the Word 2 : ");
        String s2 = a.nextLine();
        String low2 = s2.toLowerCase();


        boolean result = Rotation(low1, low2);

        if (result){
            System.out.println(s2+" is a Rotation of "+s1);

        }else{
            System.out.println(s2+" is not a Rotation of "+s1 );
        }
    }

}