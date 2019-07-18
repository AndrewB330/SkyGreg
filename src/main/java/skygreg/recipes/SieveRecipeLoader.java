package skygreg.recipes;

import exnihilo.ENBlocks;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import skygreg.Items.SkyGregItems;

public class SieveRecipeLoader {

    public SieveRecipeLoader() {
        //Steam and LV (32)
        addSieveRecipe(
                new ItemStack(Blocks.gravel, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.WroughtIron),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Iron),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Pyrite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Magnetite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Copper),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Chalcopyrite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Tin),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cassiterite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cobaltite),
                        },
                new int[]{800, 800, 400, 1500, 1500, 600, 200, 500},
                400, 16
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
                new int[]{3330, 3330, 800},
                400, 16
        );

        addSieveRecipe(
                new ItemStack(ENBlocks.Dust, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.WroughtIron),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Redstone),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cinnabar),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lapis),
                        },
                new int[]{1250, 500, 1000},
                400, 16
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
                new int[]{2000, 2000, 200},
                400, 16
        );

//LV (32)
        addSieveRecipe(
                new ItemStack(Blocks.gravel, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Cobalt),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Pyrite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Magnetite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Copper),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Chalcopyrite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Tin),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cassiterite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cobaltite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Galena),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Nickel),
                        },
                new int[]{1300, 700, 1700, 1700, 800, 200, 600, 1500, 1500},
                400, 20
        );

        addSieveRecipe(
                new ItemStack(Blocks.sand, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Cobalt),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Coal),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lignite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Aluminium),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Bauxite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Quartzite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.CertusQuartz),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Oilsands),
                        },
                new int[]{2500, 2500, 400, 1000, 1000, 1000, 1500},
                400, 20
        );

        addSieveRecipe(
                new ItemStack(ENBlocks.Dust, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Cobalt),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Redstone),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cinnabar),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lapis),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lazurite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Sodalite),
                        },

                new int[]{1250, 1250, 500, 500, 500},
                400, 20
        );

        addSieveRecipe(
                new ItemStack(Blocks.clay, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Cobalt),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Salt),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.RockSalt),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lithium),
                        },
                new int[]{2500, 2500, 350},
                400, 20
        );

        addSieveRecipe(
                new ItemStack(ENBlocks.NetherGravel),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Cobalt),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Sulfur),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Saltpeter),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Zinc),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Tetrahedrite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.NetherQuartz),
                                GT_Utility.copyAmount(1, OrePrefixes.dustSmall.get(Materials.Glowstone)),
                        },
                new int[]{1500, 700, 500, 1500, 2500, 3300},
                400, 20
        );
//MV (128)
        addSieveRecipe(
                new ItemStack(Blocks.gravel, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Electrum),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.BrownLimonite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.YellowLimonite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Chalcopyrite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Malachite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cobaltite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Garnierite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Nickel),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Tantalite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Pyrolusite),
                        },
                new int[]{1000, 1000, 1500, 1500, 800, 400, 800, 700, 500},
                300, 80
        );
//Grinding
        addSieveRecipe(
                new ItemStack(Blocks.gravel, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Diamond),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Bismuth),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Silver),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Gold),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Magnetite),

                        },
                new int[]{50, 1200, 1000, 2500},
                900, 40
        );

        addSieveRecipe(
                new ItemStack(Blocks.sand, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Electrum),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Apatite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Phosphorus),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Phosphate),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Aluminium),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Bauxite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Quartzite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.CertusQuartz),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Oilsands),
                        },
                new int[]{1500, 1000, 500, 300, 1200, 800, 1200, 1500},
                300, 80
        );


        addSieveRecipe(
                new ItemStack(Blocks.sand, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Diamond),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Ruby),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Sapphire),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.GreenSapphire),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Diamond),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Graphite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Emerald),
                        },
                new int[]{800, 1200, 1200, 400, 1000, 300},
                300, 80
        );
        addSieveRecipe(
                new ItemStack(ENBlocks.Dust, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Electrum),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Redstone),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cinnabar),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Ruby),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lapis),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lazurite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Sodalite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Soapstone),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Talc),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Glauconite),
                        },

                new int[]{1250, 1250, 400, 800, 800, 800, 1100, 1100, 1100},
                300, 80
        );

        addSieveRecipe(
                new ItemStack(Blocks.clay, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Electrum),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Salt),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.RockSalt),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lithium),
                        },
                new int[]{2500, 2500, 700},
                300, 80
        );

//HV (512)
        addSieveRecipe(
                new ItemStack(Blocks.gravel, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.RedSteel),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Magnetite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Chalcopyrite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Garnierite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Tantalite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Uranium),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Ilmenite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Palladium),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Neodymium),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Grossular),
                        },
                new int[]{800, 1200, 1000, 1000, 1500, 1000, 250, 300, 700},
                200, 320
        );

        addSieveRecipe(
                new ItemStack(Blocks.sand, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Uranium235),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Olivine),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Emerald),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Bentonite),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Beryllium),
                        },
                new int[]{1200, 800, 2200, 1200},
                200, 320
        );

//Grinding
        addSieveRecipe(
                new ItemStack(ENBlocks.Dust, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Amber),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Redstone),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Cinnabar),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Ruby),
                        },
                new int[]{3000, 1500, 2000},
                600, 160
        );
//Grinding
        addSieveRecipe(
                new ItemStack(ENBlocks.Dust, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.Uranium235),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Sapphire),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.GreenSapphire),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Pyrope),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Almandine),
                        },
                new int[]{2000, 1500, 2000, 2000},
                200, 320
        );

        addSieveRecipe(
                new ItemStack(Blocks.clay, 1, 0),
                SkyGregItems.mesh.getAndMarkUsed(Materials.RedSteel),
                new ItemStack[]
                        {
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Salt),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.RockSalt),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lithium),
                                SkyGregItems.oreChunk.getAndMarkUsed(Materials.Lepidolite),
                        },
                new int[]{3000, 3000, 1000, 500},
                200, 320
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
