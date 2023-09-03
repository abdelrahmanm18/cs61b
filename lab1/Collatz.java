/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME HERE
 */
public class Collatz {

    /** Buggy implementation of nextNumber! but i fixed it now :))) */
    /** this method is used to print the collatz sequence starting from a given number
     * it has three condition : if the number is even , odd or 1;
     * in even number case it should return n/2
     * in odd number case it should return 3n+1
     * or if it was 1 the sequence ends and returns 1
     * 
     * */
    public static int nextNumber(int n) {
        if (n  == 1) {
            return 1;
        } else if (n % 2 == 0) {
            return n / 2 ;
        } else {
            return 3*n+1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

