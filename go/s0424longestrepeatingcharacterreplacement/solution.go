package s0424longestrepeatingcharacterreplacement

func characterReplacementV1(s string, k int) int {
	head := 0
	freqMap := make(map[byte]int, 26)
	longest := 0
	maxFreq := 0

	for tail := 0; tail < len(s); tail++ {
		freqMap[s[tail]]++
		maxFreq = max(maxFreq, freqMap[s[tail]])
		for (tail-head+1)-maxFreq > k {
			freqMap[s[head]]--
			head++
		}
		longest = max(longest, tail-head+1)
	}
	return longest
}
