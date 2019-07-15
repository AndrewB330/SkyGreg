package skygreg.recipes;

import exnihilo.ENBlocks;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import skygreg.Items.SkyGregItems;

public class SieveRecipeLoader {

    public SieveRecipeLoader() {
        addSieveRecipe(
                new ItemStack(Blocks.gravel, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.WroughtIron),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Iron),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Pyrite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Copper),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Chalcopyrite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Tin),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cassiterite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cobaltite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Magnetite),
                        },
                new int[]{750, 750, 1700, 1700, 600, 400, 500, 500},
                60, 8
        );

        addSieveRecipe(
                new ItemStack(Blocks.sand, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.WroughtIron),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Coal),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lignite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Quartzite),
                        },
                new int[]{3300, 3300, 800},
                60, 8
        );
        addSieveRecipe(
                new ItemStack(ENBlocks.NetherGravel, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.WroughtIron),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Redstone),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cinnabar),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lapis),
                        },
                new int[]{1250, 1250, 1000},
                60, 8
        );
        addSieveRecipe(
                new ItemStack(Blocks.clay, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.WroughtIron),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Salt),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.RockSalt),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lithium),
                        },
                new int[]{2500, 2500, 300},
                60, 8
        );

        addSieveRecipe(
                new ItemStack(ENBlocks.Dust, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.WroughtIron),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Sulfur),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Saltpeter),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Zinc),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Tetrahedrite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Stibnite),
                        },
                new int[]{1000, 500, 500, 2500, 200},
                60, 8
        );

        addSieveRecipe(
                new ItemStack(Blocks.gravel, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Diamond),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Diamond),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Graphite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Coal),
                                GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Diamond, 1L),
                        },
                new int[]{1000, 2000, 2500, 100},
                60, 8
        );
    }


    public static boolean addSieveRecipe(ItemStack aItemToSieve, ItemStack meshItem, ItemStack[] aSievedItems, int[] aChances, int aDuration, int aEUt) {
        ItemStack mesh = GT_Utility.copyAmount(0, meshItem);

        if ((aItemToSieve == null) || (aSievedItems == null)) {
            return false;
        }
        for (ItemStack tStack : aSievedItems) {
            if (tStack != null) {
                if ((aDuration = GregTech_API.sRecipeFile.get("mesh", aItemToSieve, aDuration)) <= 0) {
                    return false;
                }
                Recipes.sSieveRecipes.addRecipe(true, new ItemStack[]{aItemToSieve, mesh}, aSievedItems, null, aChances, null, null, aDuration, aEUt, 0);
                return true;
            }
        }
        return false;
    }
}
