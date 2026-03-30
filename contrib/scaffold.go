package main

import (
	"flag"
	"fmt"
	"log"
	"net/url"
	"os"
	"path/filepath"
	"strings"
)

func main() {
	titlePtr := flag.String("title", "", "Title of a LeetCode problem (e.g., '1. Two Sum')")
	urlPtr := flag.String("url", "", "URL of the LeetCode problem")
	flag.Parse()

	if *titlePtr == "" {
		log.Fatal("-title is required")
	}
	if *urlPtr == "" {
		log.Fatal("-url is required")
	}

	pkgName := craftPkgName(*titlePtr)
	dirPath := filepath.Join("go", pkgName)

	if err := os.MkdirAll(dirPath, 0755); err != nil {
		log.Fatalf("Failed to create directory: %v", err)
	}

	if _, err := url.Parse(*urlPtr); err != nil {
		log.Fatal("URL is invalid:", err)
	}
	notePath := filepath.Join(dirPath, "note.md")
	if _, err := os.Stat(notePath); os.IsNotExist(err) {
		if err := os.WriteFile(notePath, []byte(craftNoteMd(*titlePtr, *urlPtr)+"\n"), 0644); err != nil {
			log.Fatalf("Failed to write note.md: %v", err)
		}
	}

	solutionPath := filepath.Join(dirPath, "solution.go")
	if _, err := os.Stat(solutionPath); os.IsNotExist(err) {
		if err := os.WriteFile(solutionPath, fmt.Appendf(nil, "package %s\n\nfunc __solution__() {\n}\n", pkgName), 0644); err != nil {
			log.Fatalf("Failed to write solution.go: %v", err)
		}
	}

	testPath := filepath.Join(dirPath, "solution_test.go")
	if _, err := os.Stat(testPath); os.IsNotExist(err) {
		if err := os.WriteFile(testPath, fmt.Appendf(nil, "package %s\n\nimport (\n\t\"testing\"\n)\n\nfunc Test__solution__(t *testing.T) {\n}\n", pkgName), 0644); err != nil {
			log.Fatalf("Failed to write solution_test.go: %v", err)
		}
	}

	fmt.Printf("Created: %s/\n", dirPath)
}

func craftNoteMd(title string, urlStr string) string {
	return fmt.Sprintf("[%s](%s)", title, urlStr)
}

func craftPkgName(title string) string {
	num, titleNoNum, _ := strings.Cut(title, ".")
	num = fmt.Sprintf("%04s", num)
	titleNoNumNormalized := strings.ToLower(strings.ReplaceAll(strings.TrimSpace(titleNoNum), " ", ""))
	return "s" + num + titleNoNumNormalized
}
