package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSell;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeShopStockStartedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5910;
    private boolean _isInitialized = false;
    private Vector<ObjectItemToSell> objectsInfos;
    private FuncTree _objectsInfostree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5910;
    }

    public ExchangeShopStockStartedMessage initExchangeShopStockStartedMessage(Vector<ObjectItemToSell> param1) {
         this.objectsInfos = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectsInfos = new Vector.<ObjectItemToSell>();
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
         this.serializeAs_ExchangeShopStockStartedMessage(param1);
    }

    public void serializeAs_ExchangeShopStockStartedMessage(ICustomDataOutput param1) {
         param1.writeShort(this.objectsInfos.length);
         int _loc2_ = 0;
         while(_loc2_ < this.objectsInfos.length)
         {
            (this.objectsInfos[_loc2_] as ObjectItemToSell).serializeAs_ObjectItemToSell(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeShopStockStartedMessage(param1);
    }

    public void deserializeAs_ExchangeShopStockStartedMessage(ICustomDataInput param1) {
         ObjectItemToSell _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new ObjectItemToSell();
            _loc4_.deserialize(param1);
            this.objectsInfos.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeShopStockStartedMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeShopStockStartedMessage(FuncTree param1) {
         this._objectsInfostree = param1.addChild(this._objectsInfostreeFunc);
    }

    private void _objectsInfostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._objectsInfostree.addChild(this._objectsInfosFunc);
            _loc3_++;
         }
    }

    private void _objectsInfosFunc(ICustomDataInput param1) {
         ObjectItemToSell _loc2_ = new ObjectItemToSell();
         _loc2_.deserialize(param1);
         this.objectsInfos.push(_loc2_);
    }

}