package skygreg.machines;

import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.util.GT_ModHandler;
import net.minecraftforge.fluids.FluidStack;

public class MachineWaterGenerator extends MachineFluidGenerator {

    private final static String[] nameByTier = {
            "None",
            "Basic Water Generator",
            "Advanced Water Generator",
            "Turbo Water Generator",
            "Boosted Water Generator",
            "Turbo Water Generator",
            "Ultimate Water Generator",
            "Water generator 3000",
            "Water generator X",
    };

    public MachineWaterGenerator(int aID, int aTier) {
        super(
                aID,
                "watergen.tier." + aTier, nameByTier[aTier],
                "water",
                "watergen",
                (16 * ((long) Math.pow(4, aTier - 1))),
                32 * ((int) Math.pow(2, aTier - 1)),
                aTier
        );
    }

    public MachineWaterGenerator(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, aDescription, aTextures);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new MachineWaterGenerator(this.mName, this.mTier, this.mDescriptionArray, this.mTextures);
    }

    @Override
    public FluidStack getProductionFluid() {
        return GT_ModHandler.getWater(1L);
    }

    @Override
    public int getProductionPerTick() {
        return 32 * ((int) Math.pow(2, mTier - 1));
    }

    @Override
    public long getEuUsagePerTier() {
        return (16 * ((long) Math.pow(4, mTier - 1)));
    }
}
