# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a personal Java algorithm practice repository containing solutions to LeetCode and AcWing problems. It is an IntelliJ IDEA project with no build system (Maven/Gradle) - plain Java source files.

## Running Code

- **Compile and Run**: Use IntelliJ IDEA to run individual Java files, or compile from terminal:
  ```bash
  javac -d out src/Path/To/File.java
  java -cp out Path.To.File
  ```

- **Run Tests**: This project uses JUnit4. Run tests through IntelliJ IDEA (right-click on test file → Run) or configure a test runner.

## Code Architecture

The source code is organized in `src/` with these main sections:

- **BeforeWork/** - Algorithm implementations organized by topic:
  - `AcWing/` - Solutions to AcWing problems (BFS, DFS, DP, Trie, Graph algorithms, etc.)
  - `BFS/`, `BackStracking/`, `DP/`, `DFS/`, `Hash/`, `LinkedList/`, `Math/`, `Stack/`, `String/`, `Tree/` - LeetCode solutions by category

- **Test/** - Test files for validating implementations

- **WorkReview/** - Work review code

- **MeiTuan2025/** - Meituan interview practice problems

- **xiaohongshu/** - Xiaohongshu interview practice problems

## Development Notes

- The `.idea/` folder contains IntelliJ IDEA configuration including CheckStyle and SonarLint settings
- Compiled class files go to the `out/` directory (already gitignored)
- No standard build commands exist - work directly with Java files through IntelliJ IDEA
