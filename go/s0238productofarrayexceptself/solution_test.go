package s0238productofarrayexceptself

import (
	"slices"
	"testing"
)

type Data struct {
	nums []int
	want []int
}

var data = []Data{
	{nums: []int{1, 2, 3, 4}, want: []int{24, 12, 8, 6}},
	{nums: []int{-1, 1, 0, -3, 3}, want: []int{0, 0, 9, 0, 0}},
}

func TestProductExceptSelf(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int) []int
	}{
		{"v1", productExceptSelfV1},
		{"v2", productExceptSelfV2},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.nums)

				if !slices.Equal(got, d.want) {
					t.Errorf("%s: nums = %v; want %v, got %v", sol.name, d.nums, d.want, got)
				}
			}
		})
	}
}
