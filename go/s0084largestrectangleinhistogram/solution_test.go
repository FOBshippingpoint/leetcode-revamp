package s0084largestrectangleinhistogram

import (
	"testing"
)

type Data struct {
	heights []int
	want    int
}

var data = []Data{
	{heights: []int{2, 1, 5, 6, 2, 3}, want: 10},
	{heights: []int{2, 4}, want: 4},
}

func TestLargestRectangleArea(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int) int
	}{
		{"v1: 2D slices stack", largestRectangleAreaV1},
		{"v2: struct stack", largestRectangleAreaV2},
		{"v3: index-only stack", largestRectangleAreaV3},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.heights)
				if got != d.want {
					t.Errorf(`heights = %v; want %v; got %v`, d.heights, d.want, got)
				}
			}
		})
	}
}
