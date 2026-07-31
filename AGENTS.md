# PrideLand — Agent Reference

Multi-version, cross-loader Minecraft mod (Fabric + Forge + NeoForge + Quilt) using
Architectury. One shared codebase per MC version, platform modules per loader.

## Project Info

- **Build:** Gradle (Architectury Loom 1.17.487, Gradle 9.6.1 wrapper)
- **Path:** `D:/Projects/java/minecraft/PrideLand`
- **Mappings:** Yarn for fabric/quilt/forge modules (NeoForge via yarn-mappings-patch-neoforge)
- **Branch layout:** `architectury/1.20.1` is the active branch. `1.19.4`, `1.20.2`,
  `1.20.3`, `1.20.4`, `main_1.20.1` branches are legacy and not used by the build.

## Structure

- **Root modules (`common/`, `fabric/`, `forge/`, `quilt/`)** — MC 1.20.1 baseline.
  NEVER modify these; they are the canonical 1.20.1 release.
- **`mc-versions/<version>/<loader>/`** — per-version Architectury groups.
  Each version is self-contained: `common/` (shared game code + assets), plus
  `fabric/`, `forge/`, `neoforge/`, `quilt/` loader modules.
  Current versions:
  - `1.20.x/1.20.2/` — common + fabric + forge (forge uses Forge 48.x)
  - `1.20.x/1.20.3/` — common + fabric (Forge 1.20.3 line 49.0.x is abandoned on maven, no forge module)
  - `1.20.x/1.20.4/` — common + fabric + forge (Forge 49.2.x, NOT 50.x) + quilt
  - `1.21.1/` — common + fabric + neoforge + quilt (real forge excluded: architectury-forge 13.0.8 unavailable)
  - `1.21.x/1.21.2..1.21.4/` — ERA A (common + fabric + neoforge + quilt), based on 1.21.1 code.
    1.21.2 is the biggest API break of the 1.21 line: equipment overhaul
    (item.equipment ArmorMaterial/EquipmentType/ToolMaterial), BlockEntityType
    private ctor (AW-widened), EntityType.Builder.build(RegistryKey),
    SingleStackRecipe (CuttingRecipe renamed), state-based entity renderers,
    and the RecipeManager interface rewrite (getAllMatches/getFirstMatch GONE
    from the interface - the ServerRecipeManager IMPL keeps getFirstMatch +
    values(), so the rainbow station works via an impl cast, same pattern as
    1.21.11). EMI/REI integrations are excluded on 1.21.2-1.21.4: the client
    has NO recipe enumeration (server-only), so the integrations cannot list
    custom-type recipes there.
    0.106.1+1.21.2 / 0.107.1+1.21.3 / 0.109.0+1.21.4 with rendering-v1 FORCED
    to 8.0.5+c47b9d4373 (resolution otherwise pulls 16.0.1, remapped against
    1.21.9 classes). cloth 15.0.140 (16.x artifacts use a -fabric classifier
    that breaks loom remap lookup), terraform 7.0.2, REI/EMI from root.
    1.21.3 = architectury skipped (common+neoforge only direct deps, no forge).
    1.21.4 = equipment ASSETS (ArmorMaterial takes RegistryKey<EquipmentAsset>),
    LoadedEntityModels (not EntityModelLoader), ENTITYBLOCK_ANIMATED removed.
  - `1.21.x/1.21.5..1.21.8/` — ERA B floor (common + fabric + neoforge + quilt),
    based on 1.21.11 code. Old-API rendering (VCP + MatrixStack, no render
    commands): 1.21.5 = state-render + VertexConsumerProvider (hardest version,
    ~10 source fixes; fabric-api 0.114.1+1.21.5 - 0.128.x is contaminated with
    1.21.6 mappings; boats/signs/fuel/datagen dropped - no terraform build
    exists for 1.21.5), 1.21.6 = getEntityWorld->getWorld (fabric-api
    0.121.0+1.21.6, BlockRenderLayerMap in blockrenderlayer-v1 INSTANCE API),
    1.21.7 = rendering-v1 12.4.0 enum-style BlockRenderLayerMap (fabric-api
    0.128.0+1.21.7), 1.21.8 = command-queue render system NOT yet (it lands at
    1.21.9) - old-API renderers + rendering-v1 forced to 12.6.0 (resolution
    pulls 1.21.9-contaminated 16.0.1).
  - `1.21.x/1.21.9..1.21.10/` — COMMAND-QUEUE era (render.command APIs,
    Click-based screen input; 1.21.10 = 1.21.11 minus RenderSetup +
    SleepFailureReason.message() accessor).
  - `1.21.11/` — common + fabric + forge (NeoForge 61.x) + quilt
  - `1.26.x/` — STANDALONE NeoForge build (own gradlew, MC 26.2, Java 25), not in root settings.gradle
  - `1.26.x-fabric/` — STANDALONE Fabric build (own gradlew, MC 26.2 unobfuscated, Java 25), not in root settings.gradle

