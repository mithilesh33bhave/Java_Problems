import java.util.*;

public class VotingSystemUsingHashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> voters = new HashSet<>();

        while (true) {
            System.out.print("Enter voter ID (or 'exit'): ");
            String id = sc.nextLine();
            if (id.equalsIgnoreCase("exit")) break;
            if (voters.contains(id)) {
                System.out.println("Already voted.");
            } else {
                voters.add(id);
                System.out.println("Vote recorded.");
            }
        }
    }
}
