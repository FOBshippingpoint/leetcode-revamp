package s0001twosum

func twoSumV1(nums []int, target int) []int {
	m := make(map[int]int, len(nums))
	for i, v := range nums {
		diff := target - v
		if i2, ok := m[diff]; ok {
			return []int{i2, i}
		}
		m[v] = i
	}
	return nil
}
