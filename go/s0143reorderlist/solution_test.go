package s0143reorderlist

import (
	"slices"
	"testing"
)

type Data struct {
	head []int
	want []int
}

var data = []Data{
	{head: []int{1, 2, 3, 4}, want: []int{1, 4, 2, 3}},
	{head: []int{1, 2, 3, 4, 5}, want: []int{1, 5, 2, 4, 3}},
	{head: []int{1}, want: []int{1}},
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

func TestReorderList(t *testing.T) {
	solutions := []struct {
		name string
		fn   func(*ListNode)
	}{
		{"v1: Reverse copy", reorderListV1},
		{"v2: Split, reverse, merge", reorderListV2},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				head := sliceToList(d.head)
				sol.fn(head)
				if !slices.Equal(listToSlice(head), d.want) {
					t.Errorf(`head = %v; want %v; got %v`, d.head, d.want, listToSlice(head))
				}
			}
		})
	}
}
