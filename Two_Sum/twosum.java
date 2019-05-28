package Two_Sum;

// see the description here: https://leetcode.com/problems/two-sum/description/
// Example: Given nums = [2, 7, 11, 15], target = 9,
//          Because nums[0] + nums[1] = 2 + 7 = 9,
//          return [0, 1].

// Important note: [You may assume that each input would have exactly one solution,
// and you may not use the same element twice.]

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;

public class twosum {

    private int[] result1;

    // first method: is just iterate over the original int list twice
    // Run-Time Analysis: cost model: choose the number of times the if statement get called
    // worst case runtime: n-1 + ... + 2 + 1, which is BIG THETA(N^2)
    // best case runtime: BIG THETA(1)
    // space complexity: BIG THETA(1), [doesn't use any apparent space??]

    public int[] first_method(int[] lst, int target) {
        for (int i = 0; i < lst.length; i++) {
            for (int j = i + 1; j < lst.length; j++) {
                if (lst[i] + lst[j] == target) {
                    result1 = new int[]{i, j};
                }
            }
        }
        return result1;
    }

    // second method is to use a HashMap:
    // @source LeetCode analysis:
    // time complexity: O(1) for each hashmap.containsKey() and a total(worst case) of n times, so the answer is BIG THETA(N)
    // space complexity: BIG THETA(N) The extra space required depends on the number of items stored in the hash table,
    // which stores at most n elements.

    // one thing that is important:
    // Q: why is hashmap.containsKey() O(1), well, first see this source code from Princeton
    // /**
    //     * Returns true if this symbol table contains the specified key.
    //     *
    //     * @param  key the key
    //     * @return {@code true} if this symbol table contains {@code key};
    //     *         {@code false} otherwise
    //     * @throws IllegalArgumentException if {@code key} is {@code null}
    //     */

    //    public boolean contains(Key key) {
    //        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
    //        return get(key) != null;
    //    }
    //
    //    /**
    //     * Returns the value associated with the specified key in this symbol table.
    //     *
    //     * @param  key the key
    //     * @return the value associated with {@code key} in the symbol table;
    //     *         {@code null} if no such value
    //     * @throws IllegalArgumentException if {@code key} is {@code null}
    //     */

    //    public Value get(Key key) {
    //        if (key == null) throw new IllegalArgumentException("argument to get() is null");
    //        int i = hash(key);
    //        return st[i].get(key);
    //    }

    // what you see is that the containsKey/contains(Key key) method calls get(key) method, so the runtime of
    // contains method is the same as get(Key key) method, and we know that the get(Key key)method will be BIG
    // THETA(N), but with linear resizing, contains would be BIG THETA(1) if we assume items are evenly spread.
    // see https://docs.google.com/presentation/d/1QevjelsyVO8Ea375VRhIf-o--MIMDYB83OxBbXnbQZU/edit#slide=id.g52624185f6_2_2823
    // page 68 for more detail. The above source code is at: https://algs4.cs.princeton.edu/34hash/SeparateChainingHashST.java.html


    public int[] second_method(int[] lst, int target) {
        // add lst[i], i into hashmap<int, int>
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < lst.length; i++) {
            int complement = target - lst[i];
            if (hm.containsKey(complement)) {
                return new int[]{hm.get(complement), i};
            }
            hm.put(lst[i], i);
        }
        throw new IllegalArgumentException("No two sum found");
    }


}


