package skygreg.machines;

import gregtech.api.enums.Textures;
import gregtech.api.enums.Textures.BlockIcons.CustomIcon;
import gregtech.api.gui.GT_Container_BasicTank;
import gregtech.api.gui.GT_GUIContainer_BasicTank;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_Hatch;
import gregtech.api.objects.GT_RenderedTexture;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidHandler;

import java.util.Arrays;

import static gregtech.api.enums.GT_Values.V;

public abstract class MachineFluidGenerator extends GT_MetaTileEntity_Hatch {

    private int mTimer = 0;

    public MachineFluidGenerator(int aID, String aName, String aNameRegional, String fluidName, String overlays, long euUsage, int productionPerTick, int aTier) {
        super(
                aID, aName, aNameRegional, aTier, 3,
                new String[]{
                        "Generates " + fluidName + " from nothing!",
                        "Produces " + productionPerTick + " mb per tick.",
                        "Consumes " + euUsage + " eu/t"
                },
                new GT_RenderedTexture(new CustomIcon("basicmachines/" + overlays + "/OVERLAY_SIDE_ACTIVE")),
                new GT_RenderedTexture(new CustomIcon("basicmachines/" + overlays + "/OVERLAY_SIDE")),
                new GT_RenderedTexture(new CustomIcon("basicmachines/" + overlays + "/OVERLAY_TOP_ACTIVE")),
                new GT_RenderedTexture(new CustomIcon("basicmachines/" + overlays + "/OVERLAY_TOP")),
                new GT_RenderedTexture(new CustomIcon("basicmachines/" + overlays + "/OVERLAY_BOTTOM_ACTIVE")),
                new GT_RenderedTexture(new CustomIcon("basicmachines/" + overlays + "/OVERLAY_BOTTOM"))
        );
    }

