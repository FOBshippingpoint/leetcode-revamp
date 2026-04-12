package s0074searcha2dmatrix

import (
	"testing"
)

type Data struct {
	matrix [][]int
	target int
	want   bool
}

var data = []Data{
	{matrix: [][]int{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, target: 3, want: true},
	{matrix: [][]int{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, target: 13, want: false},
}

func TestSearchMatrix(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([][]int, int) bool
	}{
		{"v1: Binary search", searchMatrixV1},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.matrix, d.target)
				if got != d.want {
					t.Errorf(`target = %v; want %v; got %v`, d.target, d.want, got)
				}
			}
		})
	}
}
