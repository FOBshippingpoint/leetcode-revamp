package s0011containerwithmostwater

import (
	"testing"
)

type Data struct {
	height []int
	want   int
}

var data = []Data{
	{height: []int{1, 8, 6, 2, 5, 4, 8, 3, 7}, want: 49},
	{height: []int{1, 1}, want: 1},
}

func TestMaxArea(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int) int
	}{
		{"v1: Two pointer", maxArea},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.height)
				if got != d.want {
					t.Errorf(`height = %v; want %v; got %v`, d.height, d.want, got)
				}
			}
		})
	}
}
