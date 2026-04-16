pub struct Solution;

impl Solution {
    pub fn find_min_v1(nums: Vec<i32>) -> i32 {
        nums.into_iter().min().expect("impossible to fail")
    }

    pub fn find_min_v2(nums: Vec<i32>) -> i32 {
        nums.windows(2)
            .find(|w| w[0] > w[1]) // The gap: 3 4 5 [6 1] 2
            .map_or(nums[0], |w| w[1])
    }

    pub fn find_min_v3(nums: Vec<i32>) -> i32 {
        let mut left = 0;
        let mut right = nums.len() - 1;

        while left < right {
            let mid = left + (right - left) / 2;
            if nums[mid] < nums[right] {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        nums[left]
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_find_min() {
        let cases = [
            (vec![3, 4, 5, 6, 1, 2], 1),
            (vec![4, 5, 0, 1, 2, 3], 0),
            (vec![4, 5, 6, 7], 4),
        ];

        let solutions: [(fn(Vec<i32>) -> i32, &str); _] = [
            (Solution::find_min_v1, "v1: built-in min"),
            (Solution::find_min_v2, "v2: linear scan"),
            (Solution::find_min_v3, "v3: binary search"),
        ];

        for sol in &solutions {
            for (nums, expected) in &cases {
                let result = sol.0(nums.clone());
                assert_eq!(&result, expected, "Failed on {}", sol.1);
            }
        }
    }
}
