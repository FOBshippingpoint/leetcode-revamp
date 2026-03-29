package s0217containsduplicate

func containsDuplicateV1(nums []int) bool {
	m := map[int]bool{}
	for _, v := range nums {
		if _, ok := m[v]; ok {
			return true
		}
		m[v] = true
	}
	return false
}

func containsDuplicateV2(nums []int) bool {
	m := make(map[int]struct{}, len(nums))
	for _, v := range nums {
		if _, ok := m[v]; ok {
			return true
		}
		m[v] = struct{}{}
	}
	return false
}
