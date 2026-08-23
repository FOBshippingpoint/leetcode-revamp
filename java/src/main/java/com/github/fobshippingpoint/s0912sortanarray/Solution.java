package com.github.fobshippingpoint.s0912sortanarray;

public class Solution {

    public int[] sortArray(int[] nums) {
       if (nums == null || nums.length <= 1)  {
           return nums;
       }
       var aux = new int[nums.length];
       mergeSort(nums, aux, 0, nums.length -1);
       return nums;
    }

    private void mergeSort(int[] nums, int[] aux, int left, int right) {
        if (left >= right) {
            return;
        }

        var mid = (left + right) / 2;
        mergeSort(nums, aux, left, mid);
        mergeSort(nums, aux, mid + 1, right);

        merge(nums, aux, left, mid, right);
    }

    private void merge(int[] nums, int[] aux, int left, int mid, int right) {
        System.arraycopy(nums, left, aux, left, right - left + 1);

        var i = left;
        var j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > right) {
                nums[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }

}
