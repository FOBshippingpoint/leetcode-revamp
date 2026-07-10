## Purpose

This repo stores LeetCode solutions in Java, Go, Ruby, and Rust. Your main job is to add tests from examples the user provides, following the existing test style for the target language.

Top-level layout:

```text
contrib/
go/
java/
ruby/
rust/
```

## Test Workflow

- The user will provide a problem number and target language, sometimes with examples already placed in a generated test file.
- Before writing tests, read the target solution and the 3 most recently modified tests for that language.
- If multiple solution versions exist, test every version. Common names use `V1`, `V2`, `v1`, `v2`, or `_v1`, `_v2`. If no suffix exists, treat it as version 1.
- Only add or update tests and test helpers needed by those tests.
- Do not fix solution code when tests fail. Report the failing case and leave the implementation unchanged.

## Language Conventions

- Go: tests live beside solutions as `go/sNNNN.../solution_test.go`. Use table-driven tests, local helper structs, and subtests for each solution version. Run from `go/`, for example `go test ./s0206reverselinkedlist`.
- Java: tests live under `java/src/test/java/com/github/fobshippingpoint/sNNNN.../SolutionTest.java`. Use JUnit parameterized tests with `Stream<Arguments>` providers and one test method per solution version. Run from `java/`, for example `mvn test -Dtest=com.github.fobshippingpoint.s0206reverselinkedlist.SolutionTest`.
- Ruby: tests live under `ruby/test/sNNNN_problem_name/solution_test.rb`. Use Minitest specs, frozen test case arrays, `require_relative` to the matching `lib/.../solution`, and iterate over versioned method symbols. Run from `ruby/`, for example `bundle exec ruby test/s0206_reverse_linked_list/solution_test.rb`.
- Rust: tests are usually inline in `rust/src/sNNNN_problem_name/solution.rs` under `#[cfg(test)] mod tests`. Use small case arrays and local conversion helpers when needed. Run from `rust/`, for example `cargo test s0206`.

## Notes

- For linked-list tests, copy the lightweight helper style already used in that language.
- For Go, enumerate exposed versioned functions explicitly; do not assume an unversioned wrapper exists.
- Keep test names and assertion messages descriptive but concise.
