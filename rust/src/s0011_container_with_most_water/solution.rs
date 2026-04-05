pub struct Solution;

impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        let mut head = 0;
        let mut tail = height.len() - 1;
        let mut biggest = 0;

        while head < tail {
            let head_h = height[head];
            let tail_h = height[tail];
            let area = (tail - head) * std::cmp::min(head_h, tail_h) as usize;
            biggest = std::cmp::max(area, biggest);

            if head_h <= tail_h {
                head += 1;
            } else {
                tail -= 1;
            }
        }
        biggest as i32
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_max_area() {
        assert_eq!(Solution::max_area(vec![1, 8, 6, 2, 5, 4, 8, 3, 7]), 49);
        assert_eq!(Solution::max_area(vec![1, 1]), 1);
    }
}
