package package com.ankamagames.dofus.network.types.game.house;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class HouseInformationsInside extends HouseInformations implements INetworkType {

    private int protocolId = 218;
    private HouseInstanceInformations houseInfos = ;
    private int worldX = 0;
    private int worldY = 0;
    private FuncTree _houseInfostree = ;
    private int _loc2_ = param1.readUnsignedShort();


    public int getTypeId() {
         return 218;
    }

    public HouseInformationsInside initHouseInformationsInside(int param1,int  param2,HouseInstanceInformations  param3,int  param4,int  param5) {
         super.initHouseInformations(param1,param2);
         this.houseInfos = param3;
         this.worldX = param4;
         this.worldY = param5;
         return this;
    }

    public void reset() {
         super.reset();
         this.houseInfos = new HouseInstanceInformations();
         this.worldY = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HouseInformationsInside(param1);
    }

    public void serializeAs_HouseInformationsInside(ICustomDataOutput param1) {
         super.serializeAs_HouseInformations(param1);
         param1.writeShort(this.houseInfos.getTypeId());
         this.houseInfos.serialize(param1);
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element worldX.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseInformationsInside(param1);
    }

    public void deserializeAs_HouseInformationsInside(ICustomDataInput param1) {
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserialize(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseInformationsInside(param1);
    }

    public void deserializeAsyncAs_HouseInformationsInside(FuncTree param1) {
         super.deserializeAsync(param1);
         this._houseInfostree = param1.addChild(this._houseInfostreeFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
    }

    private void _houseInfostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserializeAsync(this._houseInfostree);
    }

    private void _worldXFunc(ICustomDataInput param1) {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
            throw new Exception("Forbidden value (" + this.worldX + ") on element of HouseInformationsInside.worldX.");
    }

    private void _worldYFunc(ICustomDataInput param1) {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
            throw new Exception("Forbidden value (" + this.worldY + ") on element of HouseInformationsInside.worldY.");
    }

}