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
    const numDotIdx = humanName.indexOf('.');
    const questionNumberPad4 = humanName.substring(0, numDotIdx).padStart(4, '0');
    const questionText = humanName.substring(numDotIdx + 1).trim().replaceAll(' ', '_').toLowerCase();
    const directoryName = `${questionNumberPad4}_${questionText}`;
    const url = titleEl.href;
    const toCopy = [humanName, directoryName, url].join("\n");

    navigator.clipboard.writeText(toCopy);
    alert(toCopy);
  }
});


