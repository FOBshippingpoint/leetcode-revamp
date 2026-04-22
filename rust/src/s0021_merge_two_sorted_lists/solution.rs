pub struct Solution;

#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode { next: None, val }
    }
}

impl Solution {
    pub fn merge_two_lists(
        mut list1: Option<Box<ListNode>>,
        mut list2: Option<Box<ListNode>>,
    ) -> Option<Box<ListNode>> {
        let mut dummy = ListNode::new(0);
        let mut curr = &mut dummy;

        while list1.is_some() && list2.is_some() {
            if list1.as_ref().unwrap().val < list2.as_ref().unwrap().val {
                let mut node = list1.take();
                list1 = node.as_mut().unwrap().next.take();
                curr.next = node;
            } else {
                let mut node = list2.take();
                list2 = node.as_mut().unwrap().next.take();
                curr.next = node;
            }
            curr = curr.next.as_mut().unwrap();
        }
        curr.next = list1.or(list2);
        dummy.next
    }
}

fn array_to_list(values: &[i32]) -> Option<Box<ListNode>> {
    values
        .iter()
        .rev()
        .fold(None, |next, &val| Some(Box::new(ListNode { val, next })))
}

fn list_to_array(head: &Option<Box<ListNode>>) -> Vec<i32> {
    let mut result = Vec::new();
    let mut curr = head.as_ref();
    while let Some(node) = curr {
        result.push(node.val);
        curr = node.next.as_ref();
    }
    result
}

#[cfg(test)]
mod tests {
    use super::*;

    fn to_list(vector: &Vec<i32>) -> Option<Box<ListNode>> {
        let mut head = None;
        for &val in vector.iter().rev() {
            let mut node = ListNode::new(val);
            node.next = head;
            head = Some(Box::new(node));
        }
        head
    }

    fn to_vec(mut node: Option<Box<ListNode>>) -> Vec<i32> {
        let mut ret = Vec::new();
        while let Some(n) = node {
            ret.push(n.val);
            node = n.next;
        }
        ret
    }

    #[test]
    fn test_merge_two_lists() {
        let cases = [
            (vec![1, 2, 4], vec![1, 3, 4], vec![1, 1, 2, 3, 4, 4]),
            (vec![], vec![], vec![]),
            (vec![], vec![0], vec![0]),
        ];

        for (list1, list2, expected) in &cases {
            let result = Solution::merge_two_lists(to_list(list1), to_list(list2));
            assert_eq!(
                to_vec(result),
                *expected,
                "Failed with list1={:?}, list2={:?}",
                list1,
                list2
            );
        }
    }
}
