#!/usr/bin/env -S cargo +nightly -Zscript

use std::env;
use std::error::Error;
use std::fs;
use std::path::{Path, PathBuf};

fn format_dir_name(title: &str) -> Result<String, Box<dyn Error>> {
    let (num_str, name_str) = title
        .split_once('.')
        .ok_or("Invalid title format. Expected '<number>. Problem Name'")?;

    let num: usize = num_str.trim().parse()?;

    let name = name_str
        .trim()
        .to_lowercase()
        .replace(|c: char| !c.is_alphanumeric(), "_");

    Ok(format!("s{num:04}_{name}"))
}

fn create_mod(path: &Path) -> Result<(), Box<dyn Error>> {
    fs::write(
        path.join("mod.rs"),
        r#"#[allow(dead_code)]
pub mod solution;"#,
    )?;
    fs::write(
        path.join("solution.rs"),
        r#"pub struct Solution;

impl Solution {
    pub fn __solution__() {
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test__solution__() {
        // assert_eq!(Solution::two_sum_v1(vec![2, 7, 11, 15], 9), vec![0, 1]);
        // assert_eq!(Solution::two_sum_v1(vec![3, 2, 4], 6), vec![1, 2]);
        // assert_eq!(Solution::two_sum_v1(vec![3, 3], 6), vec![0, 1]);
    }
}
"#,
    )?;
    Ok(())
}

fn create_note_md(path: &Path, title: &str, url: &str) -> Result<(), Box<dyn Error>> {
    let content = format!("[{title}]({url})\n");
    fs::write(path.join("note.md"), content)?;
    Ok(())
}

fn main() -> Result<(), Box<dyn Error>> {
    let mut args = env::args().skip(1);
    let mut title = None;
    let mut url = None;

    while let Some(arg) = args.next() {
        match arg.as_str() {
            "-t" | "--title" => title = args.next(),
            "-u" | "--url" => url = args.next(),
            "-h" | "--help" => {
                println!(
                    r#"Usage: scaffold.rs -t|--title TITLE -u|--url URL

Create scaffold for LeetCode problem

Options:
    -h, --help     You're looking at it
    -t, --title    Title of a LeetCode problem (e.g., `1. Two Sum`)
    -u, --url      URL of the LeetCode problem (e.g., `https://leetcode.com/problems/two-sum/`)
"#
                );
                return Ok(());
            }
            _ => return Err(format!("Unknown option: {}", arg).into()),
        }
    }

    let title = title.ok_or("--title is required")?;
    let url = url.ok_or("--url is required")?;

    if !url.starts_with("https") {
        return Err("URL must start with https".into());
    }

    let dir_name = format_dir_name(&title)?;
    let src_path = PathBuf::from("rust").join("src").join(&dir_name);

    fs::create_dir_all(&src_path)?;

    if !src_path.join("solution.rs").exists() {
        create_mod(&src_path)?;
    }
    if !src_path.join("note.md").exists() {
        create_note_md(&src_path, &title, &url)?;
    }

    println!("Created: {}", src_path.display());
    Ok(())
}
