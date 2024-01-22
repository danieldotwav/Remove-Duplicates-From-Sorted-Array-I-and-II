## Introduction

This Java project implements an efficient algorithm to remove duplicate numbers from a sorted array in-place, preserving the order of the elements. The key challenge addressed is modifying the array so that the first k elements contain the unique elements as they originally appeared in the array.

The second method ```removeDuplicatesII()``` removes duplicates from a sorted array while allowing a specified number of duplicates for each unique element.


## Algorithms

### **1. Remove Duplicates I**

#### Logic

- The algorithm uses a two-pointer approach: one pointer (uniqueNumPtr) to track the position where the next unique element should be placed, and the other to iterate through the array.
- As it finds a unique element (different from the previous one), it places it at the uniqueNumPtr position.
- This approach ensures in-place modification of the array with minimal space usage.

#### Complexity Analysis

- **Time Complexity:** O(n) - as the array is iterated through only once.
- **Space Complexity:** O(1) - as no additional space is used apart from the input array.

### Code Snippet

```java
public class Main {
    public static void main(String[] args) {
        // Test cases with expected outputs
        System.out.println(removeDuplicatesI(new int[] {1, 2, 3})); // Expected Output: 3
        System.out.println(removeDuplicatesI(new int[] {1, 2, 2})); // Expected Output: 2
        // ... other test cases ...
    }

    static int removeDuplicatesI(int[] nums) {
        if (nums.length == 0) return 0;
        int currentUniqueNum = nums[0];
        int uniqueNumPtr = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != currentUniqueNum) {
                currentUniqueNum = nums[i];
                nums[++uniqueNumPtr] = currentUniqueNum;
            }
        }
        return uniqueNumPtr + 1;
    }
}
```

### Test Cases

The following test cases are designed to validate the functionality of the removeDuplicatesI method. Each test case includes the input array and its expected output after removing duplicates.

```java
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

```

### **2. Remove Duplicates II**

#### Logic
- Processes a sorted array to remove duplicates.
- Maintains a counter for duplicates.
- Shifts unique elements to the beginning of the array.

#### Complexity Analysis
- **Time Complexity:** O(n) - Processes each element once.
- **Space Complexity:** O(1) - In-place operation with constant space.

### Code Snippet

```java
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
```

### Test Cases

The following test cases are designed to validate the functionality of the removeDuplicatesI method. Each test case includes the input array and its expected output after removing duplicates.

```java
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
```