package s0141linkedlistcycle

import (
	"testing"
)

type Data struct {
	values []int
	pos    int
	want   bool
}

var data = []Data{
	{values: []int{3, 2, 0, -4}, pos: 1, want: true},
	{values: []int{1, 2}, pos: 0, want: true},
	{values: []int{1, 2}, pos: -1, want: false},
	{values: []int{1}, pos: -1, want: false},
	{values: []int{}, pos: -1, want: false},
}

func sliceToListWithCycle(values []int, pos int) *ListNode {
	if pos == -1 {
		return nil
	}
	var nodes []*ListNode
	for _, v := range values {
		nodes = append(nodes, &ListNode{Val: v})
	}
	for i := 0; i < len(nodes)-1; i++ {
		nodes[i].Next = nodes[i+1]
	}
	nodes[len(nodes)-1].Next = nodes[pos]

	return nodes[0]
}

func TestHasCycle(t *testing.T) {
	solutions := []struct {
		name string
		fn   func(*ListNode) bool
	}{
		{"v1: Brute force", hasCycleV1},
		{"v2: Tortoise and Hare", hasCycleV2},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				head := sliceToListWithCycle(d.values, d.pos)
				got := sol.fn(head)
				if got != d.want {
					t.Errorf("values = %v, pos = %d; want %v, got %v", d.values, d.pos, d.want, got)
				}
			}
		})
	}
}
