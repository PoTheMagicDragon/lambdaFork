package com.lambda.client.manager.managers.activity.activities.interaction

import com.lambda.client.event.SafeClientEvent
import com.lambda.client.manager.managers.activity.Activity
import com.lambda.client.manager.managers.activity.activities.InstantActivity
import com.lambda.client.manager.managers.activity.activities.inventory.SwapOrMoveToItem
import com.lambda.client.util.EntityUtils.flooredPosition
import com.lambda.client.util.items.item
import com.lambda.client.util.math.Direction
import net.minecraft.block.Block
import net.minecraft.init.Items
import net.minecraft.util.math.BlockPos

class PlaceAndBreakBlock(private val block: Block) : InstantActivity, Activity() {
    override fun SafeClientEvent.onInitialize() {
        addSubActivities(
            SwapOrMoveToItem(block.item),
            PlaceBlock(
                BlockPos(player.flooredPosition.add(Direction.fromEntity(player).directionVec)),
                block
            ),
            SwapOrMoveToItem(Items.DIAMOND_PICKAXE),
            BreakBlock(
                BlockPos(player.flooredPosition.add(Direction.fromEntity(player).directionVec))
            )
        )
    }
}