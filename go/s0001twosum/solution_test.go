package s0001twosum

import (
	"reflect"
	"testing"
)

type Data struct {
	nums   []int
	target int
	want   []int
}

var data = []Data{
	{nums: []int{2, 7, 11, 15}, target: 9, want: []int{0, 1}},
	{nums: []int{3, 2, 4}, target: 6, want: []int{1, 2}},
	{nums: []int{3, 3}, target: 6, want: []int{0, 1}},
}

func TestTwoSum(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int, int) []int
	}{
		{"v1: Brute force or Hash map", twoSumV1},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.nums, d.target)
				if !reflect.DeepEqual(got, d.want) {
					t.Errorf(`nums = %v; target = %d; want %v, got %v`,
						d.nums, d.target, d.want, got)
				}
			}
		})
	}
}
