package com.ankamagames.dofus.network.messages.game.context.fight.challenge;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChallengeResultMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int challengeId = 0;
  public boolean success = false;
  public static final int protocolId = 6019;

  public void serialize(ICustomDataOutput param1) {
    if (this.challengeId < 0) {
      throw new Exception("Forbidden value (" + this.challengeId + ") on element challengeId.");
    }
    param1.writeVarShort(this.challengeId);
    param1.writeBoolean(this.success);
  }

  public void deserialize(ICustomDataInput param1) {
    this.challengeId = param1.readVarUhShort();
    if (this.challengeId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.challengeId
              + ") on element of ChallengeTargetUpdateMessage.challengeId.");
    }

    this.success = param1.readBoolean();
  }
}
