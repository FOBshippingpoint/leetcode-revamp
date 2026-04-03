package s0238productofarrayexceptself

import "slices"

func productExceptSelfV1(nums []int) []int {
	result := make([]int, len(nums))

	prefix := 1
	for i, num := range nums {
		result[i] = prefix
		prefix *= num
	}

	postfix := 1
	for i, num := range slices.Backward(nums) {
		result[i] *= postfix
		postfix *= num
	}

	return result
}

/// v2 uses the normal backward for loop instead of slices.Backward.
/// The speed is slightly slower but use less memory.
func productExceptSelfV2(nums []int) []int {
	result := make([]int, len(nums))

	prefix := 1
	for i, num := range nums {
		result[i] = prefix
		prefix *= num
	}

	postfix := 1
	for j := len(nums) - 1; j >= 0; j-- {
		result[j] *= postfix
		postfix *= nums[j]
	}

	return result
}
