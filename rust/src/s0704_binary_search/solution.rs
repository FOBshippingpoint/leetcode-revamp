use std::cmp::Ordering;

pub struct Solution;

impl Solution {
    pub fn search_v1(nums: Vec<i32>, target: i32) -> i32 {
        let mut low = 0;
        let mut high = nums.len();

        while low < high {
            let mid = low + (high - low) / 2;
            let val = nums[mid];
            if val < target {
                low = mid + 1;
            } else if val > target {
                high = mid;
            } else {
                return mid as i32;
            }
        }
        -1
    }

    pub fn search_v2(nums: Vec<i32>, target: i32) -> i32 {
        let mut low = 0;
        let mut high = nums.len();

        while low < high {
            let mid = low + (high - low) / 2;
            match nums[mid].cmp(&target) {
                Ordering::Less => low = mid + 1,
                Ordering::Equal => return mid as i32,
                Ordering::Greater => high = mid,
            }
        }
        -1
    }

    pub fn search_v3(nums: Vec<i32>, target: i32) -> i32 {
        nums.binary_search(&target)
            .map(|idx| idx as i32)
            .unwrap_or(-1)
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_search() {
        let cases = [
            (vec![-1, 0, 3, 5, 9, 12], 9, 4),
            (vec![-1, 0, 3, 5, 9, 12], 2, -1),
        ];

        let solutions: &[(fn(Vec<i32>, i32) -> i32, &str)] = &[
            (Solution::search_v1, "v1: binary search"),
            (Solution::search_v2, "v2: binary search with match Cmp"),
            (Solution::search_v3, "v3: binary search standard lib"),
        ];

        for sol in solutions.iter() {
            for (nums, target, expected) in &cases {
                let result = sol.0(nums.clone(), *target);
                assert_eq!(
                    &result, expected,
                    "Failed on version {} with target {}",
                    sol.1, target
                );
            }
        }
    }
}
