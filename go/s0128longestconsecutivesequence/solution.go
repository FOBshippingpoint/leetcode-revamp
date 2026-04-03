package s0128longestconsecutivesequence

import (
	"slices"
)

func longestConsecutiveV1(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	slices.Sort(nums)

	longest := 1
	length := 1

	for i, n := range nums {
		if i+1 < len(nums) {
			if n == nums[i+1] {
				continue
			}
			if n+1 != nums[i+1] {
				length = 1
				continue
			}
		} else {
			continue
		}

		length++
		if length > longest {
			longest = length
		}
	}
	return longest
}

func longestConsecutiveV2(nums []int) int {
	set := make(map[int]struct{}, len(nums))
	for _, n := range nums {
		set[n] = struct{}{}
	}

	longest := 0
	for n := range set {
		if _, ok := set[n-1]; !ok {
			length := 0
			for {
				if _, ok := set[n+length]; ok {
					length++
				} else {
					if longest < length {
						longest = length
					}
					break
				}
			}
		}
	}
	return longest
}
