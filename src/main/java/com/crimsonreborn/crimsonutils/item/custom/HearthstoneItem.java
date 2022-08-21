package com.crimsonreborn.crimsonutils.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/**
 * Created by Furt on 08/21/2022
 */
public class HearthstoneItem extends Item {
    public HearthstoneItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            outputRandomNumber(player);
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }

    private void outputRandomNumber(Player player) {
        player.sendSystemMessage(Component.literal("Your Number is " + getRandomNumber()));
    }

    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }

    /*
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn,
                                                    World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if (!worldIn.isRemote) {
            if (hand.equals(EnumHand.MAIN_HAND)) {
                Waypoint h = new Waypoint(playerIn, "home", Waypoints.HOME);
                if (playerIn.isSneaking()) {
                    h.setWaypoint();
                    playerIn.addChatMessage(new TextComponentString(
                            TextFormatting.GOLD + "Home location is set."));
                } else {
                    Location l = h.getWaypoint();
                    if (l != null) {
                        playerIn.setPositionAndUpdate(l.getX(), l.getY(),
                                l.getZ());
                        playerIn.addChatMessage(new TextComponentString(
                                TextFormatting.GOLD
                                        + "Teleporting to home location."));
                    } else {
                        playerIn.addChatMessage(new TextComponentString(
                                TextFormatting.GOLD
                                        + "Home location is not set."));
                        playerIn.addChatMessage(new TextComponentString(
                                TextFormatting.GOLD
                                        + "To set home hold shift and right click."));
                    }
                }

                h.destroy();
                return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
            }
        }
        return new ActionResult(EnumActionResult.PASS, itemStackIn);
    } */
}
