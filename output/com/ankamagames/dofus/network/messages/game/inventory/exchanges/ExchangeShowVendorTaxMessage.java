package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeShowVendorTaxMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5783;


    public boolean isInitialized() {
         return true;
    }

    public int getMessageId() {
         return 5783;
    }

    public ExchangeShowVendorTaxMessage initExchangeShowVendorTaxMessage() {
         return this;
    }

    public void reset() {
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
    }

    public void serializeAs_ExchangeShowVendorTaxMessage(ICustomDataOutput param1) {
    }

    public void deserialize(ICustomDataInput param1) {
    }

    public void deserializeAs_ExchangeShowVendorTaxMessage(ICustomDataInput param1) {
    }

    public void deserializeAsync(FuncTree param1) {
    }

    public void deserializeAsyncAs_ExchangeShowVendorTaxMessage(FuncTree param1) {
    }

}