## 26.1 support (NeoForge only)

The 26.x NeoForge project compiles against MC 26.1 with zero code changes:
pass `-P` overrides matching the 26.1 line (see .github/workflows/build.yml for the
exact list: `-Pminecraft_version=26.1 -Pminecraft_version_range=[26.1]
-Pneo_version=26.1.0.19-beta -Pmc_version=26.1 -Pjei_version=29.2.0.21
-Pmod_version=1.0.4-26.1 -Ppack_format=101`). Verified: 26.1 and 26.2 share the
same API surface for everything the mod uses (RenderLayer submit-node API,
AvatarRenderer, SheepRenderState, GLIDER components, record RecipeSerializer,
NeoForge client events). pack_format is parameterized (101 = 26.1, 107 = 26.2).
The Fabric 26.1 path is blocked upstream: fabric-api has NO published aggregate
for 26.1 (metadata-only phantom versions, poms 404).

## Key Rules

- **Every module has its own `gradle.properties`** with per-version values.
  Gradle does NOT inherit intermediate `gradle.properties` files (e.g.
  `1.20.x/gradle.properties` is invisible to `1.20.x/1.20.4/fabric`).
  Missing props silently fall back to root values (1.20.1) — the #1 source of bugs.
- **Access widener files must be named `pride_land.accessWidener`** (capital W) to
  match build.gradle references. The lowercase variant silently breaks AW
  application in Loom's case-sensitive pipeline (validation reads it, remap ignores it).
- **AW descriptors are per-version.** Block ctor param order changed between
  1.20.2 (old order) and 1.20.3+ (new order). GlassBlock is unmapped in Yarn
  1.20.3+/1.20.4 — the code uses TransparentBlock/StainedGlassBlock instead.
- **Forge/NeoForge modules disable `validateAccessWidener`** (they use
  convertAccessWideners); fabric/quilt keep it enabled.
- **Version naming:** `mod_version-MC_version` (e.g. `1.0.4-1.21.11`) per module.
  Root build.gradle must use `project.findProperty("mod_version")`, NOT
  `rootProject.findProperty` — otherwise every version inherits 1.20.1's version.
- **Gradle UP-TO-DATE lies.** Stale build outputs hid compile errors for weeks.
  After changes, verify with `--rerun-tasks` or by deleting `build/classes`.
- **TerraformersMC maven is unreliable** (down for long stretches). Cached
  artifacts in `~/.gradle/caches/modules-2` or `mavenLocal()` are the fallback.
  Forge 1.20.4 is `1.20.4-49.2.8`; Forge 50.x is MC 1.21.
- On this machine: `ulimit -u 16384` before Gradle (git-bash default 256 kills
  the daemon). Root gradle.properties pins `org.gradle.java.home` to jdk-21;
  26.x projects need JDK 25.

## Build

```bash
cd "D:/Projects/java/minecraft/PrideLand"

# Root 1.20.1
./gradlew :common:build :fabric:build :forge:build :quilt:build

# A specific version/loader
./gradlew :mc-versions:1.21.11:fabric:build

# Standalone 26.x builds (Java 25)
cd mc-versions/1.26.x && ./gradlew build
cd mc-versions/1.26.x-fabric && ./gradlew build
```

## CI

`.github/workflows/build.yml` builds every wired module on ubuntu + windows with
JDK 21 (root) and a separate JDK 25 job for the two standalone 26.x builds.
All Gradle invocations pass `-Dorg.gradle.java.home="$JAVA_HOME"` to override the
machine-specific java.home in root gradle.properties.

## Load skills

When working on this project, load `minecraft-cross-loader-development` and
`minecraft-multi-version-project` skills.
