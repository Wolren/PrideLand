#!/usr/bin/env bash
# Seeds cloth-config-fabric jars into mavenLocal for the Loom remap pipeline.
#
# WHY: on maven.shedaniel.me every cloth-config-fabric version >= 12 publishes
# ONLY the "-fabric" classified jar (no plain jar). Loom's dependency-remap
# resolves the original through Gradle module metadata and names the remapped
# output after the declared coordinate, so the exact filename the resolver asks
# for varies per project (plain vs -fabric). Seeding BOTH file names plus the
# .module metadata into ~/.m2 (mavenLocal is first in every project's
# repositories) makes every variant resolve locally and the remap always has an
# input, so compileJava never fails with:
#   "Could not find cloth-config-fabric-<hash>-<ver>.jar (remapped...)".
set -euo pipefail

VERSIONS=(12.0.137 13.0.138 15.0.140 16.0.143 18.0.145 19.0.147 20.0.148 20.0.149 21.11.153)

for v in "${VERSIONS[@]}"; do
  dir="$HOME/.m2/repository/me/shedaniel/cloth/cloth-config-fabric/$v"
  pom="$dir/cloth-config-fabric-$v.pom"
  module="$dir/cloth-config-fabric-$v.module"
  jar="$dir/cloth-config-fabric-$v.jar"
  jar_fabric="$dir/cloth-config-fabric-$v-fabric.jar"
  if [[ -f "$jar" && -f "$jar_fabric" && -f "$pom" && -f "$module" ]]; then
    echo "cached $v"
    continue
  fi
  mkdir -p "$dir"
  curl -fsSL -o "$pom" "https://maven.shedaniel.me/me/shedaniel/cloth/cloth-config-fabric/$v/cloth-config-fabric-$v.pom"
  curl -fsSL -o "$module" "https://maven.shedaniel.me/me/shedaniel/cloth/cloth-config-fabric/$v/cloth-config-fabric-$v.module" || true
  curl -fsSL -o "$jar_fabric" "https://maven.shedaniel.me/me/shedaniel/cloth/cloth-config-fabric/$v/cloth-config-fabric-$v-fabric.jar"
  cp "$jar_fabric" "$jar"
  echo "seeded $v"
done
