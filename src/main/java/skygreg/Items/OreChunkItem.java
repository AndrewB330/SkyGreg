package skygreg.Items;

import gregtech.api.enums.Materials;
import net.minecraft.item.ItemStack;
import skygreg.recipes.OreChunkRecipeLoader;

public class OreChunkItem extends CustomItem {
    OreChunkItem() {
        super("Ore Chunk", "ore_chunk");
    }

    @Override
    public void registerMaterial(Materials material, ItemStack stack) {
        String oreDictName = "oreChunk" + material.mName;
        OreChunkRecipeLoader.registerOre(material, stack);
    }

    @Override
    public boolean doGenerateItem(Materials material) {
        return material != null;
    }

    @Override
    public int getItemStackLimit() {
        return 64;
    }
}
