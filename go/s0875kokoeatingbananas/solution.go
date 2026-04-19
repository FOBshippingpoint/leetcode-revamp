package s0875kokoeatingbananas

import "slices"

func minEatingSpeedV1(piles []int, h int) int {
	low := 1
	high := slices.Max(piles)

	for low < high {
		k := low + (high-low)/2
		tot := 0

		for _, p := range piles {
			tot += (p + k - 1) / k // Equals to ceil(p/k)
		}

		if tot <= h {
			high = k
		} else {
			low = k + 1
		}
	}
	return low
}

// / Actually not faster
func minEatingSpeedV2(piles []int, h int) int {
	low := 1
	high := slices.Max(piles)

	for low < high {
		k := low + (high-low)/2
		tot := 0

		for _, p := range piles {
			tot += (p + k - 1) / k
			if tot > h {
				break
			}
		}

		if tot <= h {
			high = k
		} else {
			low = k + 1
		}
	}
	return low
}
