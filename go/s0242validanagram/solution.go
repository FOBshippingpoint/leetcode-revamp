package s0242validanagram

import (
	"slices"
	"sort"
)

func isAnagramV1(s string, t string) bool {
	sSlice := []rune(s)
	tSlice := []rune(t)

	sort.Slice(sSlice, func(i, j int) bool {
		return sSlice[i] < sSlice[j]
	})
	sort.Slice(tSlice, func(i, j int) bool {
		return tSlice[i] < tSlice[j]
	})

	return slices.Equal(sSlice, tSlice)
}

func isAnagramV2(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	var chars ['z' + 1]int

	for _, r := range s {
		chars[r]++
	}
	for _, r := range t {
		if chars[r] == 0 {
			return false
		}
		chars[r]--
	}

	return true
}
