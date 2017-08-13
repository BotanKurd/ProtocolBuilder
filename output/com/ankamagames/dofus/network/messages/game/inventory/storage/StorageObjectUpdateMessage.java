package package com.ankamagames.dofus.network.messages.game.inventory.storage;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StorageObjectUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5647;
    private boolean _isInitialized = false;
    private ObjectItem object = ;
    private FuncTree _objecttree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5647;
    }

    public StorageObjectUpdateMessage initStorageObjectUpdateMessage(ObjectItem param1) {
         this.object = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.object = new ObjectItem();
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
         this.serializeAs_StorageObjectUpdateMessage(param1);
    }

    public void serializeAs_StorageObjectUpdateMessage(ICustomDataOutput param1) {
         this.object.serializeAs_ObjectItem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StorageObjectUpdateMessage(param1);
    }

    public void deserializeAs_StorageObjectUpdateMessage(ICustomDataInput param1) {
         this.object = new ObjectItem();
         this.object.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StorageObjectUpdateMessage(param1);
    }

    public void deserializeAsyncAs_StorageObjectUpdateMessage(FuncTree param1) {
         this._objecttree = param1.addChild(this._objecttreeFunc);
    }

    private void _objecttreeFunc(ICustomDataInput param1) {
         this.object = new ObjectItem();
         this.object.deserializeAsync(this._objecttree);
    }

}