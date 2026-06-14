/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jokemod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.jokemod.JokemodMod;

@EventBusSubscriber
public class JokemodModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JokemodMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(JokemodModBlocks.TRIPMINE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(JokemodModItems.TRIPSTUD.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(JokemodModItems.STUD_SMASHER.get());
			tabData.accept(JokemodModItems.BRICK_WALL_HELMET.get());
			tabData.accept(JokemodModItems.BRICK_WALL_CHESTPLATE.get());
			tabData.accept(JokemodModItems.BRICK_WALL_LEGGINGS.get());
			tabData.accept(JokemodModItems.BRICK_WALL_BOOTS.get());
			tabData.accept(JokemodModItems.CURD_MACE.get());
			tabData.accept(JokemodModItems.THE_KNIFE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(JokemodModItems.RAKE.get());
			tabData.accept(JokemodModItems.METAL_BAT.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(JokemodModItems.CURD.get());
			tabData.accept(JokemodModItems.STEROID.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(JokemodModBlocks.CURD_BLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(JokemodModItems.BLOOD_GUSHER_SPAWN_EGG.get());
		}
	}
}