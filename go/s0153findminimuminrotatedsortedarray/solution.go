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
	left, right := 0, len(nums)-1

	for left < right {
		mid := left + (right-left)/2
		if nums[mid] < nums[right] {
			// mid is on the SMALLER segment, move left
			right = mid
		} else {
			// mid is on the LARGER segment, move right
			left = mid + 1
		}
	}
	return nums[left]
}
