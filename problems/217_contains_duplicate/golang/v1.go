func containsDuplicate(nums []int) bool {
	m := map[int]bool{}
	for _, v := range nums {
		if _, ok := m[v]; ok {
			return true
		}
		m[v] = true
	}
	return false
}

