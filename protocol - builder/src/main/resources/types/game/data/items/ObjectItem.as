package com.ankamagames.dofus.network.types.game.data.items
{
   import com.ankamagames.jerakine.network.INetworkType;
   import com.ankamagames.dofus.network.types.game.data.items.effects.ObjectEffect;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.dofus.network.ProtocolTypeManager;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   public class ObjectItem extends Item implements INetworkType
   {
      
      public static const protocolId:uint = 37;
       
      public var position:uint = 63;
      
      public var objectGID:uint = 0;
      
      public var effects:Vector.<ObjectEffect>;
      
      public var objectUID:uint = 0;
      
      public var quantity:uint = 0;
      
      private var _effectstree:FuncTree;
      
      public function ObjectItem()
      {
         this.effects = new Vector.<ObjectEffect>();
         super();
      }
      
      override public function getTypeId() : uint
      {
         return 37;
      }
      
      public function initObjectItem(param1:uint = 63, param2:uint = 0, param3:Vector.<ObjectEffect> = null, param4:uint = 0, param5:uint = 0) : ObjectItem
      {
         this.position = param1;
         this.objectGID = param2;
         this.effects = param3;
         this.objectUID = param4;
         this.quantity = param5;
         return this;
      }
      
      override public function reset() : void
      {
         this.position = 63;
         this.objectGID = 0;
         this.effects = new Vector.<ObjectEffect>();
         this.objectUID = 0;
         this.quantity = 0;
      }
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_ObjectItem(param1);
      }
      
      public function serializeAs_ObjectItem(param1:ICustomDataOutput) : void
      {
         super.serializeAs_Item(param1);
         param1.writeByte(this.position);
         if(this.objectGID < 0)
         {
            throw new Error("Forbidden value (" + this.objectGID + ") on element objectGID.");
         }
         param1.writeVarShort(this.objectGID);
         param1.writeShort(this.effects.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.effects.length)
         {
            param1.writeShort((this.effects[_loc2_] as ObjectEffect).getTypeId());
            (this.effects[_loc2_] as ObjectEffect).serialize(param1);
            _loc2_++;
         }
         if(this.objectUID < 0)
         {
            throw new Error("Forbidden value (" + this.objectUID + ") on element objectUID.");
         }
         param1.writeVarInt(this.objectUID);
         if(this.quantity < 0)
         {
            throw new Error("Forbidden value (" + this.quantity + ") on element quantity.");
         }
         param1.writeVarInt(this.quantity);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ObjectItem(param1);
      }
      
      public function deserializeAs_ObjectItem(param1:ICustomDataInput) : void
      {
         var _loc4_:uint = 0;
         var _loc5_:ObjectEffect = null;
         super.deserialize(param1);
         this._positionFunc(param1);
         this._objectGIDFunc(param1);
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(ObjectEffect,_loc4_);
            _loc5_.deserialize(param1);
            this.effects.push(_loc5_);
            _loc3_++;
         }
         this._objectUIDFunc(param1);
         this._quantityFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ObjectItem(param1);
      }
      
      public function deserializeAsyncAs_ObjectItem(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._positionFunc);
         param1.addChild(this._objectGIDFunc);
         this._effectstree = param1.addChild(this._effectstreeFunc);
         param1.addChild(this._objectUIDFunc);
         param1.addChild(this._quantityFunc);
      }
      
      private function _positionFunc(param1:ICustomDataInput) : void
      {
         this.position = param1.readUnsignedByte();
         if(this.position < 0 || this.position > 255)
         {
            throw new Error("Forbidden value (" + this.position + ") on element of ObjectItem.position.");
         }
      }
      
      private function _objectGIDFunc(param1:ICustomDataInput) : void
      {
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
         {
            throw new Error("Forbidden value (" + this.objectGID + ") on element of ObjectItem.objectGID.");
         }
      }
      
      private function _effectstreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._effectstree.addChild(this._effectsFunc);
            _loc3_++;
         }
      }
      
      private function _effectsFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:ObjectEffect = ProtocolTypeManager.getInstance(ObjectEffect,_loc2_);
         _loc3_.deserialize(param1);
         this.effects.push(_loc3_);
      }
      
      private function _objectUIDFunc(param1:ICustomDataInput) : void
      {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
         {
            throw new Error("Forbidden value (" + this.objectUID + ") on element of ObjectItem.objectUID.");
         }
      }
      
      private function _quantityFunc(param1:ICustomDataInput) : void
      {
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
         {
            throw new Error("Forbidden value (" + this.quantity + ") on element of ObjectItem.quantity.");
         }
      }
   }
}
