package s0150evaluatereversepolishnotation

import (
	"testing"
)

type Data struct {
	tokens []string
	want   int
}

var data = []Data{
	{tokens: []string{"2", "1", "+", "3", "*"}, want: 9},
	{tokens: []string{"4", "13", "5", "/", "+"}, want: 6},
	{tokens: []string{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, want: 22},
}

func TestEvalRPN(t *testing.T) {
	solutions := []struct {
		name string
		fn   func([]string) int
	}{
		{"v1: Stack", evalRPNV1},
		{"v2: Use ?=", evalRPNV2},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.tokens)
				if got != d.want {
					t.Errorf(`tokens = %v; want %v; got %v`, d.tokens, d.want, got)
				}
			}
		})
	}
}
