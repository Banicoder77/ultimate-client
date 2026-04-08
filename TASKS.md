# Ultimate Client - Porting Tasks from LiquidBounce

> Source: `/home/user456/Documents/Work_Folder/LiquidBounce/src/main/kotlin/net/ccbluex/liquidbounce/features/module/modules/`
> Target: `src/main/java/ultimatedevelopment/ultimateclient/systems/modules/`

Legend: ✅ Done | 🔄 In Progress | ⬜ Todo

---

## 0. Infrastructure (do first)

- ✅ Add `exploit` category to `Categories.java`
- ✅ Add `fun` category to `Categories.java`
- ✅ Register both new categories in `Modules.java`

---

## 1. COMBAT (missing 12)

| Task | Module | LB Source |
|------|--------|-----------|
| ⬜ | TpAura | `combat/tpaura/ModuleTpAura.kt` |
| ⬜ | Backtrack | `combat/backtrack/ModuleBacktrack.kt` |
| ⬜ | FakeLag | `combat/ModuleFakeLag.kt` |
| ⬜ | TickBase | `combat/ModuleTickBase.kt` |
| ⬜ | MaceKill | `combat/ModuleMaceKill.kt` |
| ⬜ | SuperKnockback | `combat/ModuleSuperKnockback.kt` |
| ⬜ | SwordBlock | `combat/ModuleSwordBlock.kt` |
| ⬜ | TimerRange | `combat/ModuleTimerRange.kt` |
| ⬜ | ElytraTarget | `combat/elytratarget/ModuleElytraTarget.kt` |
| ⬜ | AutoRod | `combat/ModuleAutoRod.kt` |
| ⬜ | AutoShoot | `combat/ModuleAutoShoot.kt` |
| ⬜ | NoMissCooldown | `combat/ModuleNoMissCooldown.kt` |
| ⬜ | AutoLeave | `combat/ModuleAutoLeave.kt` |
| ⬜ | KeepSprint | `combat/ModuleKeepSprint.kt` |
| ⬜ | Hitbox (LB version) | `combat/ModuleHitbox.kt` |

---

## 2. PLAYER (missing 13)

| Task | Module | LB Source |
|------|--------|-----------|
| ⬜ | Blink | `player/ModuleBlink.kt` |
| ⬜ | Eagle | `player/ModuleEagle.kt` |
| ⬜ | PotionSpoof | `player/ModulePotionSpoof.kt` |
| ⬜ | ChestStealer | `player/cheststealer/ModuleChestStealer.kt` |
| ⬜ | AutoBuff | `player/autobuff/ModuleAutoBuff.kt` |
| ⬜ | AutoQueue | `player/autoqueue/ModuleAutoQueue.kt` |
| ⬜ | AutoShop | `player/autoshop/ModuleAutoShop.kt` |
| ⬜ | NoBlockInteract | `player/ModuleNoBlockInteract.kt` |
| ⬜ | NoEntityInteract | `player/ModuleNoEntityInteract.kt` |
| ⬜ | NoRotateSet | `player/ModuleNoRotateSet.kt` |
| ⬜ | NoSlotSet | `player/ModuleNoSlotSet.kt` |
| ⬜ | FastExp | `player/ModuleFastExp.kt` |
| ⬜ | AutoWindCharge | `player/ModuleAutoWindCharge.kt` |
| ⬜ | EasyPearl | `player/ModuleEasyPearl.kt` |
| ⬜ | AutoBreak | `player/ModuleAutoBreak.kt` |
| ⬜ | ChestCleaner | `player/invcleaner/ModuleChestCleaner.kt` |
| ⬜ | SmartEat | `player/ModuleSmartEat.kt` |
| ⬜ | Replenish | `player/ModuleReplenish.kt` |
| ⬜ | AntiExploit | `player/ModuleAntiExploit.kt` |

---

## 3. MOVEMENT (missing 20)

