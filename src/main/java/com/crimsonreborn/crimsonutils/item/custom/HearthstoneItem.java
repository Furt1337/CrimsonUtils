package com.crimsonreborn.crimsonutils.item.custom;

import com.crimsonreborn.crimsonutils.db.Waypoint;
import net.minecraft.network.chat.Component;
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
            Waypoint h = new Waypoint(player, "home", Waypoint.Waypoints.HOME);

            if (player.isCrouching()) {
                h.setWaypoint();
                player.sendSystemMessage(Component.literal("Home location is set."));
            } else {
                // TODO send to save home location or warn if null
                if (h != null) {
                    player.teleportTo(h.getWaypoint().getX(), h.getWaypoint().getY(), h.getWaypoint().getZ());

                    /*
                     * Ticks = minutes * seconds * ticks/per second
                     *  TODO minutes will be in settings
                     */
                    int ticks = 2 * 60 * 20;
                    player.getCooldowns().addCooldown(this, ticks);

                    player.sendSystemMessage(Component.literal("Teleporting to home location."));
                } else {
                    player.sendSystemMessage(Component.literal("Home location is not set."));
                    player.sendSystemMessage(Component.literal("To set home hold shift and right click."));
                }

            }
            h.destroy();
        }

        return super.use(level, player, hand);
    }
}
