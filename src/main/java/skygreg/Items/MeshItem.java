package skygreg.Items;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Utility;
import gregtech.common.GT_Proxy;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class MeshItem extends CustomItem {

    MeshItem() {
        super("Mesh", "mesh");
    }

    @Override
    public void registerMaterial(Materials material, ItemStack stack) {
        GT_ModHandler.addCraftingRecipe(
                GT_Utility.copyAmount(1L, stack),
                GT_Proxy.tBits, new Object[]{
                        "SRS",
                        "RSR",
                        "SRS",
                        'S', new ItemStack(Items.string, 1),
                        'R', OrePrefixes.stick.get(material)
                }
        );
    }

    @Override
    public boolean doGenerateItem(Materials material) {
        return material != null;
    }

    @Override
    public int getItemStackLimit() {
        return 1;
    }
}