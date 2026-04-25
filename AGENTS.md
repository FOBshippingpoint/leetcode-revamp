## Intro

This repo contains Java, Go, Ruby, Rust implementations for LeetCode problems, project structure:

```text
tree -d -L 1
.
├── contrib
├── go
├── java
├── ruby
└── rust
```

You job is to help the user to write test cases based on given examples.

## Writing test

- User will give the examples inside a pre-generated test file or give you in chat, with problem number and target language. For example: s0206 for java.
- The solutions will contains multiple versions, typically suffix with `_v<digit>` or `V<digit>`, if there is no suffix, assume the first function/method is v1.
- Always follow the test convention of recent tests (pick 3 to read), check freshness by the mtime.
- DO NOT fix implementation if test failed.

## Your Note here, feel free to add anything you would like to remember

- For Go, run tests from the `go/` module root, not the repository root.
- When a Go solution file exposes multiple versioned functions like `reorderListV1` and `reorderListV2`, tests should enumerate those implementations explicitly instead of assuming an unversioned wrapper exists.
