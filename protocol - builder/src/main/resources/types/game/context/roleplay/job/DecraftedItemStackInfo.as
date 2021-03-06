package com.ankamagames.dofus.network.types.game.context.roleplay.job
{
   import com.ankamagames.jerakine.network.INetworkType;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   public class DecraftedItemStackInfo extends Object implements INetworkType
   {
      
      public static const protocolId:uint = 481;
       
      public var objectUID:uint = 0;
      
      public var bonusMin:Number = 0;
      
      public var bonusMax:Number = 0;
      
      public var runesId:Vector.<uint>;
      
      public var runesQty:Vector.<uint>;
      
      private var _runesIdtree:FuncTree;
      
      private var _runesQtytree:FuncTree;
      
      public function DecraftedItemStackInfo()
      {
         this.runesId = new Vector.<uint>();
         this.runesQty = new Vector.<uint>();
         super();
      }
      
      public function getTypeId() : uint
      {
         return 481;
      }
      
      public function initDecraftedItemStackInfo(param1:uint = 0, param2:Number = 0, param3:Number = 0, param4:Vector.<uint> = null, param5:Vector.<uint> = null) : DecraftedItemStackInfo
      {
         this.objectUID = param1;
         this.bonusMin = param2;
         this.bonusMax = param3;
         this.runesId = param4;
         this.runesQty = param5;
         return this;
      }
      
      public function reset() : void
      {
         this.objectUID = 0;
         this.bonusMin = 0;
         this.bonusMax = 0;
         this.runesId = new Vector.<uint>();
         this.runesQty = new Vector.<uint>();
      }
      
      public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_DecraftedItemStackInfo(param1);
      }
      
      public function serializeAs_DecraftedItemStackInfo(param1:ICustomDataOutput) : void
      {
         if(this.objectUID < 0)
         {
            throw new Error("Forbidden value (" + this.objectUID + ") on element objectUID.");
         }
         param1.writeVarInt(this.objectUID);
         param1.writeFloat(this.bonusMin);
         param1.writeFloat(this.bonusMax);
         param1.writeShort(this.runesId.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.runesId.length)
         {
            if(this.runesId[_loc2_] < 0)
            {
               throw new Error("Forbidden value (" + this.runesId[_loc2_] + ") on element 4 (starting at 1) of runesId.");
            }
            param1.writeVarShort(this.runesId[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.runesQty.length);
         var _loc3_:uint = 0;
         while(_loc3_ < this.runesQty.length)
         {
            if(this.runesQty[_loc3_] < 0)
            {
               throw new Error("Forbidden value (" + this.runesQty[_loc3_] + ") on element 5 (starting at 1) of runesQty.");
            }
            param1.writeVarInt(this.runesQty[_loc3_]);
            _loc3_++;
         }
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_DecraftedItemStackInfo(param1);
      }
      
      public function deserializeAs_DecraftedItemStackInfo(param1:ICustomDataInput) : void
      {
         var _loc6_:uint = 0;
         var _loc7_:uint = 0;
         this._objectUIDFunc(param1);
         this._bonusMinFunc(param1);
         this._bonusMaxFunc(param1);
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readVarUhShort();
            if(_loc6_ < 0)
            {
               throw new Error("Forbidden value (" + _loc6_ + ") on elements of runesId.");
            }
            this.runesId.push(_loc6_);
            _loc3_++;
         }
         var _loc4_:uint = param1.readUnsignedShort();
         var _loc5_:uint = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhInt();
            if(_loc7_ < 0)
            {
               throw new Error("Forbidden value (" + _loc7_ + ") on elements of runesQty.");
            }
            this.runesQty.push(_loc7_);
            _loc5_++;
         }
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_DecraftedItemStackInfo(param1);
      }
      
      public function deserializeAsyncAs_DecraftedItemStackInfo(param1:FuncTree) : void
      {
         param1.addChild(this._objectUIDFunc);
         param1.addChild(this._bonusMinFunc);
         param1.addChild(this._bonusMaxFunc);
         this._runesIdtree = param1.addChild(this._runesIdtreeFunc);
         this._runesQtytree = param1.addChild(this._runesQtytreeFunc);
      }
      
      private function _objectUIDFunc(param1:ICustomDataInput) : void
      {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
         {
            throw new Error("Forbidden value (" + this.objectUID + ") on element of DecraftedItemStackInfo.objectUID.");
         }
      }
      
      private function _bonusMinFunc(param1:ICustomDataInput) : void
      {
         this.bonusMin = param1.readFloat();
      }
      
      private function _bonusMaxFunc(param1:ICustomDataInput) : void
      {
         this.bonusMax = param1.readFloat();
      }
      
      private function _runesIdtreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._runesIdtree.addChild(this._runesIdFunc);
            _loc3_++;
         }
      }
      
      private function _runesIdFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readVarUhShort();
         if(_loc2_ < 0)
         {
            throw new Error("Forbidden value (" + _loc2_ + ") on elements of runesId.");
         }
         this.runesId.push(_loc2_);
      }
      
      private function _runesQtytreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._runesQtytree.addChild(this._runesQtyFunc);
            _loc3_++;
         }
      }
      
      private function _runesQtyFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readVarUhInt();
         if(_loc2_ < 0)
         {
            throw new Error("Forbidden value (" + _loc2_ + ") on elements of runesQty.");
         }
         this.runesQty.push(_loc2_);
      }
   }
}
