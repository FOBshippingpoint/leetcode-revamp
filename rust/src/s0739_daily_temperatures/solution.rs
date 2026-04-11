pub struct Solution;

impl Solution {
    pub fn daily_temperatures_v1(temperatures: Vec<i32>) -> Vec<i32> {
        let mut result = vec![0; temperatures.len()];
        let mut stack: Vec<usize> = Vec::with_capacity(temperatures.len());

        for (i, &temp) in temperatures.iter().enumerate() {
            while stack
                .last()
                .is_some_and(|&prev_idx| temperatures[prev_idx] < temp)
            {
                let prev_idx = stack.pop().unwrap();
                result[prev_idx] = (i - prev_idx) as i32;
            }
            stack.push(i);
        }
        result
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_daily_temperatures_v1() {
        let cases = [
            (
                vec![73, 74, 75, 71, 69, 72, 76, 73],
                vec![1, 1, 4, 2, 1, 1, 0, 0],
            ),
            (vec![30, 40, 50, 60], vec![1, 1, 1, 0]),
            (vec![30, 60, 90], vec![1, 1, 0]),
        ];

        for (input, expected) in cases {
            assert_eq!(Solution::daily_temperatures_v1(input), expected);
        }
    }
}
