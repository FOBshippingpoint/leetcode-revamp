package s0150evaluatereversepolishnotation

import (
	"strconv"
)

func evalRPNV1(tokens []string) int {
	stack := make([]int, 0, len(tokens)/2+1)

	for _, token := range tokens {
		switch token {
		case "+", "-", "*", "/":
			n := len(stack)
			left, right := stack[n-2], stack[n-1]
			// Pop "right"
			stack = stack[:len(stack)-1]

			switch token {
			case "+":
				stack[n-2] = left + right
			case "-":
				stack[n-2] = left - right
			case "*":
				stack[n-2] = left * right
			case "/":
				stack[n-2] = left / right
			}
		default:
			num, err := strconv.Atoi(token)
			if err != nil {
				panic("Noop")
			}
			stack = append(stack, num)
		}
	}
	return stack[0]
}

func evalRPNV2(tokens []string) int {
	stack := make([]int, 0, len(tokens)/2+1)

	for _, token := range tokens {
		switch token {
		case "+", "-", "*", "/":
			n := len(stack)
			right := stack[n-1]
			stack = stack[:n-1]

			switch token {
			case "+":
				stack[n-2] += right
			case "-":
				stack[n-2] -= right
			case "*":
				stack[n-2] *= right
			case "/":
				stack[n-2] /= right
			}
		default:
			// Just use _ here to omit the error (to avoid unused variable error)
			num, _ := strconv.Atoi(token)
			stack = append(stack, num)
		}
	}
	return stack[0]
}
