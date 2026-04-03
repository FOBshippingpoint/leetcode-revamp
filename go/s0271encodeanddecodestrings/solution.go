package s0271encodeanddecodestrings

import (
	"fmt"
	"strconv"
	"strings"
)

type Solution struct{}

func (s *Solution) EncodeV1(strs []string) string {
	if len(strs) == 0 {
		return "無"
	}
	return strings.Join(strs, "切")
}

func (s *Solution) DecodeV1(str string) []string {
	if str == "無" {
		return []string{}
	}
	return strings.Split(str, "切")
}

func (s *Solution) EncodeV2(strs []string) string {
	var b strings.Builder
	for _, s := range strs {
		b.WriteString(strconv.Itoa(len(s)))
		b.WriteByte(';')
		b.WriteString(s)
	}
	return b.String()
}

func (s *Solution) DecodeV2(str string) []string {
	var result []string
	start := 0
	for i := 0; i < len(str); i++ {
		if str[i] == ';' {
			length, _ := strconv.Atoi(str[start:i])
			start = i + 1
			result = append(result, str[start:start+length])
			start += length
			i = start - 1
		}
	}
	return result
}

func (s *Solution) EncodeV3(strs []string) string {
	var b strings.Builder
	for _, s := range strs {
		fmt.Fprintf(&b, "%03d", len(s))
		b.WriteString(s)
	}
	return b.String()
}

func (s *Solution) DecodeV3(str string) []string {
	var result []string
	start := 0
	for start < len(str) {
		length, _ := strconv.Atoi(str[start : start+3])
		start += 3
		result = append(result, str[start:start+length])
		start += length
	}
	return result
}
