package validanagram

import "testing"

type Data struct {
	s    string
	t    string
	want bool
}

var data = []Data{
	{s: "anagram", t: "nagaram", want: true},
	{s: "rat", t: "car", want: false},
}

func TestIsAnagram(t *testing.T) {
	solutions := []struct {
		name string
		fn   func(string, string) bool
	}{
		{"v1: Sort and compare", isAnagramV1},
		{"v2: Use fixed size rune array as occurrences map", isAnagramV2},
	}
	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.s, d.t)
				if got != d.want {
					t.Errorf(`s = %q; t = %q; want %t got %t`, d.s, d.t, d.want, got)
				}
			}
		})
	}
}