| Task | Module | LB Source |
|------|--------|-----------|
| ⬜ | Fly (11+ modes) | `movement/fly/ModuleFly.kt` |
| ⬜ | Speed (13+ modes) | `movement/speed/ModuleSpeed.kt` |
| ⬜ | NoSlow (12+ modes) | `movement/noslow/ModuleNoSlow.kt` |
| ⬜ | NoWeb (5+ modes) | `movement/noweb/ModuleNoWeb.kt` |
| ⬜ | LongJump | `movement/longjump/ModuleLongJump.kt` |
| ⬜ | Spider | `movement/spider/ModuleSpider.kt` |
| ⬜ | TargetStrafe | `movement/ModuleTargetStrafe.kt` |
| ⬜ | NoClip | `movement/ModuleNoClip.kt` |
| ⬜ | Freeze | `movement/ModuleFreeze.kt` |
| ⬜ | VehicleBoost | `movement/ModuleVehicleBoost.kt` |
| ⬜ | VehicleControl | `movement/ModuleVehicleControl.kt` |
| ⬜ | TerrainSpeed | `movement/terrainspeed/ModuleTerrainSpeed.kt` |
| ⬜ | AutoDodge | `movement/autododge/ModuleAutoDodge.kt` |
| ⬜ | InventoryMove | `movement/inventorymove/ModuleInventoryMove.kt` |
| ⬜ | HighJump (LB modes) | `movement/highjump/ModuleHighJump.kt` |
| ⬜ | LiquidWalk | `movement/liquidwalk/ModuleLiquidWalk.kt` |
| ⬜ | NoPose | `movement/ModuleNoPose.kt` |
| ⬜ | NoPush | `movement/ModuleNoPush.kt` |
| ⬜ | NoJumpDelay | `movement/ModuleNoJumpDelay.kt` |
| ⬜ | AntiBounce | `movement/ModuleAntiBounce.kt` |
| ⬜ | BlockBounce | `movement/ModuleBlockBounce.kt` |
| ⬜ | BlockWalk | `movement/ModuleBlockWalk.kt` |
| ⬜ | AntiLevitation | `movement/ModuleAntiLevitation.kt` |
| ⬜ | Teleport | `movement/ModuleTeleport.kt` |
| ⬜ | AvoidHazards | `movement/avoidhazards/ModuleAvoidHazards.kt` |
| ⬜ | ElytraRecast | `movement/ModuleElytraRecast.kt` |

---

## 4. RENDER (missing 25)

| Task | Module | LB Source |
|------|--------|-----------|
| ⬜ | StorageESP (advanced) | `render/esp/ModuleStorageESP.kt` |
| ⬜ | CrystalView | `render/ModuleCrystalView.kt` |
| ⬜ | ItemChams | `render/ModuleItemChams.kt` |
| ⬜ | SkinChanger | `render/ModuleSkinChanger.kt` |
| ⬜ | Crosshair | `render/crosshair/ModuleCrosshair.kt` |
| ⬜ | Hats | `render/hats/ModuleHats.kt` |
| ⬜ | HitFX | `render/hitfx/ModuleHitFX.kt` |
| ⬜ | DamageParticles | `render/ModuleDamageParticles.kt` |
| ⬜ | JumpEffect | `render/ModuleJumpEffect.kt` |
| ⬜ | TNTTimer | `render/ModuleTNTTimer.kt` |
| ⬜ | Radar | `render/ModuleRadar.kt` |
| ⬜ | BetterInventory | `render/ModuleBetterInventory.kt` |
| ⬜ | BetterTitle | `misc/ModuleBetterTitle.kt` |
| ⬜ | CustomAmbience | `render/ModuleCustomAmbience.kt` |
| ⬜ | MurderMystery | `render/murdermystery/ModuleMurderMystery.kt` |
| ⬜ | ProphuntESP | `render/ModuleProphuntESP.kt` |
| ⬜ | ProtectionZones | `render/ModuleProtectionZones.kt` |
| ⬜ | MobOwners | `render/ModuleMobOwners.kt` |
| ⬜ | NewChunks | `render/ModuleNewChunks.kt` |
| ⬜ | SilentHotbar | `render/ModuleSilentHotbar.kt` |
| ⬜ | ItemTags | `render/ModuleItemTags.kt` |
| ⬜ | AutoF5 | `render/ModuleAutoF5.kt` |
| ⬜ | CameraClip | `render/cameraclip/ModuleCameraClip.kt` |
| ⬜ | Animations | `render/ModuleAnimations.kt` |
| ⬜ | AntiBlind | `render/ModuleAntiBlind.kt` |
| ⬜ | Aspect | `render/ModuleAspect.kt` |
| ⬜ | BedPlates | `render/ModuleBedPlates.kt` |
| ⬜ | BlockOutline | `render/ModuleBlockOutline.kt` |
| ⬜ | CombineMobs | `render/ModuleCombineMobs.kt` |
| ⬜ | Particles | `render/ModuleParticles.kt` |
| ⬜ | ItemESP | `render/esp/ModuleItemESP.kt` |
| ⬜ | LogoffSpot | `render/ModuleLogoffSpot.kt` |
| ⬜ | NoFov | `render/ModuleNoFov.kt` |
| ⬜ | NoHurtCam | `render/ModuleNoHurtCam.kt` |
| ⬜ | NoBob | `render/ModuleNoBob.kt` |
| ⬜ | NoSwing | `render/ModuleNoSwing.kt` |
| ⬜ | QuickPerspectiveSwap | `render/ModuleQuickPerspectiveSwap.kt` |
| ⬜ | SmoothCamera | `render/ModuleSmoothCamera.kt` |
| ⬜ | TrueSight | `render/ModuleTrueSight.kt` |

