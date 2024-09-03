# Prismforce_Zeeshan
Solution for the assignment given by Prismforce as coding test
ASDE Algorithm Test

Imagine Abhimanyu in Chakravyuha. There are 11 circles in the Chakravyuha surrounded by different enemies. Abhimanyu is located in the innermost circle and has to cross all the 11 circles to reach Pandavas army back. 
 
Given:
1. Each circle is guarded by different enemy where enemy is equipped with k1, k2……k11 powers.
2. Abhimanyu start from the innermost circle with p power. Abhimanyu has a boon to skip fighting enemy a times.
3. Abhimanyu can recharge himself with power b times.
4. Battling in each circle will result in loss of the same power from Abhimanyu as the enemy.
5. If Abhimanyu enter the circle with energy less than the respective enemy, he will lose the battle.
6. k3 and k7 enemies are endured with power to regenerate themselves once with half of their initial power and can attack Abhimanyu from behind if he is battling in iteratively next circle 
 
# Solution Explanation
The solution is implemented in Java and uses a loop to simulate Abhimanyu's journey through the Chakravyuha. It considers the following scenarios:

1. Fighting the enemy if Abhimanyu's current power is sufficient.
2. Recharging Abhimanyu's power if his current power is insufficient to defeat the enemy and recharges are available.
3. Skipping the enemy if skips are available and necessary.
4. Handling attacks from behind by regenerating enemies in the 3rd and 7th circles.

The solution is tested with various scenarios to ensure correctness.
