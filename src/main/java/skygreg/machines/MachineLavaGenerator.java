package skygreg.machines;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.util.GT_ModHandler;
import net.minecraftforge.fluids.FluidStack;

public class MachineLavaGenerator extends MachineFluidGenerator {

    private final static String[] nameByTier = {
            "None",
            "Basic Lava Generator",
            "Advanced Lava Generator",
            "Turbo Lava Generator",
            "Boosted Lava Generator",
            "Turbo Lava Generator",
            "Ultimate Lava Generator",
            "Lava Generator 3000",
            "Lava Generator X",
    };

    public MachineLavaGenerator(int aID, int aTier) {
        super(
                aID,
                "lavagen.tier." + aTier, nameByTier[aTier],
                "lava",
                "lavagen",
                (16 * ((long) Math.pow(4, aTier - 1))),
                8 * ((int) Math.pow(2, aTier - 1)),
                aTier
        );
    }

    public MachineLavaGenerator(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, aDescription, aTextures);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MachineLavaGenerator(this.mName, this.mTier, this.mDescriptionArray, this.mTextures);
    }

    @Override
    public FluidStack getProductionFluid() {
        return GT_ModHandler.getLava(1L);
    }

    @Override
    public int getProductionPerTick() {
        return 8 * ((int) Math.pow(2, mTier - 1));
    }

    @Override
    public long getEuUsagePerTier() {
        return (16 * ((long) Math.pow(4, mTier - 1)));
    }
}
