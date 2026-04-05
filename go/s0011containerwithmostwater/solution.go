package s0011containerwithmostwater

func maxArea(height []int) int {
	head := 0
	tail := len(height) - 1
	biggest := 0

	for {
		if head >= tail {
			return biggest
		}
		headH := height[head]
		tailH := height[tail]
		area := (tail - head) * min(headH, tailH)
		if area > biggest {
			biggest = area
		}
		if headH <= tailH {
			head++
		} else {
			tail--
		}
	}
}
