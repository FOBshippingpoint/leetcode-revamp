package s0033searchinrotatedsortedarray

import (
	"testing"
)

type Data struct {
	nums   []int
	target int
	want   int
}

var data = []Data{
	{nums: []int{4, 5, 6, 7, 0, 1, 2}, target: 0, want: 4},
	{nums: []int{4, 5, 6, 7, 0, 1, 2}, target: 3, want: -1},
	{nums: []int{1}, target: 0, want: -1},
	{nums: []int{1}, target: 1, want: 0},
}

func TestSearch(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int, int) int
	}{
		{"v1: Binary search", searchV1},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.nums, d.target)
				if got != d.want {
					t.Errorf(`nums = %v; target = %d; want %d, got %d`,
						d.nums, d.target, d.want, got)
				}
			}
		})
	}
}
