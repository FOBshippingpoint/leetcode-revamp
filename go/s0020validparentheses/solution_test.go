package s0020validparentheses

import (
	"testing"
)

type Data struct {
	s    string
	want bool
}

var data = []Data{
	{s: "()", want: true},
	{s: "()[]{}", want: true},
	{s: "(]", want: false},
	{s: "([])", want: true},
	{s: "([)]", want: false},
}

func TestIsValid(t *testing.T) {
	solutions := []struct {
		name string
		fn   func(string) bool
	}{
		{"v1: Stack", isValidV1},
		{"v2: Stack (tweak if condition to avoid unnecessary pop)", isValidV2},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.s)
				if got != d.want {
					t.Errorf(`s = %v; want %v; got %v`, d.s, d.want, got)
				}
			}
		})
	}
}
