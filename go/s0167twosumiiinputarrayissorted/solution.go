package s0167twosumiiinputarrayissorted

func twoSum(numbers []int, target int) []int {
	head := 0
	tail := len(numbers) - 1
	for {
		sum := numbers[head] + numbers[tail]
		if sum == target {
			return []int{head + 1, tail + 1}
		} else if sum < target {
			head++
		} else if sum > target {
			tail--
		}
	}
}
