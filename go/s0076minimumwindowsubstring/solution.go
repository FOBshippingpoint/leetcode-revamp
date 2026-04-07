package s0076minimumwindowsubstring

func minWindow(s string, t string) string {
	charCounts := make(map[rune]int, len(t))
	for _, r := range t {
		charCounts[r]++
	}

	head := 0
	matched := 0
	minLen := len(s) + 1
	minHead := 0

	for tail, tailRune := range s {
		if charCounts[tailRune] > 0 {
			matched++
		}
		charCounts[tailRune]--

		for matched == len(t) {
			curLen := tail - head + 1
			if curLen < minLen {
				minLen = curLen
				minHead = head
			}

			headRune := rune(s[head])
			charCounts[headRune]++
			if charCounts[headRune] > 0 {
				matched--
			}

			head++
		}
	}

	if minLen > len(s) {
		return ""
	}

	return s[minHead : minHead+minLen]
}