    public MachineFluidGenerator(String aName, int aTier, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aTier, 3, aDescription, aTextures);
    }

    public abstract FluidStack getProductionFluid();

    public abstract int getProductionPerTick();

    public abstract long getEuUsagePerTier();

    @Override
    public Object getServerGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_Container_BasicTank(aPlayerInventory, aBaseMetaTileEntity);
    }

    @Override
    public Object getClientGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_GUIContainer_BasicTank(aPlayerInventory, aBaseMetaTileEntity, getLocalName());
    }

    @Override
    public boolean doesFillContainers() {
        return true;
    }

    @Override
    public boolean doesEmptyContainers() {
        return false;
    }

    @Override
    public boolean canTankBeFilled() {
        return false;
    }

    @Override
    public boolean canTankBeEmptied() {
        return true;
    }

    @Override
    public boolean displaysItemStack() {
        return true;
    }

    @Override
    public boolean displaysStackSize() {
        return false;
    }

    @Override
    public boolean isFluidInputAllowed(FluidStack aFluid) {
        return false;
    }

    @Override
    public void onPostTick(IGregTechTileEntity aBaseMetaTileEntity, long aTick) {
        super.onPostTick(aBaseMetaTileEntity, aTick);

        if (aBaseMetaTileEntity.isServerSide() && aBaseMetaTileEntity.isAllowedToWork()) {

            if (getBaseMetaTileEntity().isUniversalEnergyStored(this.getEuUsagePerTier())) {
                if (mFluid == null) {
                    mFluid = getProductionFluid();
                    mFluid.amount = 0;
                }
                if (!mFluid.containsFluid(getFluid())) {
                    return;
                }
                if (mFluid.amount + getProductionPerTick() <= getCapacity() && consumeInput()) {
                    mFluid.amount += getProductionPerTick();
                    getBaseMetaTileEntity().decreaseStoredEnergyUnits(getEuUsagePerTier(), true);
                }
            }

            // Fill tank in front side (As output hatch)
            IFluidHandler tTileEntity = aBaseMetaTileEntity.getITankContainerAtSide(aBaseMetaTileEntity.getFrontFacing());
            if (tTileEntity != null) {
                for (boolean temp = true; temp && mFluid != null; ) {
                    temp = false;
                    FluidStack tDrained = aBaseMetaTileEntity.drain(ForgeDirection.getOrientation(aBaseMetaTileEntity.getFrontFacing()), Math.max(1, mFluid.amount), false);
                    if (tDrained != null) {
                        int tFilledAmount = tTileEntity.fill(ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()), tDrained, false);
                        if (tFilledAmount > 0) {
                            temp = true;
                            tTileEntity.fill(ForgeDirection.getOrientation(aBaseMetaTileEntity.getBackFacing()), aBaseMetaTileEntity.drain(ForgeDirection.getOrientation(aBaseMetaTileEntity.getFrontFacing()), tFilledAmount, true), true);
                        }
                    }
                }
            }
        }
    }

    private boolean consumeInput() {
        return true;
    }

    @Override
    public boolean onRightclick(IGregTechTileEntity aBaseMetaTileEntity, EntityPlayer aPlayer) {
        if (aBaseMetaTileEntity.isClientSide()) return true;
        aBaseMetaTileEntity.openGUI(aPlayer);
        return true;
    }


    @Override
    public boolean isSimpleMachine() {
        return false;
    }

    @Override
    public boolean isOverclockerUpgradable() {
        return false;
    }

    @Override
    public boolean isTransformerUpgradable() {
        return false;
    }

    @Override
    public boolean isElectric() {
        return true;
    }

    @Override
    public boolean isFacingValid(byte aFacing) {
        return true;
    }

    @Override
    public boolean isEnetInput() {
        return true;
    }

    @Override
    public boolean isInputFacing(byte aSide) {
        return true;
    }

    @Override
    public boolean isOutputFacing(byte aSide) {
        return false;
    }

    @Override
    public boolean isTeleporterCompatible() {
        return false;
    }

    @Override
    public long getMinimumStoredEU() {
        return V[mTier] * 16;
    }

    @Override
    public long maxEUStore() {
        return V[mTier] * 64;
    }

    @Override
    public long maxEUInput() {
        return V[mTier];
    }

    @Override
    public long maxSteamStore() {
        return maxEUStore();
    }

    @Override
    public long maxAmperesIn() {
        return 2;
    }

    @Override
    public int getStackDisplaySlot() {
        return 2;
    }

    @Override
    public boolean isAccessAllowed(EntityPlayer aPlayer) {
        return true;
    }


    @Override
    public int getCapacity() {
        return 16000 * this.mTier;
    }

    @Override
    public int getTankPressure() {
        return 100;
    }

    @Override
    public ITexture[] getTexturesActive(ITexture aBaseTexture) {
        return new ITexture[]{aBaseTexture, new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPE_OUT)};
    }

    @Override
    public ITexture[] getTexturesInactive(ITexture aBaseTexture) {
        return new ITexture[]{aBaseTexture, new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPE_OUT)};
    }


    @Override
    public ITexture[] getTexture(IGregTechTileEntity aBaseMetaTileEntity, byte aSide, byte aFacing, byte aColorIndex, boolean aActive, boolean aRedstone) {
        int index = 0;
        if (aSide == 1) index = 2;
        if (aSide == 0) index = 4;
        if (aSide == aFacing) index += 6;
        if (aActive) index ^= 1;
        return mTextures[index][aColorIndex+1];
    }


    @Override
    public ITexture[][][] getTextureSet(ITexture[] aTextures) {
        ITexture[][][] rTextures = new ITexture[12][17][];
        aTextures = Arrays.copyOf(aTextures, 12);

        for (int i = 0; i < aTextures.length; i++)
            if (aTextures[i] != null) for (byte c = -1; c < 16; c++) {
                if (rTextures[i][c + 1] == null)
                    rTextures[i][c + 1] = new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][c + 1], aTextures[i]};
            }

        for (byte c = -1; c < 16; c++) {
            if (rTextures[0][c + 1] == null) rTextures[0][c + 1] = getSideFacingActive(c);
            if (rTextures[1][c + 1] == null) rTextures[1][c + 1] = getSideFacingInactive(c);

            if (rTextures[2][c + 1] == null) rTextures[2][c + 1] = getTopFacingActive(c);
            if (rTextures[3][c + 1] == null) rTextures[3][c + 1] = getTopFacingInactive(c);

            if (rTextures[4][c + 1] == null) rTextures[4][c + 1] = getBottomFacingActive(c);
            if (rTextures[5][c + 1] == null) rTextures[5][c + 1] = getBottomFacingInactive(c);

            if (rTextures[6][c + 1] == null) rTextures[6][c + 1] = getSideFacingPipeActive(c);
            if (rTextures[7][c + 1] == null) rTextures[7][c + 1] = getSideFacingPipeInactive(c);

            if (rTextures[8][c + 1] == null) rTextures[8][c + 1] = getTopFacingPipeActive(c);
            if (rTextures[9][c + 1] == null) rTextures[9][c + 1] = getTopFacingPipeInactive(c);

            if (rTextures[10][c + 1] == null) rTextures[10][c + 1] = getBottomFacingPipeActive(c);
            if (rTextures[11][c + 1] == null) rTextures[11][c + 1] = getBottomFacingPipeInactive(c);
        }
        return rTextures;
    }

    public ITexture[] getSideFacingActive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1]};
    }

    public ITexture[] getSideFacingInactive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1]};
    }

    public ITexture[] getTopFacingActive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1]};
    }

    public ITexture[] getTopFacingInactive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1]};
    }

    public ITexture[] getBottomFacingActive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1]};
    }

    public ITexture[] getBottomFacingInactive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1]};
    }

    public ITexture[] getBottomFacingPipeActive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPE_OUT)};
    }

    public ITexture[] getBottomFacingPipeInactive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPE_OUT)};
    }

    public ITexture[] getTopFacingPipeActive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPE_OUT)};
    }

    public ITexture[] getTopFacingPipeInactive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPE_OUT)};
    }

    public ITexture[] getSideFacingPipeActive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPE_OUT)};
    }

    public ITexture[] getSideFacingPipeInactive(byte aColor) {
        return new ITexture[]{Textures.BlockIcons.MACHINE_CASINGS[mTier][aColor + 1], new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_PIPE_OUT)};
    }
}
