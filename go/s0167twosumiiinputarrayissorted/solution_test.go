package s0167twosumiiinputarrayissorted

import (
	"reflect"
	"testing"
)

type Data struct {
	numbers []int
	target  int
	want    []int
}

var data = []Data{
	{numbers: []int{2, 7, 11, 15}, target: 9, want: []int{1, 2}},
	{numbers: []int{2, 3, 4}, target: 6, want: []int{1, 3}},
	{numbers: []int{-1, 0}, target: -1, want: []int{1, 2}},
}

func TestTwoSum(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int, int) []int
	}{
		{"v1", twoSum},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.numbers, d.target)
				if !reflect.DeepEqual(got, d.want) {
					t.Errorf(`numbers = %v; target = %d; want %v, got %v`,
						d.numbers, d.target, d.want, got)
				}
			}
		})
	}
}
