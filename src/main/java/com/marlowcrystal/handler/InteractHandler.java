package com.marlowcrystal.handler;

import com.marlowcrystal.MarlowCrystal;
import com.marlowcrystal.tools.TieredUtils;
import com.marlowcrystal.tools.ToolTier;
import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.game.ServerboundInteractPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Unique;

public class InteractHandler implements ServerboundInteractPacket.Handler {

    @Unique
    private final Minecraft client;

    public InteractHandler(Minecraft client) {
        this.client = client;
    }

    @Unique
    private static boolean isTool(ItemStack itemStack) {
        Item item = itemStack.getItem();

        // Check if it's a valid tool and belongs to DIAMOND or higher
        ToolTier tier = TieredUtils.getTier(item);
        return tier.getLevel() >= ToolTier.DIAMOND.getLevel();
    }

    @Override
    public void onInteraction(InteractionHand interactionHand) {
    }

    @Override
    public void onInteraction(InteractionHand interactionHand, Vec3 vec3) {

    }

    @Override
    public void onAttack() {
        HitResult hitResult = client.hitResult;
        if (hitResult == null || hitResult.getType() != HitResult.Type.ENTITY) {
            return;
        }

        EntityHitResult entityHitResult = (EntityHitResult) hitResult;
        Entity entity = entityHitResult.getEntity();

        if (entity instanceof EndCrystal) {
            MobEffectInstance weakness = client.player.getEffect(MobEffects.WEAKNESS);
            MobEffectInstance strength = client.player.getEffect(MobEffects.DAMAGE_BOOST);

            if (weakness != null && (strength == null || strength.getAmplifier() <= weakness.getAmplifier()) && !isTool(client.player.getMainHandItem())) {
                return;
            }

            entity.remove(Entity.RemovalReason.KILLED);
            entity.gameEvent(GameEvent.ENTITY_DIE);
            client.player.playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, 1.0F, 1.0F);
            entity.discard();
        }
    }
}
