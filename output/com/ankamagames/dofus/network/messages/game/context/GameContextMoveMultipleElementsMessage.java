package package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.EntityMovementInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameContextMoveMultipleElementsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 254;
    private boolean _isInitialized = false;
    private Vector.<EntityMovementInformations> movements = ;
    private FuncTree _movementstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 254;
    }

    public GameContextMoveMultipleElementsMessage initGameContextMoveMultipleElementsMessage(Vector.<EntityMovementInformations> param1) {
         this.movements = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.movements = new Vector.<EntityMovementInformations>();
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
         this.serializeAs_GameContextMoveMultipleElementsMessage(param1);
    }

    public void serializeAs_GameContextMoveMultipleElementsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.movements.length);
         int _loc2_ = 0;
         while(_loc2_ < this.movements.length)
            (this.movements[_loc2_] as EntityMovementInformations).serializeAs_EntityMovementInformations(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameContextMoveMultipleElementsMessage(param1);
    }

    public void deserializeAs_GameContextMoveMultipleElementsMessage(ICustomDataInput param1) {
         EntityMovementInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new EntityMovementInformations();
            _loc4_.deserialize(param1);
            this.movements.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameContextMoveMultipleElementsMessage(param1);
    }

    public void deserializeAsyncAs_GameContextMoveMultipleElementsMessage(FuncTree param1) {
         this._movementstree = param1.addChild(this._movementstreeFunc);
    }

    private void _movementstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._movementstree.addChild(this._movementsFunc);
            _loc3_++;
    }

    private void _movementsFunc(ICustomDataInput param1) {
         EntityMovementInformations _loc2_ = new EntityMovementInformations();
         _loc2_.deserialize(param1);
         this.movements.push(_loc2_);
    }

}