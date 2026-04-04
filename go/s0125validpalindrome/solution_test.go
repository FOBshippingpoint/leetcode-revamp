package s0125validpalindrome

import (
	"testing"
)

type Data struct {
	s    string
	want bool
}

var data = []Data{
	{s: "A man, a plan, a canal: Panama", want: true},
	{s: "race a car", want: false},
	{s: " ", want: true},
}

func TestIsPalindrome(t *testing.T) {
	solutions := []struct {
		name string
		fn   func(string) bool
	}{
		{"v1", isPalindromeV1},
		{"v2", isPalindromeV2},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.s)
				if got != d.want {
					t.Errorf(`s = %q; want %v, got %v`, d.s, d.want, got)
				}
			}
		})
	}
}
