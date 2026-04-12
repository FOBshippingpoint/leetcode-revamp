package s0074searcha2dmatrix

func searchMatrixV1(matrix [][]int, target int) bool {
	rows := len(matrix)
	cols := len(matrix[0])

	low := 0
	high := rows * cols
	for low < high {
		mid := low + (high-low)/2
		val := matrix[mid/cols][mid%cols]

		if val < target {
			low = mid + 1
		} else if val > target {
			high = mid
		} else {
			return true
		}
	}

	return false
}
