package com.ankamagames.dofus.network.messages.game.context.roleplay.job;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.job.JobExperience;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class JobExperienceUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public JobExperience experiencesUpdate;
  private FuncTree _experiencesUpdatetree;
  public static final int protocolId = 5654;

  public void serialize(ICustomDataOutput param1) {
    this.experiencesUpdate.serializeAs_JobExperience(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.experiencesUpdate = new JobExperience();
    this.experiencesUpdate.deserialize(param1);
  }
}
