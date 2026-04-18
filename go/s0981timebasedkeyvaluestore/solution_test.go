package s0981timebasedkeyvaluestore

import "testing"

type TimeMapper interface {
	Set(key, value string, timestamp int)
	Get(key string, timestamp int) string
}

type operation struct {
	method string
	key    string
	value  string
	time   int
	want   string
}

func TestTimeMap(t *testing.T) {
	ops := []operation{
		{"set", "foo", "bar", 1, ""},
		{"get", "foo", "", 1, "bar"},
		{"get", "foo", "", 3, "bar"},
		{"set", "foo", "bar2", 4, ""},
		{"get", "foo", "", 4, "bar2"},
		{"get", "foo", "", 5, "bar2"},
	}

	impls := []struct {
		name    string
		factory func() TimeMapper
	}{
		{
			"v1: slice in struct",
			func() TimeMapper {
				v := ConstructorV1()
				return &v
			},
		},
		{
			"v2: parallel slices",
			func() TimeMapper {
				v := ConstructorV2()
				return &v
			},
		},
	}

	for _, impl := range impls {
		t.Run(impl.name, func(t *testing.T) {
			tm := impl.factory()

			for i, op := range ops {
				switch op.method {
				case "set":
					tm.Set(op.key, op.value, op.time)
				case "get":
					got := tm.Get(op.key, op.time)
					if got != op.want {
						t.Errorf("step %d (get %s @ %d): want %q, got %q",
							i, op.key, op.time, op.want, got)
					}
				}
			}
		})
	}
}
