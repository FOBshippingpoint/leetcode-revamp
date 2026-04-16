package s0153findminimuminrotatedsortedarray

import (
	"testing"
)

type Data struct {
	nums []int
	want int
}

var data = []Data{
	{nums: []int{3, 4, 5, 6, 1, 2}, want: 1},
	{nums: []int{4, 5, 0, 1, 2, 3}, want: 0},
	{nums: []int{4, 5, 6, 7}, want: 4},
	{nums: []int{1}, want: 1},
}

func TestFindMin(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int) int
	}{
		{"v1: Linear scan", findMinV1},
		{"v2: Binary search", findMinV2},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.nums)
				if got != d.want {
					t.Errorf(`nums = %v; want %v; got %v`, d.nums, d.want, got)
				}
			}
		})
	}
}
