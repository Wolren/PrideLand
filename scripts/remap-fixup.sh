#!/usr/bin/env bash
# Duplicates loom-remapped cloth-config jars to BOTH file names (plain and
# -fabric) so either request shape resolves from the remap cache.
#
# WHY: loom names the remapped dependency output after the variant the original
# resolved as, but the filename the compileClasspath resolver asks for is fixed
# per project (the 1.20.x group asks for the plain name, the 1.21.x group for
# the -fabric name). When only one name exists, half the projects fail with:
#   "Could not find cloth-config-fabric-<hash>-<ver>.jar (remapped...)".
# Running this after a build attempt (or before a retry) makes every remapped
# jar available under both names.
set -euo pipefail

ROOT="${1:-.gradle/loom-cache/remapped_mods/remapped/me/shedaniel/cloth}"

# -fabric -> plain
find "$ROOT" -name "*-fabric.jar" -exec bash -c 'cp "$1" "${1%-fabric.jar}.jar"' _ {} \;
# plain -> -fabric (covers remaps that only produced the plain name)
find "$ROOT" -name "*.jar" ! -name "*-fabric.jar" -exec bash -c 'cp "$1" "${1%.jar}-fabric.jar"' _ {} \;
