package s0155minstack

import "math"

type MinStackV1 struct {
	stack, minStack []int
}

func ConstructorV1() MinStackV1 {
	return MinStackV1{[]int{}, []int{}}
}

func (this *MinStackV1) PushV1(val int) {
	this.stack = append(this.stack, val)
	if len(this.minStack) == 0 || val < this.GetMinV1() {
		this.minStack = append(this.minStack, val)
	} else {
		this.minStack = append(this.minStack, this.GetMinV1())
	}
}

func (this *MinStackV1) PopV1() {
	this.stack = this.stack[:len(this.stack)-1]
	this.minStack = this.minStack[:len(this.minStack)-1]
}

func (this *MinStackV1) TopV1() int {
	return this.stack[len(this.stack)-1]
}

func (this *MinStackV1) GetMinV1() int {
	return this.minStack[len(this.minStack)-1]
}

type MinStackV2 struct {
	stack  []int
	minVal int
}

func ConstructorV2() MinStackV2 {
	return MinStackV2{[]int{}, math.MaxInt}
}

func (this *MinStackV2) PushV2(val int) {
	if val <= this.minVal {
		this.stack = append(this.stack, this.minVal)
		this.minVal = val
	}
	this.stack = append(this.stack, val)
}

func (this *MinStackV2) PopV2() {
	last := this.TopV2()
	this.stack = this.stack[:len(this.stack)-1]
	if last == this.minVal {
		this.minVal = this.TopV2()
		this.stack = this.stack[:len(this.stack)-1]
	}
}

func (this *MinStackV2) TopV2() int {
	return this.stack[len(this.stack)-1]
}

func (this *MinStackV2) GetMinV2() int {
	return this.minVal
}
