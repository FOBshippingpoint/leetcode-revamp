package s0242validanagram

import (
	"slices"
)

func isAnagramV1(s string, t string) bool {
	sSlice := []rune(s)
	tSlice := []rune(t)

	slices.Sort(sSlice)
	slices.Sort(tSlice)

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
