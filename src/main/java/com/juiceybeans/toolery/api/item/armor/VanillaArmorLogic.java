package com.juiceybeans.toolery.api.item.armor;

import com.google.common.collect.Multimap;
import com.gregtechceu.gtceu.api.item.armor.ArmorComponentItem;
import com.gregtechceu.gtceu.api.item.armor.IArmorLogic;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.juiceybeans.toolery.Toolery;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VanillaArmorLogic implements IArmorLogic {
    private final ArmorItem.Type type;
    private final String armorTexture;
    private final int tint;

    public VanillaArmorLogic(ArmorItem.Type type, String armorTexture, int tint) {
        this.type = type;
        this.armorTexture = armorTexture;
        this.tint = tint;
    }

    public VanillaArmorLogic(ArmorItem.Type type, String armorTexture) {
        this.type = type;
        this.armorTexture = armorTexture;
        this.tint = GTMaterials.Uraninite.getMaterialRGB();
    }

    @Override
    public ArmorItem.Type getArmorType() {
        return this.type;
    }

    @Override
    public int getArmorDisplay(Player player, @NotNull ItemStack armor, EquipmentSlot slot) {
        return 6;
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return slot != EquipmentSlot.LEGS ?
                Toolery.id(String.format("textures/armor/%s_layer_1.png", armorTexture)) :
                Toolery.id(String.format("textures/armor/%s_layer_2.png", armorTexture));
    }

    @Override
    public void addToolComponents(ArmorComponentItem item) {
        IArmorLogic.super.addToolComponents(item);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        return IArmorLogic.super.getAttributeModifiers(slot, stack);
    }

    @Override
    public int getArmorLayerColor(ItemStack itemStack, int layerIndex) {
        return IArmorLogic.super.getArmorLayerColor(itemStack, tint);
    }


}
