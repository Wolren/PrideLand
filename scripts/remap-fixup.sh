set -euo pipefail

ROOT="${1:-.gradle/loom-cache/remapped_mods/remapped/me/shedaniel/cloth}"

find "$ROOT" -name "*-fabric.jar" -exec bash -c 'cp "$1" "${1%-fabric.jar}.jar"' _ {} \;
find "$ROOT" -name "*.jar" ! -name "*-fabric.jar" -exec bash -c 'cp "$1" "${1%.jar}-fabric.jar"' _ {} \;
