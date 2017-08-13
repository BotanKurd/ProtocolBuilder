package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectDeletedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 3024;
    private boolean _isInitialized = false;
    private int objectUID = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 3024;
    }

    public ObjectDeletedMessage initObjectDeletedMessage(int param1) {
         this.objectUID = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectUID = 0;
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
         this.serializeAs_ObjectDeletedMessage(param1);
    }

    public void serializeAs_ObjectDeletedMessage(ICustomDataOutput param1) {
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
         }
         param1.writeVarInt(this.objectUID);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectDeletedMessage(param1);
    }

    public void deserializeAs_ObjectDeletedMessage(ICustomDataInput param1) {
         this._objectUIDFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectDeletedMessage(param1);
    }

    public void deserializeAsyncAs_ObjectDeletedMessage(FuncTree param1) {
         param1.addChild(this._objectUIDFunc);
    }

    private void _objectUIDFunc(ICustomDataInput param1) {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of ObjectDeletedMessage.objectUID.");
         }
    }

}