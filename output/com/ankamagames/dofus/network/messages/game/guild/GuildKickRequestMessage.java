package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GuildKickRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5887;
    private boolean _isInitialized = false;
    private Number kickedId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5887;
    }

    public GuildKickRequestMessage initGuildKickRequestMessage(Number param1) {
         this.kickedId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.kickedId = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GuildKickRequestMessage(param1);
    }

    public void serializeAs_GuildKickRequestMessage(ICustomDataOutput param1) {
         if(this.kickedId < 0 || this.kickedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kickedId + ") on element kickedId.");
         }
         param1.writeVarLong(this.kickedId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildKickRequestMessage(param1);
    }

    public void deserializeAs_GuildKickRequestMessage(ICustomDataInput param1) {
         this._kickedIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildKickRequestMessage(param1);
    }

    public void deserializeAsyncAs_GuildKickRequestMessage(FuncTree param1) {
         param1.addChild(this._kickedIdFunc);
    }

    private void _kickedIdFunc(ICustomDataInput param1) {
         this.kickedId = param1.readVarUhLong();
         if(this.kickedId < 0 || this.kickedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kickedId + ") on element of GuildKickRequestMessage.kickedId.");
         }
    }

}