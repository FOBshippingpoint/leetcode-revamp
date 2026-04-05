package s0042trappingrainwater

import (
	"testing"
)

type Data struct {
	height []int
	want   int
}

var data = []Data{
	{height: []int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, want: 6},
	{height: []int{4, 2, 0, 3, 2, 5}, want: 9},
	{height: []int{0, 2, 0, 3, 1, 0, 1, 3, 2, 1}, want: 9},
}

func TestTrap(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int) int
	}{
		{"v1: Two pointer", trapV1},
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
