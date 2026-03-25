package leetcode

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
		{"V1 (Brute Force)", isAnagramV1},
		{"V2 (Hash Map)", isAnagramV2},
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
