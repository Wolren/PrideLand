# PrideLand — Agent Reference

Fabric + Forge cross-loader Minecraft mod. Shared common module, separate platform builds.

## Project Info

- **Build:** Gradle (fabric-loom + ForgeGradle, separate Gradle versions)
- **Path:** `D:/Projects/java/minecraft/PrideLand`
- **Mappings:** Mojang official mappings for cross-platform compatibility
- **Structure:** `common/` + `fabric/` + `forge-standalone/`

## Architecture

- **Common module** — Mojmap names exclusively. Block/item definitions using vanilla `BlockBehaviour.Properties.of()` and `new Item.Settings()`. No Fabric-specific APIs.
- **Fabric module** — fabric-loom, `ModInitializer`, `ClientModInitializer`
- **Forge module** — ForgeGradle, `@Mod` annotated, separate build (Gradle version conflicts with Loom)

## Key Patterns

- Access widener for protected constructors (IronBarsBlock, StairBlock, AxeItem, HoeItem) — uses `/` path notation
- FabricBlockSettings → explicit vanilla `.properties().strength().sound()` in common
- Yarn-to-Mojmap conversion reference in `convert_mojmap.py`
- Block property values: wool (0.8F, SoundType.WOOL), glass (0.3F, noOcclusion), stone (1.5-3.5F)

## Build

```bash
cd "D:/Projects/java/minecraft/PrideLand"

# Fabric
./gradlew :fabric:build

# Forge (separate wrapper)
cd forge-standalone && ./gradlew build
```

## Load skills

When working on this project, load `minecraft-mod-dev` and `ci-github-workflows` skills from `.opencode/skills/`.
