package com.net.jd.primevoidcraft.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EightBallItem extends Item {
    public EightBallItem(Properties properties){
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            outputRandomNumber(player);
            player.getCooldowns().addCooldown(this, 10);
        }

        return super.use(level, player, hand);
    }

    private void outputRandomNumber(Player player){
        player.sendSystemMessage(Component.literal("Seu número é " + getRandomNumber()));
    }

    private int getRandomNumber(){
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}
