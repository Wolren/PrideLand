#!/usr/bin/env bash
# Seeds cloth-config-fabric jars into mavenLocal for the Loom remap pipeline.
#
# WHY: on maven.shedaniel.me every cloth-config-fabric version >= 12 publishes
# ONLY the "-fabric" classified jar. Loom's dependency-remap resolves the
# PLAIN coordinate (me.shedaniel.cloth:cloth-config-fabric:<ver>), which 404s,
# so the remap never generates and compileJava fails with
# "Could not find cloth-config-fabric-<hash>-<ver>.jar (remapped...)".
# Seeding the plain-named jar into ~/.m2 (mavenLocal is first in every
# project's repositories) gives the remap pipeline its input.
set -euo pipefail

VERSIONS=(12.0.137 13.0.138 15.0.140 16.0.143 18.0.145 19.0.147 20.0.148 20.0.149 21.11.153)

for v in "${VERSIONS[@]}"; do
  dir="$HOME/.m2/repository/me/shedaniel/cloth/cloth-config-fabric/$v"
  jar="$dir/cloth-config-fabric-$v.jar"
  pom="$dir/cloth-config-fabric-$v.pom"
  if [[ -f "$jar" && -f "$pom" ]]; then
    echo "cached $v"
    continue
  fi
  mkdir -p "$dir"
  curl -fsSL -o "$pom" "https://maven.shedaniel.me/me/shedaniel/cloth/cloth-config-fabric/$v/cloth-config-fabric-$v.pom"
  curl -fsSL -o "$jar" "https://maven.shedaniel.me/me/shedaniel/cloth/cloth-config-fabric/$v/cloth-config-fabric-$v-fabric.jar"
  echo "seeded $v"
done
