// Prompt: Remove duplicate numbers from an array using an in-place algorithm while keeping the relative 
// order of the elements the same. Change the array nums such that the first k elements of nums contain 
// the unique elements in the order they were present in nums initially.

public class Main {
    public static void main(String[] args) {
        // REMOVE DUPLICATES I TEST CASES
        System.out.println("\nremoveDuplicatesI Test Cases\n");

        // Test case 1: No duplicates
        System.out.println(removeDuplicatesI(new int[] {1, 2, 3})); // Expected Output: 3

        // Test case 2: Consecutive duplicates
        System.out.println(removeDuplicatesI(new int[] {1, 2, 2})); // Expected Output: 2

        // Test case 3: Non-consecutive duplicates
        System.out.println(removeDuplicatesI(new int[] {1, 2, 2, 3, 3, 4})); // Expected Output: 4

        // Test case 4: All elements are duplicates
        System.out.println(removeDuplicatesI(new int[] {2, 2, 2, 2})); // Expected Output: 1

        // Test case 5: Single element
        System.out.println(removeDuplicatesI(new int[] {1})); // Expected Output: 1

        // Test case 6: Empty array
        System.out.println(removeDuplicatesI(new int[] {})); // Expected Output: 0

        // Test case 7: Longer array with mixed duplicates
        System.out.println(removeDuplicatesI(new int[] {1, 1, 2, 3, 3, 3, 4, 5, 5, 6})); // Expected Output: 6

        // Test case 8: Array with all elements being the same
        System.out.println(removeDuplicatesI(new int[] {7, 7, 7, 7, 7})); // Expected Output: 1

        // REMOVE DUPLICATES II TEST CASES
        System.out.println("\nremoveDuplicatesII Test Cases\n");

        // Test case 1: Non-consecutive duplicates
        System.out.println(removeDuplicatesII(new int[] {1, 2, 2, 3, 3, 4})); // Expected Output: 6

        // Test case 2: Consecutive duplicates
        System.out.println(removeDuplicatesII(new int[] {1, 1, 2, 2, 2, 3, 3, 3, 4})); // Expected Output: 7

        // Test case 3: No duplicates
        System.out.println(removeDuplicatesII(new int[] {1, 2, 3, 4, 5})); // Expected Output: 5

        // Test case 4: Empty array
        System.out.println(removeDuplicatesII(new int[] {})); // Expected Output: 0

        // Test case 5: All elements are the same
        System.out.println(removeDuplicatesII(new int[] {2, 2, 2, 2, 2})); // Expected Output: 2

        // Test case 6: Single element array
        System.out.println(removeDuplicatesII(new int[] {7})); // Expected Output: 1
    }

    static int removeDuplicatesI(int[] nums) {
        // Return 0 for empty arrays
        if (nums.length == 0) { return 0; }
        
        int arrSize = nums.length;
        int currentUniqueNum = nums[0];
        int uniqueNumPtr = 0;

        for (int i = 1; i < arrSize; ++i) {
            if (nums[i] != currentUniqueNum) {
                currentUniqueNum = nums[i]; // Set the current number to the new unique value
                nums[++uniqueNumPtr] = currentUniqueNum; 
            }
        }
        return uniqueNumPtr + 1; // Now simply return the number of unique values
    }

    // This method will remove "some" duplicates in place such that no number appears more than twice
    static int removeDuplicatesII(int[] nums) {
        // Handle empty arrays
        int arrSize = nums.length;
        if (arrSize == 0) { return 0; }
    
        // Adjust the desired frequency of allowed duplicates
        int LIMIT = 2;
    
        // Store the first number
        int currentUniqueNum = nums[0];
        int uniqueNumPtr = 0;
        int duplicateCounter = 1;
    
        for (int i = 1; i < arrSize; ++i) {
            if (nums[i] != currentUniqueNum) {
                duplicateCounter = 1;
                currentUniqueNum = nums[i];
                nums[++uniqueNumPtr] = currentUniqueNum;
            }
            else {
                if (duplicateCounter < LIMIT) {
                    currentUniqueNum = nums[i];
                    nums[++uniqueNumPtr] = currentUniqueNum;
                }
                ++duplicateCounter;
            }
        }
        return uniqueNumPtr + 1;
    }
}
