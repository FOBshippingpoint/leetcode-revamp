package s0125validpalindrome

import (
	"regexp"
	"strings"
	"unicode"
)

func isPalindromeV1(s string) bool {
	head := 0
	tail := len(s) - 1

	for {
		if head >= tail {
			break
		}
		headR := rune(s[head])
		tailR := rune(s[tail])
		if !unicode.IsLetter(headR) && !unicode.IsDigit(headR) {
			head++
			continue
		}
		if !unicode.IsLetter(tailR) && !unicode.IsDigit(tailR) {
			tail--
			continue
		}
		if unicode.ToLower(headR) != unicode.ToLower(tailR) {
			return false
		}
		head++
		tail--
	}
	return true
}

func isPalindromeV2(s string) bool {
	re := regexp.MustCompile("[^[:alnum:]]")
	s = re.ReplaceAllString(strings.ToLower(s), "")
	for i, r := range s {
		if byte(r) != s[len(s)-i-1] {
			return false
		}
	}
	return true
}
