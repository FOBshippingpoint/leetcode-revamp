package s0271encodeanddecodestrings

import (
	"reflect"
	"testing"
)

type EncodeDecodeData struct {
	name string
	strs []string
}

var encodeDecodeData = []EncodeDecodeData{
	{"Should encode and decode Hello World", []string{"Hello", "World"}},
	{"Should handle empty string", []string{""}},
	{"Should handle multiple empty strings", []string{"", ""}},
	{"Should handle single element list", []string{"test"}},
	{"Should handle strings with special chars", []string{"a;b", "c;d"}},
	{"Should handle strings containing numbers", []string{"123", "456"}},
}

func TestEncodeDecodeStrings(t *testing.T) {
	s := Solution{}
	solutions := []struct {
		name   string
		encode func([]string) string
		decode func(string) []string
	}{
		{"v1", s.EncodeV1, s.DecodeV1},
		{"v2", s.EncodeV2, s.DecodeV2},
		{"v3", s.EncodeV3, s.DecodeV3},
	}

	for _, sol := range solutions {
		t.Run(sol.name, func(t *testing.T) {
			for _, d := range encodeDecodeData {
				t.Run(d.name, func(t *testing.T) {
					encoded := sol.encode(d.strs)
					decoded := sol.decode(encoded)
					if !reflect.DeepEqual(decoded, d.strs) {
						t.Errorf(`%s: strs = %v; want %v, got %v`, d.name, d.strs, d.strs, decoded)
					}
				})
			}
		})
	}
}
