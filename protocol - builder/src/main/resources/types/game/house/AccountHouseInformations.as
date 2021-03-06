package com.ankamagames.dofus.network.types.game.house
{
   import com.ankamagames.jerakine.network.INetworkType;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.dofus.network.ProtocolTypeManager;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   public class AccountHouseInformations extends HouseInformations implements INetworkType
   {
      
      public static const protocolId:uint = 390;
       
      public var houseInfos:HouseInstanceInformations;
      
      public var worldX:int = 0;
      
      public var worldY:int = 0;
      
      public var mapId:int = 0;
      
      public var subAreaId:uint = 0;
      
      private var _houseInfostree:FuncTree;
      
      public function AccountHouseInformations()
      {
         this.houseInfos = new HouseInstanceInformations();
         super();
      }
      
      override public function getTypeId() : uint
      {
         return 390;
      }
      
      public function initAccountHouseInformations(param1:uint = 0, param2:uint = 0, param3:HouseInstanceInformations = null, param4:int = 0, param5:int = 0, param6:int = 0, param7:uint = 0) : AccountHouseInformations
      {
         super.initHouseInformations(param1,param2);
         this.houseInfos = param3;
         this.worldX = param4;
         this.worldY = param5;
         this.mapId = param6;
         this.subAreaId = param7;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.houseInfos = new HouseInstanceInformations();
         this.worldY = 0;
         this.mapId = 0;
         this.subAreaId = 0;
      }
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_AccountHouseInformations(param1);
      }
      
      public function serializeAs_AccountHouseInformations(param1:ICustomDataOutput) : void
      {
         super.serializeAs_HouseInformations(param1);
         param1.writeShort(this.houseInfos.getTypeId());
         this.houseInfos.serialize(param1);
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Error("Forbidden value (" + this.worldX + ") on element worldX.");
         }
         param1.writeShort(this.worldX);
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Error("Forbidden value (" + this.worldY + ") on element worldY.");
         }
         param1.writeShort(this.worldY);
         param1.writeInt(this.mapId);
         if(this.subAreaId < 0)
         {
            throw new Error("Forbidden value (" + this.subAreaId + ") on element subAreaId.");
         }
         param1.writeVarShort(this.subAreaId);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_AccountHouseInformations(param1);
      }
      
      public function deserializeAs_AccountHouseInformations(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         var _loc2_:uint = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserialize(param1);
         this._worldXFunc(param1);
         this._worldYFunc(param1);
         this._mapIdFunc(param1);
         this._subAreaIdFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_AccountHouseInformations(param1);
      }
      
      public function deserializeAsyncAs_AccountHouseInformations(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         this._houseInfostree = param1.addChild(this._houseInfostreeFunc);
         param1.addChild(this._worldXFunc);
         param1.addChild(this._worldYFunc);
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._subAreaIdFunc);
      }
      
      private function _houseInfostreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         this.houseInfos = ProtocolTypeManager.getInstance(HouseInstanceInformations,_loc2_);
         this.houseInfos.deserializeAsync(this._houseInfostree);
      }
      
      private function _worldXFunc(param1:ICustomDataInput) : void
      {
         this.worldX = param1.readShort();
         if(this.worldX < -255 || this.worldX > 255)
         {
            throw new Error("Forbidden value (" + this.worldX + ") on element of AccountHouseInformations.worldX.");
         }
      }
      
      private function _worldYFunc(param1:ICustomDataInput) : void
      {
         this.worldY = param1.readShort();
         if(this.worldY < -255 || this.worldY > 255)
         {
            throw new Error("Forbidden value (" + this.worldY + ") on element of AccountHouseInformations.worldY.");
         }
      }
      
      private function _mapIdFunc(param1:ICustomDataInput) : void
      {
         this.mapId = param1.readInt();
      }
      
      private function _subAreaIdFunc(param1:ICustomDataInput) : void
      {
         this.subAreaId = param1.readVarUhShort();
         if(this.subAreaId < 0)
         {
            throw new Error("Forbidden value (" + this.subAreaId + ") on element of AccountHouseInformations.subAreaId.");
         }
      }
   }
}
