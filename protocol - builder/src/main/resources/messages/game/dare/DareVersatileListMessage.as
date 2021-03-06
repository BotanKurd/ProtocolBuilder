package com.ankamagames.dofus.network.messages.game.dare
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.dofus.network.types.game.dare.DareVersatileInformations;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class DareVersatileListMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6657;
       
      private var _isInitialized:Boolean = false;
      
      public var dares:Vector.<DareVersatileInformations>;
      
      private var _darestree:FuncTree;
      
      public function DareVersatileListMessage()
      {
         this.dares = new Vector.<DareVersatileInformations>();
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6657;
      }
      
      public function initDareVersatileListMessage(param1:Vector.<DareVersatileInformations> = null) : DareVersatileListMessage
      {
         this.dares = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.dares = new Vector.<DareVersatileInformations>();
         this._isInitialized = false;
      }
      
      override public function pack(param1:ICustomDataOutput) : void
      {
         var _loc2_:ByteArray = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
      }
      
      override public function unpack(param1:ICustomDataInput, param2:uint) : void
      {
         this.deserialize(param1);
      }
      
      override public function unpackAsync(param1:ICustomDataInput, param2:uint) : FuncTree
      {
         var _loc3_:FuncTree = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
      }
      
      public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_DareVersatileListMessage(param1);
      }
      
      public function serializeAs_DareVersatileListMessage(param1:ICustomDataOutput) : void
      {
         param1.writeShort(this.dares.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.dares.length)
         {
            (this.dares[_loc2_] as DareVersatileInformations).serializeAs_DareVersatileInformations(param1);
            _loc2_++;
         }
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_DareVersatileListMessage(param1);
      }
      
      public function deserializeAs_DareVersatileListMessage(param1:ICustomDataInput) : void
      {
         var _loc4_:DareVersatileInformations = null;
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new DareVersatileInformations();
            _loc4_.deserialize(param1);
            this.dares.push(_loc4_);
            _loc3_++;
         }
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_DareVersatileListMessage(param1);
      }
      
      public function deserializeAsyncAs_DareVersatileListMessage(param1:FuncTree) : void
      {
         this._darestree = param1.addChild(this._darestreeFunc);
      }
      
      private function _darestreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._darestree.addChild(this._daresFunc);
            _loc3_++;
         }
      }
      
      private function _daresFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:DareVersatileInformations = new DareVersatileInformations();
         _loc2_.deserialize(param1);
         this.dares.push(_loc2_);
      }
   }
}
