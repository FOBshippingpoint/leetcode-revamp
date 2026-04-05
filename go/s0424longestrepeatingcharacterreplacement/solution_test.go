package s0424longestrepeatingcharacterreplacement

import (
	"testing"
)

type Data struct {
	s    string
	k    int
	want int
}

var data = []Data{
	{s: "ABAB", k: 2, want: 4},
	{s: "AABABBA", k: 1, want: 4},
}

func TestCharacterReplacement(t *testing.T) {
	solutions := []struct {
		name string
		fn   func(string, int) int
	}{
		{"v1: Sliding window", characterReplacementV1},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.s, d.k)
				if got != d.want {
					t.Errorf(`s = %v; k = %d; want %v; got %v`, d.s, d.k, d.want, got)
				}
			}
		})
	}
}
