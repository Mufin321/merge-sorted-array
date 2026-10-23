# 88. Merge Sorted Array

[![LeetCode](https://img.shields.io/badge/LeetCode-88-FFA116?style=for-the-badge&logo=leetcode&logoColor=black)](https://leetcode.com/problems/merge-sorted-array/)
[![Language](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![Difficulty](https://img.shields.io/badge/Difficulty-Easy-00B8A3?style=for-the-badge)](https://leetcode.com/problems/merge-sorted-array/)

---

## 📌 Problem Statement

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

**Merge** `nums1` and `nums2` into a single array sorted in **non-decreasing order**.

The final sorted array should **not** be returned by the function, but instead be stored inside the array `nums1`. To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements that should be merged, and the last `n` elements are set to `0` and should be ignored. `nums2` has a length of `n`.

---

## 💡 Examples

### Example 1:
```text
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the elements coming from nums1 and nums2.
```

### Example 2:
```text
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
```

### Example 3:
```text
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
```

---

## ⚙️ Constraints

- `nums1.length == m + n`
- `nums2.length == n`
- `0 <= m, n <= 200`
- `1 <= m + n <= 200`
- `-10^9 <= nums1[i], nums2[j] <= 10^9`

---

## 🧠 Approach: Three Pointers (Reverse / From the End)

### The Intuition
- If we merge starting from the beginning (index `0`), we would overwrite elements in `nums1` that haven't been compared yet, requiring extra buffer memory $O(m)$.
- However, `nums1` has empty buffer space at the **end** (the last `n` positions initialized to `0`).
- By comparing elements starting from the **back** and placing the largest elements at the end of `nums1`, we avoid overwriting any unprocessed elements in `nums1`.

### Pointer Setup
1. `p1 = m - 1`: Points to the largest remaining element in `nums1`.
2. `p2 = n - 1`: Points to the largest remaining element in `nums2`.
3. `p = m + n - 1`: Points to the current position to fill from the back of `nums1`.

### Step-by-Step Logic
- Compare `nums1[p1]` and `nums2[p2]`.
- Place the larger element at `nums1[p]`.
- Decrement the pointer from which the element was taken, and decrement `p`.
- Repeat until all elements of `nums2` are placed (`p2 < 0`).
- If `p2 < 0` while `p1 >= 0`, any remaining elements in `nums1` are already in their sorted positions!

---

## 🔍 Visual Dry Run

```text
nums1 = [1, 2, 3, 0, 0, 0], m = 3
                  ^ p1        ^ p
nums2 = [2, 5, 6], n = 3
               ^ p2

Step 1: nums2[p2] (6) > nums1[p1] (3) -> nums1[5] = 6, p2--, p--
nums1 = [1, 2, 3, 0, 0, 6]
nums2 = [2, 5, 6]

Step 2: nums2[p2] (5) > nums1[p1] (3) -> nums1[4] = 5, p2--, p--
nums1 = [1, 2, 3, 0, 5, 6]
nums2 = [2, 5, 6]

Step 3: nums1[p1] (3) > nums2[p2] (2) -> nums1[3] = 3, p1--, p--
nums1 = [1, 2, 3, 3, 5, 6]
nums2 = [2, 5, 6]

Step 4: nums1[p1] (2) <= nums2[p2] (2) -> nums1[2] = 2, p2--, p--
nums1 = [1, 2, 2, 3, 5, 6]
nums2 = [2, 5, 6]  (p2 = -1 -> Loop finishes!)

Final Result: [1, 2, 2, 3, 5, 6]
```

---

## ⏱️ Complexity Analysis

| Metric | Complexity | Explanation |
| :--- | :--- | :--- |
| **Time Complexity** | $\mathcal{O}(m + n)$ | Each element from `nums1` and `nums2` is traversed at most once. |
| **Space Complexity** | $\mathcal{O}(1)$ | Operates entirely in-place without auxiliary arrays. |

---

## 📁 Project Structure

```text
merge-sorted-array/
├── .gitignore          # Ignores compiled binaries and IDE configs
├── README.md           # Problem statement, explanation, and dry run
└── src/
    ├── Solution.java   # LeetCode submission solution
    └── Main.java       # Test suite covering standard & hidden edge cases
```

---

## 🚀 How to Run Locally

### 1. Compile the Java files
Open your terminal inside the `merge-sorted-array` directory:
```bash
javac src/Solution.java src/Main.java
```

### 2. Run the test suite
```bash
java -cp src Main
```

---

## 📤 How to Push to GitHub

If you want to create a new GitHub repository for this project:

```bash
# 1. Navigate to project folder
cd merge-sorted-array

# 2. Initialize git repository
git init

# 3. Add all files and make the initial commit
git add .
git commit -m "feat: Add LeetCode 88 Merge Sorted Array solution and test suite"

# 4. Set branch to main
git branch -M main

# 5. Link to your GitHub repository (replace with your repo URL)
git remote add origin https://github.com/<YOUR-USERNAME>/<YOUR-REPO-NAME>.git

# 6. Push to GitHub
git push -u origin main
```
