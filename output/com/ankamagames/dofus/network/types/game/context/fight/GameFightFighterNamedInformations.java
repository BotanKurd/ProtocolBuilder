package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightFighterNamedInformations extends GameFightFighterInformations implements INetworkType {

    private int protocolId = 158;
    private String name = "";
    private PlayerStatus status;
    private FuncTree _statustree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_GameContextActorInformations(param1);
         param1.writeByte(this.teamId);
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element wave.");
         }
         param1.writeByte(this.wave);
         param1.writeBoolean(this.alive);
         param1.writeShort(this.stats.getTypeId());
         this.stats.serialize(param1);
         param1.writeShort(this.previousPositions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.previousPositions.length)
         {
            if(this.previousPositions[_loc2_] < 0 || this.previousPositions[_loc2_] > 559)
            {
               throw new Exception("Forbidden value (" + this.previousPositions[_loc2_] + ") on element 5 (starting at 1) of previousPositions.");
            }
            param1.writeVarShort(this.previousPositions[_loc2_]);
            _loc2_++;
         }
         param1.writeUTF(this.name);
         this.status.serializeAs_PlayerStatus(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         int _loc5_ = 0;
         this.deserializeAs_GameContextActorInformations(param1);
         this.teamId = param1.readByte();
         if(this.teamId < 0)
         {
            throw new Exception("Forbidden value (" + this.teamId + ") on element of GameFightFighterInformations.teamId.");
         }
         this.wave = param1.readByte();
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element of GameFightFighterInformations.wave.");
         }
         this.alive = param1.readBoolean();
         int _loc2_ = param1.readUnsignedShort();
         this.stats = ProtocolTypeManager.getInstance(GameFightMinimalStats,_loc2_);
         this.stats.deserialize(param1);
         int _loc3_ = param1.readUnsignedShort();
         int _loc4_ = 0;
         while(_loc4_ < _loc3_)
         {
            _loc5_ = param1.readVarUhShort();
            if(_loc5_ < 0 || _loc5_ > 559)
            {
               throw new Exception("Forbidden value (" + _loc5_ + ") on elements of previousPositions.");
            }
            this.previousPositions.push(_loc5_);
            _loc4_++;
         }
         this.name = param1.readUTF();
         this.status = new PlayerStatus();
         this.status.deserialize(param1);
    }

}