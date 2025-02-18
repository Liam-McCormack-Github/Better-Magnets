package com.theundertaker11.bettermagnets.randomthings.block;

import com.theundertaker11.bettermagnets.blocks.BlockContainerBase;

/*public class AdvancedItemCollector extends BlockContainerBase
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing");

	protected static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB(0.375F, 0.375F, 1.0F - 5 / 16.0F, 0.625F, 0.625F, 1.0F);
	protected static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB(0.375F, 0.375F, 0.0F, 0.625F, 0.625F, 5 / 16.0F);
	protected static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(1.0F - 5 / 16.0F, 0.375F, 0.375F, 1.0F, 0.625F, 0.625F);
	protected static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(0.0F, 0.375F, 0.375F, 5 / 16.0F, 0.625F, 0.625F);
	protected static final AxisAlignedBB UP_AABB = new AxisAlignedBB(0.375F, 0.0F, 0.375F, 0.625F, 0.0F + 5 / 16.0F, 0.625F);
	protected static final AxisAlignedBB DOWN_AABB = new AxisAlignedBB(0.375F, 1.0F - 5 / 16.0F, 0.375F, 0.625F, 1.0F, 0.625F);

	protected BlockAdvancedItemCollector()
	{
		super("advancedItemCollector", Material.ROCK);

		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
		this.setHardness(0.3F);
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		TileEntityAdvancedItemCollector tileentity = (TileEntityAdvancedItemCollector) worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, tileentity.getInventory());

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(FACING, EnumFacing.values()[meta]);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(FACING).ordinal();
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityAdvancedItemCollector();
	}

	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side)
	{
		return func_181088_a(worldIn, pos, side.getOpposite());
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		for (EnumFacing enumfacing : EnumFacing.values())
		{
			if (func_181088_a(worldIn, pos, enumfacing))
			{
				return true;
			}
		}

		return false;
	}

	protected static boolean func_181088_a(World p_181088_0_, BlockPos p_181088_1_, EnumFacing p_181088_2_)
	{
		return p_181088_2_ == EnumFacing.DOWN && isBlockInventory(p_181088_0_, p_181088_1_.down(), p_181088_2_) ? true : isBlockInventory(p_181088_0_, p_181088_1_.offset(p_181088_2_), p_181088_2_);
	}

	private static boolean isBlockInventory(World worldObj, BlockPos pos, EnumFacing facing)
	{
		TileEntity te = worldObj.getTileEntity(pos);

		if (te == null)
		{
			return false;
		}

		return te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing.getOpposite());
	}

	/**
	 * Called by ItemBlocks just before a block is actually set in the world, to
	 * allow for adjustments to the IBlockstate
	 *
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return func_181088_a(worldIn, pos, facing.getOpposite()) ? this.getDefaultState().withProperty(FACING, facing) : this.getDefaultState().withProperty(FACING, EnumFacing.DOWN);
	}

	/**
	 * Called when a neighboring block changes.
	 *
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock, BlockPos changedPos)
	{
		if (this.checkForDrop(worldIn, pos, state) && !func_181088_a(worldIn, pos, state.getValue(FACING).getOpposite()))
		{
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
		}
	}

	private boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
	{
		if (this.canPlaceBlockAt(worldIn, pos))
		{
			return true;
		}
		else
		{
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
			return false;
		}
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		EnumFacing enumfacing = state.getValue(FACING);
		switch (enumfacing)
		{
		case EAST:
			return EAST_AABB;
		case WEST:
			return WEST_AABB;
		case SOUTH:
			return SOUTH_AABB;
		case NORTH:
			return NORTH_AABB;
		case UP:
			return UP_AABB;
		case DOWN:
			return DOWN_AABB;
		}

		return UP_AABB;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!worldIn.isRemote)
		{
			playerIn.openGui(RandomThings.instance, GuiIds.ADVANCED_ITEM_COLLECTOR, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}
	
}
*/