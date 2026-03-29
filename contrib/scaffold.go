package main

import (
	"flag"
	"fmt"
	"os"
	"path/filepath"
	"strings"
)

func main() {
	url := flag.String("url", "", "URL of a LeetCode problem")
	title := flag.String("title", "", "Title of a LeetCode problem")

	flag.Parse()

	num, titleNoNum, _ := strings.Cut(*title, ".")
	num = fmt.Sprintf("%04d", num)
	titleNoNumNormalized := strings.ReplaceAll(strings.TrimSpace(titleNoNum), " ", "")
	packageName := "s" + num + titleNoNumNormalized

	os.MkdirAll()
}
