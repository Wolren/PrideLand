# Multi-version trees (mc-versions/)

Each version under `mc-versions/` is a full Architectury multi-loader setup
with common, fabric, forge, and quilt modules. Active versions are listed in
`settings.gradle`. Standalone 26.x trees build with their own wrappers.
Archives of old standalone Fabric versions are in `archive/` for reference.

## Creating a new MC version

1. Create the tree:
   `mkdir -p mc-versions/<mc>/{common,fabric,forge,quilt}/src/main/{java,resources}`
2. Copy source from the closest API version. The root modules suit 1.20.x:
   `robocopy common\src mc-versions\<mc>\common\src /E` (same for fabric, forge, quilt).
3. Copy `mc-versions/1.20.4/gradle.properties` as the template for version-specific properties.
4. Copy a module `build.gradle` from an existing version (for example 1.20.4) and update the project path references.
5. Add the modules to `settings.gradle`, one line per module:
   `include("mc-versions:<mc>:common")` and the same for fabric, forge, quilt.
6. Build one module to verify: `./gradlew :mc-versions:<mc>:<module>:build` (fabric, forge, quilt).
7. Adapt the source for the MC API differences (`Registries` vs `Registry`, removed or added blocks) until it compiles.
8. Forge modules require `loom.platform=forge` in their `gradle.properties` (see `mc-versions/1.20.4/forge/gradle.properties`).
