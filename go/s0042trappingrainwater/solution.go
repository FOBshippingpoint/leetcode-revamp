package s0042trappingrainwater

func trapV1(height []int) int {
	var head = 0
	var tail = len(height) - 1
	var maxHead = height[head]
	var maxTail = height[tail]
	var area = 0

	for {
		if head >= tail {
			break
		}
		if maxHead < maxTail {
			head++
			maxHead = max(maxHead, height[head])
			area += maxHead - height[head]
		} else {
			tail--
			maxTail = max(maxTail, height[tail])
			area += maxTail - height[tail]
		}
	}
	return area
}
