package skygreg.Items;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class OreChunkItem extends CustomItem {
    OreChunkItem() {
        super("Ore Chunk", "ore_chunk");
    }

    @Override
    public void registerMaterial(Materials material) {
        GT_OreDictUnificator.add(OrePrefixes.ore, material, GT_Utility.copyAmount(1, get(material)));
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
