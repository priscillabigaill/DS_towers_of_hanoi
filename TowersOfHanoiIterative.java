import java.util.Scanner;
import java.util.Stack;

public class TowersOfHanoiIterative {

    public static String moves(int n, char firstPeg, char midPeg, char lastPeg){
        Stack<places> stack = new Stack<>();
        stack.push(new places(n, firstPeg, lastPeg, midPeg));
        StringBuilder sb = new StringBuilder();

        while (!stack.empty()) {
            places places = stack.pop();
            if (places.n == 1) {
                sb.append("Move disk 1 from peg " + places.firstPeg +
                        " to peg " + places.lastPeg + "\n");
            } else {
                stack.push(new places(places.n - 1, places.midPeg, places.lastPeg, places.firstPeg));
                stack.push(new places(1, places.firstPeg, places.lastPeg, places.midPeg));
                stack.push(new places(places.n - 1, places.firstPeg, places.midPeg, places.lastPeg));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of disk(s): ");
        int numOfDisks = in.nextInt();
        String moves = moves(numOfDisks, 'L', 'M', 'R');
        System.out.println(moves);
    }

    private static class places {
        int n;
        char firstPeg;
        char midPeg;
        char lastPeg;

        public places(int n, char firstPeg, char midPeg, char lastPeg) {
            this.n = n;
            this.firstPeg = firstPeg;
            this.midPeg = midPeg;
            this.lastPeg = lastPeg;
        }
    }

}
