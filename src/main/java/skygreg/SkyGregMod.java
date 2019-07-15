package skygreg;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gregtech.common.render.GT_MetaGenerated_Item_Renderer;
import skygreg.Items.SkyGregItems;
import skygreg.machines.Machines;
import skygreg.recipes.Recipes;

@Mod(
        modid = SkyGregMod.MOD_ID,
        name = SkyGregMod.MOD_NAME,
        version = "MC1710",
        useMetadata = false,
        dependencies = "required-after:gregtech; after:Ex Nihilo; after:IC2;"
)
public class SkyGregMod
{
    static final String MOD_ID = "skygreg";
    static final String MOD_NAME = "skygreg";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        FMLLog.info("SkyGreg loaded");
    }

    @Mod.EventHandler
    public void onPreLoad(FMLPostInitializationEvent aEvent) {
        new SkyGregItems();
        new Machines();
    }

    @Mod.EventHandler
    public void onPostLoad(FMLPostInitializationEvent aEvent) {
        new GT_MetaGenerated_Item_Renderer(); // add custom items to render list
        new Recipes();
    }
}
