package s0036validsudoku

import (
	"strings"
	"testing"
)

/// To make the board looks good
func formatBoard(board [][]byte) string {
	var sb strings.Builder
	for _, row := range board {
		for _, c := range row {
			sb.WriteByte(c)
			sb.WriteString(" ")
		}
		sb.WriteString("\n")
	}
	return sb.String()
}

type Data struct {
	board [][]byte
	want  bool
}

var data = []Data{
	{
		board: [][]byte{
			{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
		},
		want: true,
	},
	{
		board: [][]byte{
			{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
		},
		want: false,
	},
}

func TestIsValidSudoku(t *testing.T) {
	solutions := []struct {
		name string
		fn   func(board [][]byte) bool
	}{
		{"v1", isValidSudokuV1},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range data {
				got := sol.fn(d.board)
				if got != d.want {
					t.Errorf(`board:
%s
want %v, got %v`,
						formatBoard(d.board), d.want, got)
				}
			}
		})
	}
}
