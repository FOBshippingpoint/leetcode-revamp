package s0033searchinrotatedsortedarray

func searchV1(nums []int, target int) int {
	left, right := 0, len(nums)-1

	for left <= right {
		mid := left + (right-left)/2
		val := nums[mid]

		if val == target {
			return mid
		}

		if val <= nums[right] {
			// Right half
			if val < target && target <= nums[right] {
				left = mid + 1
			} else {
				right = mid - 1
			}
		} else {
			// Left-half
			if nums[left] < target && target <= val {
				right = mid - 1
			} else {
				left = mid + 1
			}
		}
	}

	return -1
}
