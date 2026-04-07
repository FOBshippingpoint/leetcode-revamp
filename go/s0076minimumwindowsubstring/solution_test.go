package s0076minimumwindowsubstring

import (
	"testing"
)

type Data struct {
	s    string
	t    string
	want string
}

var data = []Data{
	{s: "ADOBECODEBANC", t: "ABC", want: "BANC"},
	{s: "a", t: "a", want: "a"},
	{s: "a", t: "aa", want: ""},
	{s: "OUZODYXAZV", t: "XYZ", want: "YXAZ"},
	{s: "xyz", t: "xyz", want: "xyz"},
	{s: "x", t: "xy", want: ""},
}

func TestMinWindow(t *testing.T) {
	solutions := []struct {
		name string
		fn   func(string, string) string
	}{
		{"v1: Sliding window", minWindow},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.s, d.t)
				if got != d.want {
					t.Errorf(`s = %v; t = %v; want %v; got %v`, d.s, d.t, d.want, got)
				}
			}
		})
	}
}
