// ==UserScript==
// @name          Copy create scaffold command - leetcode.com
// @version       1.4
// @namespace     Violentmonkey Scripts
// @match         https://leetcode.com/problems/*
// @downloadURL   https://github.com/FOBshippingpoint/leetcode-revamp/raw/refs/heads/main/contrib/userscript.js
// @grant         none
// @author        CC Lan
// @description   Copy shell command for LeetCode local solution scaffolding.
// ==/UserScript==


// Usage:
//    F2: search title on YouTube
//    F4: copy scaffold generation script
//    F7: copy whole description

function getOrThrow(selector) {
  const el = document.querySelector(selector);
  if (!el) throw Error(`[ ${selector} ] not found`);
  return el;
}

window.addEventListener("keydown", (e) => {
  if (e.key === 'F4') {
    const titleEl = getOrThrow('.cursor-text');
    const title = titleEl.textContent;
    const url = titleEl.href;
    const toCopy = `(
cd "$(git rev-parse --show-toplevel)" &&
contrib/scaffold.sh --title '${shellEscape(title)}' --url '${url}'
)`

    navigator.clipboard.writeText(toCopy);
    alert(toCopy);
  }
});

window.addEventListener("keydown", (e) => {
  if (e.key === 'F7') {
    const description = getOrThrow('.cursor-text').closest(".w-full");
    const toCopy = description.textContent;
    navigator.clipboard.writeText(toCopy);
    alert(toCopy);
  }
});

window.addEventListener("keydown", (e) => {
  if (e.key === 'F2') {
    e.preventDefault();
    const titleEl = getOrThrow('.cursor-text');
    const title = titleEl.textContent;
    const url = new URL("https://www.youtube.com/results");
    url.searchParams.set("search_query", title);
    window.open(url, "_blank", "noopener");
  }
});

function shellEscape(string) {
  return string.replaceAll("'", "'\\''");
}
