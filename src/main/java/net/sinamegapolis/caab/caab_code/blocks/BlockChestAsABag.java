package net.sinamegapolis.caab.caab_code.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.sinamegapolis.caab.caab_code.tileentities.TileEntityChestAsABag;
import net.sinamegapolis.caab.client.IHasModel;
import net.sinamegapolis.caab.init.ModRegistry;

import javax.annotation.Nullable;


/**
 * Created by m on 11/03/2017.
 */
public class BlockChestAsABag extends Block implements IHasModel {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    protected static final AxisAlignedBB NORTH_CHEST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0D, 0.9375D, 0.875D, 0.9375D);
    protected static final AxisAlignedBB SOUTH_CHEST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.875D, 1.0D);
    protected static final AxisAlignedBB WEST_CHEST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0625D, 0.9375D, 0.875D, 0.9375D);
    protected static final AxisAlignedBB EAST_CHEST_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 1.0D, 0.875D, 0.9375D);
    protected static final AxisAlignedBB NOT_CONNECTED_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.875D, 0.9375D);
    public static final AxisAlignedBB testCAAB = new AxisAlignedBB(0 * 0.0625, 0.0, 0 * 0.0625, 16 * 0.0625, 15 * 0.0625, 16 * 0.0625);
    public BlockChestAsABag(String name) {
        super(Material.WOOD);
        setRegistryName(name);
        setUnlocalizedName(net.sinamegapolis.caab.ChestAsABag.MODID + "." + name);
        setCreativeTab(CreativeTabs.MISC);
        ModRegistry.BLOCKS.add(this);
        ModRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
    }

    @Override
    public void registerModels() {

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this),
                0, new ModelResourceLocation(getRegistryName(), "inventory"));

    }



    @Override
    public boolean hasTileEntity(IBlockState state){
        return true;
    }

    @Nullable
    @Override
    public TileEntityChestAsABag createTileEntity(World world, IBlockState state){
         return new TileEntityChestAsABag();
    }

    public Class<TileEntityChestAsABag> getTheCAABTEsclass(){
        return TileEntityChestAsABag.class;
    }

    /**What does CAAB do when got right-clicked?*/
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {


        return true;
    }

    public TileEntityChestAsABag getTileEntity(World world,BlockPos pos){return (TileEntityChestAsABag) world.getTileEntity(pos);}

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }


    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        if(true){
            return testCAAB;
        }
        if (source.getBlockState(pos.north()).getBlock() == this)
        {
            return NORTH_CHEST_AABB;
        }
        else if (source.getBlockState(pos.south()).getBlock() == this)
        {
            return SOUTH_CHEST_AABB;
        }
        else if (source.getBlockState(pos.west()).getBlock() == this)
        {
            return WEST_CHEST_AABB;
        }
        else
        {
            return source.getBlockState(pos.east()).getBlock() == this ? EAST_CHEST_AABB : NOT_CONNECTED_AABB;
        }
    }

}
