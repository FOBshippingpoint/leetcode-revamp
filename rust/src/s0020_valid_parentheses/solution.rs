pub struct Solution;

impl Solution {
    pub fn is_valid_v1(s: String) -> bool {
        let mut stack = Vec::new();
        for ch in s.chars() {
            match ch {
                '(' => stack.push(')'),
                '{' => stack.push('}'),
                '[' => stack.push(']'),
                ')' | '}' | ']' if Some(ch) != stack.pop() => return false,
                _ => {}
            }
        }
        stack.is_empty()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_is_valid_v1() {
        assert_eq!(Solution::is_valid_v1(String::from("()")), true);
        assert_eq!(Solution::is_valid_v1(String::from("()[]{}")), true);
        assert_eq!(Solution::is_valid_v1(String::from("(]")), false);
        assert_eq!(Solution::is_valid_v1(String::from("([])")), true);
        assert_eq!(Solution::is_valid_v1(String::from("([)]")), false);
    }
}
