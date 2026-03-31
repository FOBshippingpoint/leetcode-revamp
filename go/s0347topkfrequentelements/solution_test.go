package s0347topkfrequentelements

import (
	"slices"
	"sort"
	"testing"
)

type Data struct {
	nums []int
	k    int
	want []int
}

var data = []Data{
	{nums: []int{1, 1, 1, 2, 2, 3}, k: 2, want: []int{1, 2}},
	{nums: []int{1}, k: 1, want: []int{1}},
	{nums: []int{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, k: 2, want: []int{1, 2}},
}

func TestTopKFrequent(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int, int) []int
	}{
		{"v1: bucket sort", topKFrequentV1},
		{"v2: bucket sort make exact capacity", topKFrequentV2},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.nums, d.k)

				sort.Ints(got)
				sort.Ints(d.want)

				if !slices.Equal(got, d.want) {
					t.Errorf("%s: nums = %v, k = %d; want %v, got %v", sol.name, d.nums, d.k, d.want, got)
				}
			}
		})
	}
}
