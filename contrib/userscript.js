// ==UserScript==
// @name        Copy scaffold - leetcode.com
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
    const humanName = titleEl.textContent;
    const url = titleEl.href;
    const toCopy = [humanName, url].join("\n");

    navigator.clipboard.writeText(toCopy);
    alert(toCopy);
  }
});


