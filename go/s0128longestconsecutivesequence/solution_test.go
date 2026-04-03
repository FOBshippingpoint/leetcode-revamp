package s0128longestconsecutivesequence

import (
	"slices"
	"testing"
)

type Data struct {
	nums []int
	want int
}

var data = []Data{
	{
		nums: []int{100, 4, 200, 1, 3, 2},
		want: 4,
	},
	{
		nums: []int{0, 3, 7, 2, 5, 8, 4, 6, 0, 1},
		want: 9,
	},
	{
		nums: []int{1, 0, 1, 2},
		want: 3,
	},
	{
		nums: []int{},
		want: 0,
	},
}

func TestLongestConsecutive(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int) int
	}{
		{"v1", longestConsecutiveV1},
		{"v2", longestConsecutiveV2},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				nums := slices.Clone(d.nums)
				got := sol.fn(nums)
				if got != d.want {
					t.Errorf(`nums = %v; want %v, got %v`,
						d.nums, d.want, got)
				}
			}
		})
	}
}
