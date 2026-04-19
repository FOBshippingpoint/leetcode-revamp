package s0206reverselinkedlist

import (
	"slices"
	"testing"
)

type Data struct {
	head []int
	want []int
}

var data = []Data{
	{head: []int{1, 2, 3, 4, 5}, want: []int{5, 4, 3, 2, 1}},
	{head: []int{1, 2}, want: []int{2, 1}},
	{head: []int{}, want: []int{}},
}

func sliceToList(values []int) *ListNode {
	if len(values) == 0 {
		return nil
	}
	head := &ListNode{Val: values[0]}
	curr := head
	for i := 1; i < len(values); i++ {
		curr.Next = &ListNode{Val: values[i]}
		curr = curr.Next
	}
	return head
}

func listToSlice(head *ListNode) []int {
	var result []int
	curr := head
	for curr != nil {
		result = append(result, curr.Val)
		curr = curr.Next
	}
	return result
}

func TestReverseList(t *testing.T) {
	solutions := []struct {
		name string
		fn   func(*ListNode) *ListNode
	}{
		{"v1: Iterative", reverseListV1},
		{"v2: Recursive", reverseListV2},
		{"v3: Recursive tuple assignment", reverseListV3},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				head := sliceToList(d.head)
				got := sol.fn(head)
				if !slices.Equal(listToSlice(got), d.want) {
					t.Errorf(`head = %v; want %v; got %v`, d.head, d.want, listToSlice(got))
				}
			}
		})
	}
}
