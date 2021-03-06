package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorDialogQuestionBasicMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public BasicGuildInformations guildInfo;
  private FuncTree _guildInfotree;
  public static final int protocolId = 5619;

  public void serialize(ICustomDataOutput param1) {
    this.guildInfo.serializeAs_BasicGuildInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.guildInfo = new BasicGuildInformations();
    this.guildInfo.deserialize(param1);
  }
}
