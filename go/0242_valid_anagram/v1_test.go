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
	for _, d := range data {
		result := isAnagram(d.s, d.t)
		if result != d.want {
			t.Errorf(`s = %q; t = %q; want %t got %t`, d.s, d.t, d.want, result)
		}
	}
}
