pub struct Solution;

use std::collections::HashMap;

impl Solution {
    pub fn two_sum_v1(nums: Vec<i32>, target: i32) -> Vec<i32> {
        for i in 0..nums.len() {
            for j in (i + 1)..nums.len() {
                if nums[i] + nums[j] == target {
                    return vec![i as i32, j as i32];
                }
            }
        }
        vec![]
    }

    pub fn two_sum_v2(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map = HashMap::with_capacity(nums.len());
        for (i, n) in nums.iter().enumerate() {
            match map.get(&(target - n)) {
                None => {
                    map.insert(n, i);
                }
                Some(i2) => {
                    return vec![*i2 as i32, i as i32];
                }
            }
        }
        vec![]
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_two_sum_v1() {
        assert_eq!(Solution::two_sum_v1(vec![2, 7, 11, 15], 9), vec![0, 1]);
        assert_eq!(Solution::two_sum_v1(vec![3, 2, 4], 6), vec![1, 2]);
        assert_eq!(Solution::two_sum_v1(vec![3, 3], 6), vec![0, 1]);
    }

    #[test]
    fn test_two_sum_v2() {
        assert_eq!(Solution::two_sum_v2(vec![2, 7, 11, 15], 9), vec![0, 1]);
        assert_eq!(Solution::two_sum_v2(vec![3, 2, 4], 6), vec![1, 2]);
        assert_eq!(Solution::two_sum_v2(vec![3, 3], 6), vec![0, 1]);
    }
}
