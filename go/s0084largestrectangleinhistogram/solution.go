package s0084largestrectangleinhistogram

func largestRectangleAreaV1(heights []int) int {
	maxArea := 0
	stack := make([][]int, 0, len(heights))

	var start int
	for i, h := range heights {
		start = i
		for len(stack) > 0 && stack[len(stack)-1][1] > h {
			last := stack[len(stack)-1]
			lastIndex := last[0]
			lastHeight := last[1]
			maxArea = max(maxArea, lastHeight*(i-lastIndex))
			start = lastIndex
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, []int{start, h})
	}

	for _, last := range stack {
		i := last[0]
		h := last[1]
		maxArea = max(maxArea, h*(len(heights)-i))
	}
	return maxArea
}

type pair struct {
	index  int
	height int
}

func largestRectangleAreaV2(heights []int) int {
	maxArea := 0
	stack := make([]pair, 0, len(heights))

	for i, h := range heights {
		start := i
		for len(stack) > 0 && stack[len(stack)-1].height > h {
			last := stack[len(stack)-1]
			stack = stack[:len(stack)-1]

			maxArea = max(maxArea, last.height*(i-last.index))
			start = last.index
		}
		stack = append(stack, pair{start, h})
	}

	n := len(heights)
	for _, p := range stack {
		maxArea = max(maxArea, p.height*(n-p.index))
	}

	return maxArea
}

func largestRectangleAreaV3(heights []int) int {
	maxArea := 0
	stack := make([]int, 0, len(heights))
	heights = append(heights, 0) // Add a dummy height at far right to prevent second loop for cleaning up stack

	for i, h := range heights {
		for len(stack) > 0 && heights[stack[len(stack)-1]] > h {
			poppedHeight := heights[stack[len(stack)-1]]
			stack = stack[:len(stack)-1]

			width := i
			if len(stack) > 0 {
				width = i - stack[len(stack)-1] - 1
			}
			maxArea = max(maxArea, poppedHeight*width)
		}
		stack = append(stack, i)
	}
	return maxArea
}
