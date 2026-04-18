use std::collections::HashMap;

pub struct Solution;

#[derive(Default)]
struct TimeMap {
    store: HashMap<String, Vec<TimeCapsule>>,
}

struct TimeCapsule {
    value: String,
    timestamp: i32,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl TimeMap {
    fn new() -> Self {
        TimeMap::default()
    }

    fn set(&mut self, key: String, value: String, timestamp: i32) {
        self.store
            .entry(key)
            .or_default()
            .push(TimeCapsule { value, timestamp });
    }

    fn get(&self, key: String, timestamp: i32) -> String {
        let Some(values) = self.store.get(&key) else {
            return String::new();
        };

        let idx = values.partition_point(|tc| tc.timestamp <= timestamp);

        if idx == 0 {
            String::new()
        } else {
            values[idx - 1].value.clone()
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * let obj = TimeMap::new();
 * obj.set(key, value, timestamp);
 * let ret_2: String = obj.get(key, timestamp);
 */

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_time_map() {
        let mut tm = TimeMap::new();

        tm.set("foo".to_string(), "bar".to_string(), 1);
        assert_eq!(tm.get("foo".to_string(), 1), "bar");
        assert_eq!(tm.get("foo".to_string(), 3), "bar");

        tm.set("foo".to_string(), "bar2".to_string(), 4);
        assert_eq!(tm.get("foo".to_string(), 4), "bar2");
        assert_eq!(tm.get("foo".to_string(), 5), "bar2");
    }
}
