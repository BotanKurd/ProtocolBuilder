package package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameMapMovementRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 950;
    private boolean _isInitialized = false;
    private Vector.<uint> keyMovements = ;
    private int mapId = 0;
    private FuncTree _keyMovementstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 950;
    }

    public GameMapMovementRequestMessage initGameMapMovementRequestMessage(Vector.<uint> param1,int  param2) {
         this.keyMovements = param1;
         this.mapId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.keyMovements = new Vector.<uint>();
         this.mapId = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
            HASH_FUNCTION(_loc2_);
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
         this.serializeAs_GameMapMovementRequestMessage(param1);
    }

    public void serializeAs_GameMapMovementRequestMessage(ICustomDataOutput param1) {
         param1.writeShort(this.keyMovements.length);
         int _loc2_ = 0;
         while(_loc2_ < this.keyMovements.length)
            if(this.keyMovements[_loc2_] < 0)
               throw new Exception("Forbidden value (" + this.keyMovements[_loc2_] + ") on element 1 (starting at 1) of keyMovements.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameMapMovementRequestMessage(param1);
    }

    public void deserializeAs_GameMapMovementRequestMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readShort();
            if(_loc4_ < 0)
               throw new Exception("Forbidden value (" + _loc4_ + ") on elements of keyMovements.");
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameMapMovementRequestMessage(param1);
    }

    public void deserializeAsyncAs_GameMapMovementRequestMessage(FuncTree param1) {
         this._keyMovementstree = param1.addChild(this._keyMovementstreeFunc);
         param1.addChild(this._mapIdFunc);
    }

    private void _keyMovementstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._keyMovementstree.addChild(this._keyMovementsFunc);
            _loc3_++;
    }

    private void _keyMovementsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readShort();
         if(_loc2_ < 0)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of keyMovements.");
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
         if(this.mapId < 0)
            throw new Exception("Forbidden value (" + this.mapId + ") on element of GameMapMovementRequestMessage.mapId.");
    }

}