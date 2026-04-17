// ==UserScript==
// @name          Copy create scaffold command - leetcode.com
// @version       1.1
// @namespace     Violentmonkey Scripts
// @match         https://leetcode.com/problems/*
// @downloadURL   https://github.com/FOBshippingpoint/leetcode-revamp/raw/refs/heads/main/contrib/userscript.js
// @grant         none
// @author        CC Lan
// @description   Copy shell command for LeetCode local solution scaffolding.
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

