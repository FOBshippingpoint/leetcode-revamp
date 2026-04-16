package s0875kokoeatingbananas

import (
	"testing"
)

type Data struct {
	piles []int
	h     int
	want  int
}

var data = []Data{
	{piles: []int{3, 6, 7, 11}, h: 8, want: 4},
	{piles: []int{30, 11, 23, 4, 20}, h: 5, want: 30},
	{piles: []int{30, 11, 23, 4, 20}, h: 6, want: 23},
}

func TestMinEatingSpeed(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int, int) int
	}{
		{"v1: Binary search", minEatingSpeedV1},
		{"v1: Binary search early return", minEatingSpeedV2},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.piles, d.h)
				if got != d.want {
					t.Errorf(`piles = %v; h = %d; want %v; got %v`, d.piles, d.h, d.want, got)
				}
			}
		})
	}
}
