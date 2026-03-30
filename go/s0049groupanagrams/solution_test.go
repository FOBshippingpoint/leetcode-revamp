package s0049groupanagrams

import (
	"reflect"
	"sort"
	"testing"
)

type Data struct {
	strs []string
	want [][]string
}

var data = []Data{
	{
		strs: []string{"eat", "tea", "tan", "ate", "nat", "bat"},
		want: [][]string{{"bat"}, {"nat", "tan"}, {"ate", "eat", "tea"}},
	},
	{
		strs: []string{""},
		want: [][]string{{""}},
	},
	{
		strs: []string{"a"},
		want: [][]string{{"a"}},
	},
}

func normalize(input [][]string) {
	for _, group := range input {
		sort.Strings(group)
	}
	sort.Slice(input, func(i, j int) bool {
		if len(input[i]) == 0 {
			return true
		}
		if len(input[j]) == 0 {
			return false
		}
		return input[i][0] < input[j][0]
	})
}

func TestGroupAnagrams(t *testing.T) {
	solutions := []struct {
		name string
		fn   func(strs []string) [][]string
	}{
		{"v1: map with array occurrences key and group strings value", groupAnagramsV1},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.strs)

				normalize(got)
				normalize(d.want)

				if !reflect.DeepEqual(got, d.want) {
					t.Errorf(`strs = %v; want %v, got %v`, d.strs, d.want, got)
				}
			}
		})
	}
}
