package s0036validsudoku

func isValidSudokuV1(board [][]byte) bool {
	var rows [9][9]bool
	var cols [9][9]bool
	var blocks [9][9]bool

	for r := range 9 {
		for c := range 9 {
			if board[r][c] == '.' {
				continue
			}

			val := board[r][c] - '1'
			blockKey := r/3*3 + c/3

			if rows[r][val] || cols[c][val] || blocks[blockKey][val] {
				return false
			}
			rows[r][val] = true
			cols[c][val] = true
			blocks[blockKey][val] = true
		}
	}
	return true
}
