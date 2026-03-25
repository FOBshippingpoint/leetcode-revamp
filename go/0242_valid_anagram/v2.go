package leetcode

func isAnagramV2(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	var chars ['z' + 1]int

	for _, r := range s {
		chars[r]++
	}
	for _, r := range t {
		if chars[r] == 0 {
			return false
		}
		chars[r]--
	}

	return true
}
