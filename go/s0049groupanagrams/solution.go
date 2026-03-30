package s0049groupanagrams

func groupAnagramsV1(strs []string) [][]string {
	groups := map[['z' + 1]int][]string{}

	for _, s := range strs {
		var count ['z' + 1]int
		for _, r := range s {
			count[r]++
		}
		groups[count] = append(groups[count], s)
	}

	ret := make([][]string, len(groups))
	i := 0
	for _, group := range groups {
		ret[i] = group
		i++
	}

	return ret
}
