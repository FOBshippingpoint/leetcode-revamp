pub struct Solution;

impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        let mut head = 0;
        let mut tail = 1;
        let mut profit = 0;

        while tail < prices.len() {
            let head_price = prices[head];
            let tail_price = prices[tail];
            if head_price > tail_price {
                head = tail;
            } else {
                profit = std::cmp::max(profit, tail_price - head_price);
            }
            tail += 1;
        }
        profit
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_max_profit() {
        assert_eq!(Solution::max_profit(vec![7, 1, 5, 3, 6, 4]), 5);
        assert_eq!(Solution::max_profit(vec![7, 6, 4, 3, 1]), 0);
    }
}
