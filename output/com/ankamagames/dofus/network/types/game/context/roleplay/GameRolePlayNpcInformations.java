package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayNpcInformations extends GameRolePlayActorInformations
    implements INetworkType {

  public int npcId = 0;
  public boolean sex = false;
  public int specialArtworkId = 0;
  public static final int protocolId = 156;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.contextualId + ") on element contextualId.");
    }
    param1.writeDouble(this.contextualId);
    this.look.serializeAs_EntityLook(param1);
    param1.writeShort(this.disposition.getTypeId());
    this.disposition.serialize(param1);

    if (this.npcId < 0) {
      throw new Exception("Forbidden value (" + this.npcId + ") on element npcId.");
    }
    param1.writeVarShort(this.npcId);
    param1.writeBoolean(this.sex);
    if (this.specialArtworkId < 0) {
      throw new Exception(
          "Forbidden value (" + this.specialArtworkId + ") on element specialArtworkId.");
    }
    param1.writeVarShort(this.specialArtworkId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.npcId = param1.readVarUhShort();
    if (this.npcId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.npcId
              + ") on element of TreasureHuntStepFollowDirectionToHint.npcId.");
    }

    this.sex = param1.readBoolean();

    this.specialArtworkId = param1.readVarUhShort();
    if (this.specialArtworkId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.specialArtworkId
              + ") on element of GameRolePlayNpcInformations.specialArtworkId.");
    }
  }
}
