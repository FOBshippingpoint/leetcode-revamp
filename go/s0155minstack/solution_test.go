package s0155minstack

import (
	"testing"
)

func TestMinStackV1(t *testing.T) {
	obj := ConstructorV1()
	obj.PushV1(-2)
	obj.PushV1(0)
	obj.PushV1(-3)

	if got := obj.GetMinV1(); got != -3 {
		t.Errorf("GetMinV1() = %v, want -3", got)
	}

	obj.PopV1()

	if got := obj.TopV1(); got != 0 {
		t.Errorf("TopV1() = %v, want 0", got)
	}

	if got := obj.GetMinV1(); got != -2 {
		t.Errorf("GetMinV1() = %v, want -2", got)
	}
}

func TestMinStackV2(t *testing.T) {
	obj := ConstructorV2()
	obj.PushV2(-2)
	obj.PushV2(0)
	obj.PushV2(-3)

	if got := obj.GetMinV2(); got != -3 {
		t.Errorf("GetMinV2() = %v, want -3", got)
	}

	obj.PopV2()

	if got := obj.TopV2(); got != 0 {
		t.Errorf("TopV2() = %v, want 0", got)
	}

	if got := obj.GetMinV2(); got != -2 {
		t.Errorf("GetMinV2() = %v, want -2", got)
	}
}
