package com.skyluxsky;

import java.util.*;

public class TwoSum {

    //Java Brute Force
    public int[] twoSumsBrute(int[] nums, int target) {
        int n = 0;
        int[] numsArray = new int[4];

        //Inputs all values from nums[] into new array
        for (int i: nums){
            //System.out.println(i);
            numsArray[n] = i;
            //System.out.println(numsArray[n]);
            n++;
        }

        //Test if numsArray is different array
        //for (int i: nums){
            //i += 1;
            //System.out.println(i);
        //}

        //Double Check numsArray
        for (int i: numsArray){
            //System.out.println(i);
        }

        //two sums test
        for (int i = 0; i <= numsArray.length; i++){
            int current = i;
            int next = i + 1;//next element

            if (numsArray[current] + numsArray[next] == target){
                int[] outputArray = {current,next};
                return outputArray;
            } else {
                System.out.println(numsArray[current] + numsArray[next] + " does not equal " + target);
            }
        }

        int[] failedArray = {-1};
        return failedArray;
    }


    // Time complexity: O(n*log(n))
    public int[] findTwoSumSorting(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if(nums[left] + nums[right] == target) {
                return new int[] {left, right};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }








    /***Determines how many unique pairs there are****/
    // Java O(nlogn)
    public int getUniquePairs(int[] nums, int target){
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int ans = 0;
        while (i < j){
            int sum = nums[i]+ nums[j];
            if (sum < target){
                i++;
            } else if (sum > target){
                j--;
            } else {
                ans++;
                i++;
                j--;
                while (i < j && nums[i] == nums[i-1]){
                    i++;
                }
                while (i < j && nums[j] == nums[j+1]){
                    j--;
                }
            }
        }
        return ans;
    }


    /***Determines how many unique pairs there are****/
    // java O(n)
    public int getUniquePairsOpti(int[] nums, int target){
        Set<Integer> seen =  new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums){
            if (map.containsKey(num)){
                int key = map.get(num)*10 + num;
                if (! seen.contains(key)){
                    ans++;
                    seen.add(key);
                }
            } else {
                map.put(target-num, num);
            }
        }
        return ans;

    }
}
