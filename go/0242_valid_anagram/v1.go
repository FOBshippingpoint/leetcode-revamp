package leetcode

import (
	"slices"
	"sort"
)

func isAnagram(s string, t string) bool {
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
