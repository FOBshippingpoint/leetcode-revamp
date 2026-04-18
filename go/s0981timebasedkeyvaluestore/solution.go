package s0981timebasedkeyvaluestore

/**
 * Your TimeMap object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Set(key,value,timestamp);
 * param_2 := obj.Get(key,timestamp);
 */

type TimeMapV1 struct {
	store map[string][]TimeCapsule
}

type TimeCapsule struct {
	value     string
	timestamp int
}

func ConstructorV1() TimeMapV1 {
	return TimeMapV1{
		make(map[string][]TimeCapsule),
	}
}

func (this *TimeMapV1) Set(key string, value string, timestamp int) {
	this.store[key] = append(this.store[key], TimeCapsule{value, timestamp})
}

func (this *TimeMapV1) Get(key string, timestamp int) string {
	ret := ""
	if values, ok := this.store[key]; ok {
		low, high := 0, len(values)
		for low < high {
			mid := low + (high-low)/2
			if values[mid].timestamp <= timestamp {
				ret = values[mid].value
				low = mid + 1
			} else {
				high = mid
			}
		}
	}
	return ret
}

type TimeMapV2 struct {
	store map[string]*TimeSeries
}

type TimeSeries struct {
	values     []string
	timestamps []int
}

func ConstructorV2() TimeMapV2 {
	return TimeMapV2{
		make(map[string]*TimeSeries),
	}
}

func (this *TimeMapV2) Set(key string, value string, timestamp int) {
	series, ok := this.store[key]
	if !ok {
		series = &TimeSeries{}
		this.store[key] = series
	}
	series.values = append(series.values, value)
	series.timestamps = append(series.timestamps, timestamp)
}

func (this *TimeMapV2) Get(key string, timestamp int) string {
	ret := ""
	if series, ok := this.store[key]; ok {
		low, high := 0, len(series.values)
		for low < high {
			mid := low + (high-low)/2
			if series.timestamps[mid] <= timestamp {
				ret = series.values[mid]
				low = mid + 1
			} else {
				high = mid
			}
		}
	}
	return ret
}
