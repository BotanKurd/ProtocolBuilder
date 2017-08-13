package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSellInBid;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeBidHouseItemAddOkMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5945;
    private boolean _isInitialized = false;
    private ObjectItemToSellInBid itemInfo = ;
    private FuncTree _itemInfotree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5945;
    }

    public ExchangeBidHouseItemAddOkMessage initExchangeBidHouseItemAddOkMessage(ObjectItemToSellInBid param1) {
         this.itemInfo = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.itemInfo = new ObjectItemToSellInBid();
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
         this.serializeAs_ExchangeBidHouseItemAddOkMessage(param1);
    }

    public void serializeAs_ExchangeBidHouseItemAddOkMessage(ICustomDataOutput param1) {
         this.itemInfo.serializeAs_ObjectItemToSellInBid(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBidHouseItemAddOkMessage(param1);
    }

    public void deserializeAs_ExchangeBidHouseItemAddOkMessage(ICustomDataInput param1) {
         this.itemInfo = new ObjectItemToSellInBid();
         this.itemInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBidHouseItemAddOkMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBidHouseItemAddOkMessage(FuncTree param1) {
         this._itemInfotree = param1.addChild(this._itemInfotreeFunc);
    }

    private void _itemInfotreeFunc(ICustomDataInput param1) {
         this.itemInfo = new ObjectItemToSellInBid();
         this.itemInfo.deserializeAsync(this._itemInfotree);
    }

}