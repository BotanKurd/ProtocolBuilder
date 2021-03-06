package com.ankamagames.dofus.network.messages.game.context.roleplay.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.FightCommonInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayShowChallengeMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public FightCommonInformations commonsInfos;
  private FuncTree _commonsInfostree;
  public static final int protocolId = 301;

  public void serialize(ICustomDataOutput param1) {
    this.commonsInfos.serializeAs_FightCommonInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.commonsInfos = new FightCommonInformations();
    this.commonsInfos.deserialize(param1);
  }
}
