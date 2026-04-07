package s0020validparentheses

func isValidV1(s string) bool {
	stack := []rune{}
	brackets := map[rune]rune{
		'(': ')',
		'{': '}',
		'[': ']',
	}

	for _, r := range s {
		switch r {
		case '(', '{', '[':
			stack = append(stack, r)
		case ')', '}', ']':
			if len(stack) == 0 {
				return false
			}
			pop := stack[len(stack)-1]
			stack = stack[:len(stack)-1]
			if r != brackets[pop] {
				return false
			}
		}
	}
	return len(stack) == 0
}
