package s0347topkfrequentelements

func topKFrequentV1(nums []int, k int) []int {
	m := map[int]int{}
	for _, num := range nums {
		m[num]++
	}

	buckets := make([][]int, len(nums)+1)
	for num, freq := range m {
		buckets[freq] = append(buckets[freq], num)
	}

	ret := []int{}
	for i := len(buckets) - 1; i >= 0 && len(ret) < k; i-- {
		if len(buckets[i]) > 0 {
			ret = append(ret, buckets[i]...)
		}
	}
	return ret[:k]
}

func topKFrequentV2(nums []int, k int) []int {
	m := map[int]int{}
	for _, num := range nums {
		m[num]++
	}

	buckets := make([][]int, len(nums)+1)
	for num, freq := range m {
		buckets[freq] = append(buckets[freq], num)
	}

	ret := make([]int, 0, k)
	for i := len(buckets) - 1; i >= 0 && len(ret) < k; i-- {
		if len(buckets[i]) > 0 {
			ret = append(ret, buckets[i]...)
		}
	}
	return ret
}
