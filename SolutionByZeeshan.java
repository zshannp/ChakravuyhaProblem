import java.util.Scanner;

public class Chakravyuha {
    static final int maxEnemies = 11;
    static int p;  // Initial power of Abhimanyu

    // Function to determine if Abhimanyu can cross the Chakravyuha
    public static boolean canCrossOrNot(int[] enemyPower, int p, int a, int b) {
        int cur = p;  // Current power of Abhimanyu
        int e = 0;    // Index for the current enemy

        while (e < maxEnemies) {
            // Check 1: If Abhimanyu'a current power is greater than or equal to the current enemy'a power
            if (cur >= enemyPower[e]) {
                // Check 2: If the current enemy can regenerate (k3 or k7)
                if (e == 2 || e == 6) {
                    cur -= enemyPower[e];  // Fight the enemy, reducing Abhimanyu'a power
                    // Add half of the current enemy'a power to the next enemy'a power due to regeneration
                    enemyPower[e + 1] += enemyPower[e] / 2;
                } else {
                    cur -= enemyPower[e];  // Fight the normal enemy, reducing Abhimanyu'a power
                }
                e++;  // Move to the next enemy
            }
            // If Abhimanyu'a current power is less than the current enemy'a power
            else {
                // Check 3: If recharging can allow Abhimanyu to defeat the enemy
                if (b > 0 && p >= enemyPower[e]) {
                    b--;  // Use one recharge
                    cur = p - enemyPower[e];  // Recharge and then fight the enemy
                    e++;  // Move to the next enemy
                }
                // If recharging is not possible or insufficient, attempt to skip the enemy
                else if (a > 0) {
                    a--;  // Use one skip
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
        int a = myScanner.nextInt();  // Input: Number of skips Abhimanyu can use
        int b = myScanner.nextInt();  // Input: Number of times Abhimanyu can recharge

        // Output: Whether Abhimanyu can cross the Chakravyuha or not
        if (canCrossOrNot(enemyPower, p, a, b))
            System.out.println("Abhimanyu can cross the Chakravyuha");
        else
            System.out.println("Abhimanyu can't cross the Chakravyuha");
        myScanner.close();
    }
}


// Test Case 1
// Enemy Powers: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55]
// Initial Power (p): 30
// Number of Skips (a): 1
// Number of Recharges (b): 1
// Answer: Abhimanyu cannot cross the Chakravyuha.

// Test Case 2
// Enemy Powers: [3, 5, 7, 10, 6, 9, 4, 8, 2, 7, 11]
// Initial Power (p): 35
// Number of Skips (a): 1
// Number of Recharges (b): 2
// Answer: Abhimanyu can cross the Chakravyuha.

// Test Case 3
// Enemy Powers: [5, 12, 8, 20, 7, 18, 9, 22, 14, 25, 16]
// Initial Power (p): 40
// Number of Skips (a): 2
// Number of Recharges (b): 1
// Answer: Abhimanyu cannot cross the Chakravyuha.
