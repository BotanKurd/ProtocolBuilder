package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.EntityMovementInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameContextMoveElementMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public EntityMovementInformations movement;
  private FuncTree _movementtree;
  public static final int protocolId = 253;

  public void serialize(ICustomDataOutput param1) {
    this.movement.serializeAs_EntityMovementInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.movement = new EntityMovementInformations();
    this.movement.deserialize(param1);
  }
}
