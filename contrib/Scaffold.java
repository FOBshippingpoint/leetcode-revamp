void main(String[] args) throws Exception {
  var scriptPath = Path.of(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

  String title = "";
  String url = "";

  var i = 0;
  while (i < args.length) {
    var a = args[i];
    switch (a) {
      case "--title":
        title = args[i + 1];
        i += 2;
        break;
      case "--url":
        url = args[i + 1];
        i += 2;
        break;
      case "-h":
      case "--help":
        usage();
        i++;
        break;
      default:
        if (a.startsWith("-")) {
          System.err.println("Unknown option [ " + a + " ]");
          System.exit(3);
        }
        i++;
        break;
    }
  }

  if (title.isEmpty()) {
    System.err.println("--title is required");
    System.exit(1);
  }
  if (url.isEmpty()) {
    System.err.println("--url is required");
    System.exit(1);
  }

  if (!url.startsWith("http")) {
    System.err.println("URL is invalid");
    System.exit(1);
  }

  var pkgName = getPackageName(title);
  var srcPath = scriptPath.getParent().getParent().resolve("java/src/main/java/com/github/fobshippingpoint").resolve(pkgName);
  var testPath = scriptPath.getParent().getParent().resolve("java/src/test/java/com/github/fobshippingpoint").resolve(pkgName);
  Files.createDirectories(srcPath);
  Files.createDirectories(testPath);

  var notePath = srcPath.resolve("note.md");
  if (!Files.exists(notePath)) {
    Files.writeString(notePath, "[" + title + "](" + url + ")\n");
  }

  var solutionPath = srcPath.resolve("Solution.java");
  if (!Files.exists(solutionPath)) {
    Files.writeString(solutionPath, "package com.github.fobshippingpoint." + pkgName + ";" + """


    public class Solution {

    }
    """);
  }

  var testJavaPath = testPath.resolve("SolutionTest.java");
  if (!Files.exists(testJavaPath)) {
    Files.writeString(testJavaPath, "package com.github.fobshippingpoint." + pkgName + ";" + """


    import org.junit.jupiter.params.ParameterizedTest;
    import org.junit.jupiter.params.provider.Arguments;
    import org.junit.jupiter.params.provider.MethodSource;

    import java.util.stream.Stream;

    import static org.junit.jupiter.api.Assertions.assertEquals;

    class SolutionTest {
        public static Stream<Arguments> provider() {
            return Stream.of(
                    // Arguments.of("Should be duplicates since the element 1 occurs at the indices 0 and 3.",
                    //         new int[]{1, 2, 3, 1}, true),
                    // Arguments.of("Should not be duplicates since All elements are distinct.",
                    //         new int[]{1, 2, 3, 4}, false),
                    // Arguments.of("Should be duplicates since The element 1 occurs at the indices 0 and 1.",
                    //         new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
            );
        }

        @ParameterizedTest
        @MethodSource("provider")
        void test__solution__() {

        }

    }
    """);
  }
}

String getPackageName(String title) {
  var dotIdx = title.indexOf('.');
  var num = String.format("%04d", Integer.parseInt(title.substring(0, dotIdx).trim()));
  var titleNoNum = title.substring(dotIdx + 1).replaceAll("[^\\p{Alnum}]", "").toLowerCase();
  return "s" + num + titleNoNum;
}

void usage() {
  IO.println("""
  Usage: java Scaffold.java --title title --url url 

  Create scaffold for LeetCode problem

  Options:
    -h, --help     You're looking at it
    --title        Title of a LeetCode problem (e.g., `1. Two Sum`)
    --url          URL of the LeetCode problem (e.g., `https://leetcode.com/problems/two-sum/`)
  """);
  System.exit(0);
}