---

## 5. WORLD (missing 15)

| Task | Module | LB Source |
|------|--------|-----------|
| ⬜ | AutoBuild | `world/autobuild/ModuleAutoBuild.kt` |
| ⬜ | AutoFarm | `world/autofarm/ModuleAutoFarm.kt` |
| ⬜ | LiquidPlace | `world/ModuleLiquidPlace.kt` |
| ⬜ | BedDefender | `world/ModuleBedDefender.kt` |
| ⬜ | BlockTrap | `world/traps/ModuleBlockTrap.kt` |
| ⬜ | BlockIn | `world/ModuleBlockIn.kt` |
| ⬜ | NoInterpolation | `world/ModuleNoInterpolation.kt` |
| ⬜ | Fucker | `world/fucker/ModuleFucker.kt` |
| ⬜ | ProjectilePuncher | `world/ModuleProjectilePuncher.kt` |
| ⬜ | StrongholdFinder | `world/ModuleStrongholdFinder.kt` |
| ⬜ | AutoDisable | `world/ModuleAutoDisable.kt` |
| ⬜ | AutoGolemRepair | `world/ModuleAutoGolemRepair.kt` |
| ⬜ | AirPlace | `world/ModuleAirPlace.kt` |
| ⬜ | Extinguish | `world/ModuleExtinguish.kt` |
| ⬜ | FastBreak (LB) | `world/ModuleFastBreak.kt` |
| ⬜ | FastPlace | `world/ModuleFastPlace.kt` |
| ⬜ | NoSlowBreak | `world/ModuleNoSlowBreak.kt` |

---

## 6. EXPLOIT (new category — missing all ~22)

