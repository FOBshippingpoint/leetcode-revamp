package s0217containsduplicate

import "testing"

type Data struct {
	nums []int
	want bool
}

var data = []Data{
	{[]int{1, 2, 3, 1}, true},
	{[]int{1, 2, 3, 4}, false},
	{[]int{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true},
}

func TestIsAnagram(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]int) bool
	}{
		{"v1: Bool map as set", containsDuplicateV1},
		{"v2: Empty struct map as set", containsDuplicateV2},
	}
	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.nums)
				if got != d.want {
					t.Errorf(`nums = %v; want %t got %t`, d.nums, d.want, got)
				}
			}
		})
	}
}
