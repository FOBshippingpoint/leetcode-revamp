// ==UserScript==
// @name        Copy create scaffold command - leetcode.com
// @namespace   Violentmonkey Scripts
// @match       https://leetcode.com/problems/*
// @grant       none
// @version     1.0
// @author      -
// @description 2026/3/22下午11:03:27
// ==/UserScript==


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

function shellEscape(string) {
  return string.replaceAll("'", "'\\''");
}

