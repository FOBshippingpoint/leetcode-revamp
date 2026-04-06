pub struct Solution;

use std::collections::HashMap;

impl Solution {
    pub fn check_inclusion_v1(s1: String, s2: String) -> bool {
        if s1.len() > s2.len() {
            return false;
        }

        let mut freq_map: HashMap<char, i32> = HashMap::new();
        let s2_chars: Vec<char> = s2.chars().collect();

        for ch in s1.chars() {
            *freq_map.entry(ch).or_insert(0) += 1;
        }

        let mut head = 0;

        for tail in 0..s2_chars.len() {
            let tail_char = s2_chars[tail];
            *freq_map.entry(tail_char).or_insert(0) -= 1;

            while *freq_map.get(&tail_char).unwrap() < 0 {
                *freq_map.entry(s2_chars[head]).or_insert(0) += 1;
                head += 1;
            }
            if 1 + tail - head == s1.len() {
                return true
            }
        }
        false
    }

    pub fn check_inclusion_v2(s1: String, s2: String) -> bool {
        if s1.len() > s2.len() {
            return false;
        }

        let mut counts = [0_i32; 26];

        let s1_bytes = s1.as_bytes();
        let s2_bytes = s2.as_bytes();

        for &byte in s1_bytes {
            counts[(byte - b'a') as usize] += 1;
        }

        let mut head = 0;

        for tail in 0..s2_bytes.len() {
            let tail_idx = (s2_bytes[tail] - b'a') as usize;
            counts[tail_idx] -= 1;

            while counts[tail_idx] < 0 {
                let head_idx = (s2_bytes[head] - b'a') as usize;
                counts[head_idx] += 1;
                head += 1;
            }
            if 1 + tail - head == s1.len() {
                return true
            }
        }
        false
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_check_inclusion_v1() {
        assert_eq!(
            Solution::check_inclusion_v1(String::from("ab"), String::from("eidbaooo")),
            true
        );
        assert_eq!(
            Solution::check_inclusion_v1(String::from("ab"), String::from("eidboaoo")),
            false
        );
    }

    #[test]
    fn test_check_inclusion_v2() {
        assert_eq!(
            Solution::check_inclusion_v2(String::from("ab"), String::from("eidbaooo")),
            true
        );
        assert_eq!(
            Solution::check_inclusion_v2(String::from("ab"), String::from("eidboaoo")),
            false
        );
    }
}
