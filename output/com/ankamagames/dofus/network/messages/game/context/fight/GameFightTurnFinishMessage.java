package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightTurnFinishMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean isAfk = false;
  public static final int protocolId = 718;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.isAfk);
  }

  public void deserialize(ICustomDataInput param1) {
    this.isAfk = param1.readBoolean();
  }
}
