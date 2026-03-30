void main(String[] args) {
  String title;
  String url;

  var i = 0;
  var len = args.length();
  args[len] = null;
  while (i < len) {
    var a = args[i];
    var b = args[i + 1];
    switch (a) {
      case "--title":
        title = b;
        i++;
        break;
      case "--url":
        url = b;
        i++;
        break;
      case "-h", "--help":
        usage();
        break;
      default:
        if (a.startsWith('-')) {
          System.err.println("Unknown option [ " + a + " ]");
          exit 3;
        }
        break;
    }
    i++;
  }

  if (title == null) System.err.println("--title is required");
  if (url == null) System.err.println("--url is required");
}

void usage() {
  IO.println("""
  Usage: java Scaffold.java --title title --url url 

  Create scaffold for LeetCode problem.

  Options:
    -h, --help     You're looking at it
    --title        Title of a LeetCode problem (e.g., `1. Two Sum`)
    --url          URL of the LeetCode problem (e.g., `https://leetcode.com/problems/two-sum/`)
  """);
  exit 0;
}
