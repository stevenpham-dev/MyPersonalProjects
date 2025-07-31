Comprehensive Overview of Code Contributions in the Territory Control Mod

**A two‑faction battle mod for King Arthur’s Gold**  
Transforms the sandbox mod, Territory Control (made by TFlippy) into a competitive team‑vs‑team experience with faction bases, upgradeable defenses, new gameplay systems, and deep balance tuning, and I coined it TC CTF, or Territory Control - Conquer the Faction.

---

## Comprehensive Overview of Code Contributions

I, under the username of DarkSlayer at the time, contributed a wide range of features, fixes, and improvements to TFlippy’s Territory Control mod for King Arthur’s Gold. These contributions span from mid‑2020 through early 2022, starting when the author was a beginner at coding. Below is a detailed summary of the most noteworthy changes, organized by category for clarity.

---

## New Features and Additions

- **SmartStorage System**  
  Designed from the ground up to eliminate storage‑related lag, the SmartStorage System replaces the dozens or hundreds of item blobs in a container with a single `(itemName, totalCount)` record. On deposit, blobs are immediately deleted and only the aggregate count is stored; on withdrawal, exactly the requested number of blobs are spawned on‑demand. Fully compatible with any storage entity—chests, faction bases, dinghies—by simply tagging `this.Tag("smart_storage")`, setting `this.set_u16("capacity", <max>)`, and including the core script, it slashes network traffic and physics overhead, enabling smooth gameplay even when hoarding 100 000+ items. This original, self‑engineered solution showcases systems‑level thinking in AngelScript and a keen focus on performance optimization.
  ![SmartStorage in Action](SmartStorage/kag_smartStorage.gif)

- **New Structures and Items**  
  Introduced entirely new gameplay elements. For example, a Library building was added for builder classes, and the Drug Lab gained a gacha mechanic (random reward packs) to add unpredictability to item outputs. The Chemical Lab and Nuclear Reactor structures became upgradeable—players can spend resources (e.g. copper ingots) to increase the lab’s max heat or the reactor’s max irradiation capacity. Numerous crafting recipes were expanded as well (e.g. more items craftable at the Tinker Table).

- **New Equipment and Gear**  
  A robust armor/equipment system was implemented. Wearable items like Combat Boots grant special effects; makeshift armors such as Bucket/Barrel helmets (using buckets or barrels) and a camouflage “Bush” helmet add variety. Armor items are stackable in inventory and can be repaired. A new chat command (`!armor`) helps players manage and equip armor pieces easily.

- **New Classes and Entities**  
  Added a brand‑new Engineer class/character with unique abilities to enrich team roles. A Hobo NPC was reworked (behavior and drops), and a “UPF Player Chicken” ally can now spawn for UPF‑faction players. NPC improvements include Commander Chickens wielding varied weapons instead of a single default gun.

- **Utilities and Devices**  
  Implemented gadgets like the “Shifter” and “Gyro” devices (for teleportation or vehicle movement). Introduced a Faction Base system with toggleable lights for stealth and a distance check to prevent base overcrowding. Classic siege weapons, including a Catapult, were also added.

- **Resource and Economy Features**  
  Enriched the economy with Bulk Copper Wire crafting (bundling wires), an Induction Furnace upgrade (wood→coal fuel), and Drug Lab compatibility with item hoppers for automated collection. Convent structures now grant bonus health to nearby players, rewarding map control.

---

## Gameplay Balance and Tweaks

- **Weapons and Combat**  
  Nerfed overpowered guns (damage/rate‑of‑fire), re‑introduced the Gauss Rifle with balanced stats, and adjusted explosive items (keg armor HP, bomb weight) for fair gameplay.

- **Armor and Equipment Balance**  
  Added durability and repair mechanics so armor requires maintenance. Balanced makeshift armors (buckets/barrels) by their stats, and enabled lighters to ignite Kegs for tactical depth.

- **Structures and Objectives**  
  Nerfed the Library’s initial benefits (research times/costs), tuned Altars’ health for sieges, and balanced the Hobo NPC’s loot and behavior to avoid exploitation.

- **Resource and Economy Tweaks**  
  Adjusted food nutrition/effects to prevent healing exploits, reduced bomb shop prices to encourage use, and made Vodka stackable for inventory convenience. Fixed the Scyther tool’s config to restore intended functionality.

- **Faction and Team Mechanics**  
  Enforced minimum distances between faction base camps, balanced nighttime stealth with toggleable lights, and corrected edge‑case Team 100 behavior to prevent unfair advantages.

---

## Bug Fixes and Stability Improvements

- **Critical Crash Fixes**  
  Fixed a Frag Mine crash and spam, resolved an acid‑decay bug, and corrected the Centipede NPC’s LMB attack glitch to prevent server errors.

- **General Bug Squashing**  
  Eliminated “hits count mismatch” log spam, restored compatibility after engine updates, added missing Chicken Base spawns, and cleaned up compilation warnings via formatting fixes.

- **Feature‑Specific Fixes**  
  Corrected Team 100 mechanics, fixed Hazmat/Exosuit swim fin conflicts, debugged tank shell loading, and overhauled the Blueprint system for reliable construction.

- **Quality‑of‑Life Fixes**  
  Solved the “E” interaction lag by requiring proximity checks, and repaired the faction light toggle for consistent on/off behavior.

---

## Performance and Optimization

- **Lag Reduction**  
  Optimized the Tree Capitator (batched blob deletions), fixed Combat Chicken ammo spam, and addressed ingot lag via entity consolidation.

- **Entity and Resource Optimization**  
  Introduced Materials Compression to combine resource stacks, and wrapped shrapnel/fragments in `isServer()` checks to reduce client‑side load.

- **Improved Responsiveness**  
  Cached proximity checks for “E” interactions and removed debug spams and unnecessary loops to smooth gameplay on busy servers.

- **Network and Physics Tweaks**  
  Limited frag mine fragment spawns, tuned bomb physics to avoid extreme lag, and streamlined object creation under high‑stress scenarios.

---

## Code Refactoring and Cleanup

- **Code Quality Improvements**  
  Standardized formatting across scripts, removed dead code, merged duplicates, and organized logic into more intuitive structures.

- **Refactoring Systems**  
  Cleaned up Equipment and Armor systems with clearer naming, and sorted crafting recipes in the Tinker Table menu for better usability.

- **Merging and Collaboration**  
  Regularly merged upstream changes to stay in sync, resolved conflicts, and demonstrated good version control practices.

---

## Overall Progress

From small bug patches in mid‑2020 (e.g., “Update Villager.as”) to complex feature additions by late 2021 (multi‑file system overhauls), this body of work illustrates a clear learning curve—from early experimentation to robust, systems‑level design, optimization, and maintainability in AngelScript. Each contribution enhanced gameplay depth, performance, and stability, reflecting the developer’s evolution into a confident software engineer.

---
