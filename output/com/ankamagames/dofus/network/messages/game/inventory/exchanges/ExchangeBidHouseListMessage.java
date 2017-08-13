package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeBidHouseListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5807;
    private boolean _isInitialized = false;
    private int id = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5807;
    }

    public ExchangeBidHouseListMessage initExchangeBidHouseListMessage(int param1) {
         this.id = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.id = 0;
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
         this.serializeAs_ExchangeBidHouseListMessage(param1);
    }

    public void serializeAs_ExchangeBidHouseListMessage(ICustomDataOutput param1) {
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarShort(this.id);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBidHouseListMessage(param1);
    }

    public void deserializeAs_ExchangeBidHouseListMessage(ICustomDataInput param1) {
         this._idFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBidHouseListMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBidHouseListMessage(FuncTree param1) {
         param1.addChild(this._idFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhShort();
         if(this.id < 0)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of ExchangeBidHouseListMessage.id.");
         }
    }

}