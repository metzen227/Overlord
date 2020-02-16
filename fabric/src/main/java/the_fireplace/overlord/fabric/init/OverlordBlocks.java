package the_fireplace.overlord.fabric.init;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tools.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import the_fireplace.overlord.fabric.block.BloodSoakedSoil;
import the_fireplace.overlord.fabric.block.internal.CasketBlock;

import static the_fireplace.overlord.fabric.Overlord.MODID;

public class OverlordBlocks {

    public static final Block OAK_CASKET = new CasketBlock(FabricBlockSettings.copy(Blocks.OAK_PLANKS).build());
    public static final Block BLOOD_SOAKED_SOIL = new BloodSoakedSoil(FabricBlockSettings.of(Material.EARTH)
        .strength(0.5F, 0.1F)
        .sounds(BlockSoundGroup.WET_GRASS)
        .materialColor(MaterialColor.RED)
        .breakByTool(FabricToolTags.SHOVELS).build());

    public static void registerBlocks() {
        registerBlock("oak_casket", OAK_CASKET);
        registerBlockWithItem("blood_soaked_soil", BLOOD_SOAKED_SOIL, ItemGroup.BUILDING_BLOCKS);
    }

    private static void registerBlock(String path, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(MODID, path), block);
    }

    private static void registerBlockWithItem(String path, Block block, ItemGroup group) {
        registerBlock(path, block);
        Registry.register(Registry.ITEM, new Identifier(MODID, path), new BlockItem(block, new Item.Settings().group(group)));
    }
}