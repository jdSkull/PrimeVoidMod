package com.net.jd.primevoidcraft.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BallExplosion extends Item {
    public BallExplosion(Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player,  InteractionHand hand){
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            ItemStack itemStack = player.getItemInHand(hand);

            explode(level, player.getX(), player.getY(), player.getZ());
            itemStack.shrink(1);
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            components.add(Component.literal("Ao clicar com botão direito do mouse uma explosão acontecera.")
                    .withStyle(ChatFormatting.RED));
        }else {
            components.add(Component.literal("Aperte SHIFT para ver as informações do item.")
                    .withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(stack, level, components, flag);
    }

    public void explode(Level level, double x, double y, double z){
        level.explode(null, x, y, z, 10.0f, true, Explosion.BlockInteraction.DESTROY);
    }

}
