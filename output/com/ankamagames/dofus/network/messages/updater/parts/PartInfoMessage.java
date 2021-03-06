package com.ankamagames.dofus.network.messages.updater.parts;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.updater.ContentPart;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartInfoMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public ContentPart part;
  public Number installationPercent = 0;
  private FuncTree _parttree;
  public static final int protocolId = 1508;

  public void serialize(ICustomDataOutput param1) {
    this.part.serializeAs_ContentPart(param1);
    param1.writeFloat(this.installationPercent);
  }

  public void deserialize(ICustomDataInput param1) {
    this.part = new ContentPart();
    this.part.deserialize(param1);
    this.installationPercent = param1.readFloat();
  }
}
