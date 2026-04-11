pub struct Solution;

impl Solution {
    pub fn car_fleet_v1(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        let mut stack = Vec::new();
        let mut cars: Vec<(i32, i32)> = position.into_iter().zip(speed.into_iter()).collect();
        cars.sort_unstable_by_key(|&(pos, _)| pos);

        for (pos, spd) in cars.into_iter().rev() {
            let dest_time = (target - pos) as f32 / (spd as f32);
            match stack.last() {
                Some(&t) if t >= dest_time => {}
                _ => stack.push(dest_time),
            }
        }
        stack.len() as i32
    }

    pub fn car_fleet_v2(target: i32, position: Vec<i32>, speed: Vec<i32>) -> i32 {
        let mut fleets = 0;
        let mut max_time = 0.0;

        let mut cars: Vec<(i32, i32)> = position.into_iter().zip(speed.into_iter()).collect();
        cars.sort_unstable_by_key(|&(pos, _)| pos);

        for (pos, spd) in cars.into_iter().rev() {
            let dest_time = (target - pos) as f32 / (spd as f32);
            if dest_time > max_time {
                max_time = dest_time;
                fleets += 1;
            }
        }
        fleets
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_car_fleet() {
        let cases = [
            (12, vec![10, 8, 0, 5, 3], vec![2, 4, 1, 1, 3], 3),
            (10, vec![3], vec![3], 1),
            (100, vec![0, 2, 4], vec![4, 2, 1], 1),
        ];

        let solutions: [(fn(i32, Vec<i32>, Vec<i32>) -> i32, &str); 2] = [
            (Solution::car_fleet_v1, "v1: stack"),
            (Solution::car_fleet_v2, "v2: single max_time tracker"),
        ];

        for sol in solutions.iter() {
            for (target, pos, spd, expected) in &cases {
                let result = sol.0(*target, pos.clone(), spd.clone());
                assert_eq!(
                    &result, expected,
                    "Failed on version {} with target {}",
                    sol.1, target
                );
            }
        }
    }
}
