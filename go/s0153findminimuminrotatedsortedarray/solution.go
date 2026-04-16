package s0153findminimuminrotatedsortedarray

func findMinV1(nums []int) int {
	for i, n := range nums {
		if i > 0 && n < nums[i-1] {
			return n
		}
	}
	return nums[0]
}

func findMinV2(nums []int) int {
	low := 0
	high := len(nums)

	for low < high {
		mid := low + (low + high) / 2
		val := nums[mid]

	}
	for i, n := range nums {
		if i > 0 && n < nums[i-1] {
			return n
		}
	}
	return nums[0]
}
