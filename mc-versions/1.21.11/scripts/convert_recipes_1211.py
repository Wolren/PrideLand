#!/usr/bin/env python3
"""Convert PrideLand recipes from 1.21.1 (pre-1.21.2) JSON format to the
1.21.2+ format used by 1.21.11 / 1.21.x:
- ingredient objects {"item": X} / {"tag": X} -> bare strings "X" / "#X"
- result {"item": X, "count": N} -> {"id": X, "count": N} (count optional)
- nested loot table references "name" -> "value"
Run from the version root: python3 scripts/convert_recipes_1211.py
"""
import json, pathlib, sys

RECIPE_DIR = pathlib.Path("common/src/main/resources/data/pride_land/recipe")


def conv_ingredient(ing):
    """Convert an ingredient (or list of alternatives) to 1.21.2+ form."""
    if isinstance(ing, list):
        return [conv_ingredient(i) for i in ing]
    if isinstance(ing, dict):
        if "item" in ing:
            return ing["item"]
        if "tag" in ing:
            return "#" + ing["tag"]
        return ing
    return ing


def conv_result(res):
    """Convert a result entry to {id, count} form."""
    if isinstance(res, dict) and "item" in res and "id" not in res:
        out = {"id": res["item"]}
        if "count" in res and res["count"] != 1:
            out["count"] = res["count"]
        return out
    return res


def convert_recipe(path):
    data = json.loads(path.read_text())
    rtype = data.get("type", "")
    if rtype == "minecraft:crafting_shaped":
        if "key" in data:
            data["key"] = {k: conv_ingredient(v) for k, v in data["key"].items()}
        data["result"] = conv_result(data["result"])
    elif rtype == "minecraft:crafting_shapeless":
        if "ingredients" in data:
            data["ingredients"] = [conv_ingredient(i) for i in data["ingredients"]]
        data["result"] = conv_result(data["result"])
    elif rtype == "pride_land:rainbow_cutting":
        if "ingredient" in data:
            data["ingredient"] = conv_ingredient(data["ingredient"])
        data["result"] = conv_result(data["result"])
    elif rtype in ("minecraft:smelting", "minecraft:blasting",
                   "minecraft:smoking", "minecraft:campfire_cooking"):
        data["ingredient"] = conv_ingredient(data["ingredient"])
        data["result"] = conv_result(data["result"])
    else:
        print(f"  SKIP unknown type {rtype}: {path.name}")
        return False
    path.write_text(json.dumps(data, indent=2, ensure_ascii=False))
    return True


def main():
    count = 0
    for p in sorted(RECIPE_DIR.glob("*.json")):
        if convert_recipe(p):
            count += 1
    for p in sorted((RECIPE_DIR / "rainbow_cutting").glob("*.json")):
        if convert_recipe(p):
            count += 1
    print(f"Converted {count} recipes in {RECIPE_DIR}")


if __name__ == "__main__":
    main()
