package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class MountSetXpRatioRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5989;
    private boolean _isInitialized = false;
    private int xpRatio = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5989;
    }

    public MountSetXpRatioRequestMessage initMountSetXpRatioRequestMessage(int param1) {
         this.xpRatio = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.xpRatio = 0;
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
         this.serializeAs_MountSetXpRatioRequestMessage(param1);
    }

    public void serializeAs_MountSetXpRatioRequestMessage(ICustomDataOutput param1) {
         if(this.xpRatio < 0)
         {
            throw new Exception("Forbidden value (" + this.xpRatio + ") on element xpRatio.");
         }
         param1.writeByte(this.xpRatio);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountSetXpRatioRequestMessage(param1);
    }

    public void deserializeAs_MountSetXpRatioRequestMessage(ICustomDataInput param1) {
         this._xpRatioFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountSetXpRatioRequestMessage(param1);
    }

    public void deserializeAsyncAs_MountSetXpRatioRequestMessage(FuncTree param1) {
         param1.addChild(this._xpRatioFunc);
    }

    private void _xpRatioFunc(ICustomDataInput param1) {
         this.xpRatio = param1.readByte();
         if(this.xpRatio < 0)
         {
            throw new Exception("Forbidden value (" + this.xpRatio + ") on element of MountSetXpRatioRequestMessage.xpRatio.");
         }
    }

}