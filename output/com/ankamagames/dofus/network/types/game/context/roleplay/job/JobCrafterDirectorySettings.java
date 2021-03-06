package com.ankamagames.dofus.network.types.game.context.roleplay.job;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobCrafterDirectorySettings extends Object implements INetworkType {

  public int jobId = 0;
  public int minLevel = 0;
  public boolean free = false;
  public static final int protocolId = 97;

  public void serialize(ICustomDataOutput param1) {
    if (this.jobId < 0) {
      throw new Exception("Forbidden value (" + this.jobId + ") on element jobId.");
    }
    param1.writeByte(this.jobId);
    if (this.minLevel < 0 || this.minLevel > 255) {
      throw new Exception("Forbidden value (" + this.minLevel + ") on element minLevel.");
    }
    param1.writeByte(this.minLevel);
    param1.writeBoolean(this.free);
  }

  public void deserialize(ICustomDataInput param1) {
    this.jobId = param1.readByte();
    if (this.jobId < 0) {
      throw new Exception(
          "Forbidden value (" + this.jobId + ") on element of JobExperience.jobId.");
    }

    this.minLevel = param1.readUnsignedByte();
    if (this.minLevel < 0 || this.minLevel > 255) {
      throw new Exception(
          "Forbidden value ("
              + this.minLevel
              + ") on element of JobCrafterDirectorySettings.minLevel.");
    }

    this.free = param1.readBoolean();
  }
}
