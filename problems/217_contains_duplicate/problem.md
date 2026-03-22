# [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

## Go

### v1: ordinary int:bool map approach

Go didn't have the set data structure, so we use bool map.

### v2: faster and smaller with empty struct

Turns out that Go has a cool "empty struct" that will not take space.
