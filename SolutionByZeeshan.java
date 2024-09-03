import java.util.Scanner;

public class Chakravyuha {
    static final int maxEnemies = 11;
    static int p;  // Initial power of Abhimanyu

    // Function to determine if Abhimanyu can cross the Chakravyuha
    public static boolean canCrossOrNot(int[] enemyPower, int p, int s, int r) {
        int cur = p;  // Current power of Abhimanyu
        int e = 0;    // Index for the current enemy

        while (e < maxEnemies) {
            // Check 1: If Abhimanyu's current power is greater than or equal to the current enemy's power
            if (cur >= enemyPower[e]) {
                // Check 2: If the current enemy can regenerate (k3 or k7)
                if (e == 2 || e == 6) {
                    cur -= enemyPower[e];  // Fight the enemy, reducing Abhimanyu's power
                    // Add half of the current enemy's power to the next enemy's power due to regeneration
                    enemyPower[e + 1] += enemyPower[e] / 2;
                } else {
                    cur -= enemyPower[e];  // Fight the normal enemy, reducing Abhimanyu's power
                }
                e++;  // Move to the next enemy
            }
            // If Abhimanyu's current power is less than the current enemy's power
            else {
                // Check 3: If recharging can allow Abhimanyu to defeat the enemy
                if (r > 0 && p >= enemyPower[e]) {
                    r--;  // Use one recharge
                    cur = p - enemyPower[e];  // Recharge and then fight the enemy
                    e++;  // Move to the next enemy
                }
                // If recharging is not possible or insufficient, attempt to skip the enemy
                else if (s > 0) {
                    s--;  // Use one skip
                    e++;  // Skip the enemy and move to the next one
                }
                // If neither recharge nor skip is possible, Abhimanyu fails to cross the Chakravyuha
                else {
                    return false;
                }
            }
        }
        // If Abhimanyu successfully passes all enemies, he crosses the Chakravyuha
        return true;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int[] enemyPower = new int[maxEnemies];  // Array to store the power of each enemy

        // Input: Enemy powers
        for (int i = 0; i < maxEnemies; i++) {
            enemyPower[i] = myScanner.nextInt();
        }

        p = myScanner.nextInt();  // Input: Initial power of Abhimanyu
        int s = myScanner.nextInt();  // Input: Number of skips Abhimanyu can use
        int r = myScanner.nextInt();  // Input: Number of times Abhimanyu can recharge

        // Output: Whether Abhimanyu can cross the Chakravyuha or not
        if (canCrossOrNot(enemyPower, p, s, r))
            System.out.println("Abhimanyu can cross the Chakravyuha");
        else
            System.out.println("Abhimanyu can't cross the Chakravyuha");
        myScanner.close();
    }
}