| Task | Module | LB Source |
|------|--------|-----------|
| ⬜ | Disabler (15+ modes) | `exploit/disabler/ModuleDisabler.kt` |
| ⬜ | Phase | `exploit/phase/ModulePhase.kt` |
| ✅ | PingSpoof | `exploit/ModulePingSpoof.kt` |
| ✅ | NoPitchLimit | `exploit/ModuleNoPitchLimit.kt` |
| ✅ | MoreCarry | `exploit/ModuleMoreCarry.kt` |
| ✅ | ResetVL | `exploit/ModuleResetVL.kt` |
| ✅ | ClickTp | `exploit/ModuleClickTp.kt` |
| ⬜ | Clip | `exploit/ModuleClip.kt` |
| ⬜ | Damage | `exploit/ModuleDamage.kt` |
| ⬜ | ExtendedFirework | `exploit/ModuleExtendedFirework.kt` |
| ✅ | Kick | `exploit/ModuleKick.kt` |
| ✅ | SleepWalker | `exploit/ModuleSleepWalker.kt` |
| ✅ | TimeShift | `exploit/ModuleTimeShift.kt` |
| ⬜ | VehicleOneHit | `exploit/ModuleVehicleOneHit.kt` |
| ✅ | NameCollector | `exploit/ModuleNameCollector.kt` |
| ✅ | Plugins | `exploit/ModulePlugins.kt` |
| ✅ | PortalMenu | `exploit/ModulePortalMenu.kt` |
| ✅ | AntiReducedDebugInfo | `exploit/ModuleAntiReducedDebugInfo.kt` |
| ⬜ | YggdrasilSignatureFix | `exploit/ModuleYggdrasilSignatureFix.kt` |
| ✅ | MultiActions | `exploit/ModuleMultiActions.kt` |
| ⬜ | Dupe | `exploit/dupe/ModuleDupe.kt` |
| ⬜ | ServerCrasher | `exploit/servercrasher/ModuleServerCrasher.kt` |
| ⬜ | AbortBreaking | `exploit/ModuleAbortBreaking.kt` |
| ⬜ | AntiHunger | `exploit/ModuleAntiHunger.kt` |
| ⬜ | GhostHand | `exploit/ModuleGhostHand.kt` |

---

## 7. FUN (new category — missing all ~7)

| Task | Module | LB Source |
|------|--------|-----------|
| ✅ | DankBobbing | `fun/ModuleDankBobbing.kt` |
| ✅ | Derp | `fun/ModuleDerp.kt` |
| ✅ | HandDerp | `fun/ModuleHandDerp.kt` |
| ✅ | SkinDerp | `fun/ModuleSkinDerp.kt` |
| ✅ | Twerk | `fun/ModuleTwerk.kt` |
| ⬜ | Vomit | `fun/ModuleVomit.kt` |
| ⬜ | Notebot (LB enhanced) | `fun/notebot/ModuleNotebot.kt` |

---

## 8. MISC (missing from LiquidBounce)

| Task | Module | LB Source |
|------|--------|-----------|
| ⬜ | AntiBot | `misc/antibot/ModuleAntiBot.kt` |
| ⬜ | BetterTab | `misc/ModuleBetterTab.kt` |
| ⬜ | AntiCheatDetect | `misc/ModuleAntiCheatDetect.kt` |
| ⬜ | AntiStaff | `misc/ModuleAntiStaff.kt` |
| ⬜ | AutoAccount | `misc/ModuleAutoAccount.kt` |
| ⬜ | AutoChatGame | `misc/ModuleAutoChatGame.kt` |
| ⬜ | AutoConfig | `misc/ModuleAutoConfig.kt` |
| ⬜ | AutoPearl | `misc/ModuleAutoPearl.kt` |
| ⬜ | ElytraSwap | `misc/ModuleElytraSwap.kt` |
| ⬜ | FlagCheck | `misc/ModuleFlagCheck.kt` |
| ⬜ | GUICloser | `misc/ModuleGUICloser.kt` |
| ⬜ | InventoryTracker | `misc/ModuleInventoryTracker.kt` |
| ⬜ | ItemScroller | `misc/ModuleItemScroller.kt` |
| ⬜ | Macros | `misc/ModuleMacros.kt` |
| ⬜ | MiddleClickAction | `misc/ModuleMiddleClickAction.kt` |
| ⬜ | Spammer (LB) | `misc/ModuleSpammer.kt` |
| ⬜ | TargetLock | `misc/ModuleTargetLock.kt` |
| ⬜ | Teams | `misc/ModuleTeams.kt` |
| ⬜ | TextFieldProtect | `misc/ModuleTextFieldProtect.kt` |
| ⬜ | ReportHelper | `misc/reporthelper/ModuleReportHelper.kt` |
| ⬜ | DebugRecorder | `misc/debugrecorder/ModuleDebugRecorder.kt` |

---

## Progress

- Total missing: ~160 modules
- Ported: 18
- Remaining: ~142
