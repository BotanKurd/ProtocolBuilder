package com.ankamagames.dofus.network.messages.game.startup
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.dofus.network.types.game.startup.StartupActionAddObject;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class StartupActionsListMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 1301;
       
      private var _isInitialized:Boolean = false;
      
      public var actions:Vector.<StartupActionAddObject>;
      
      private var _actionstree:FuncTree;
      
      public function StartupActionsListMessage()
      {
         this.actions = new Vector.<StartupActionAddObject>();
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 1301;
      }
      
      public function initStartupActionsListMessage(param1:Vector.<StartupActionAddObject> = null) : StartupActionsListMessage
      {
         this.actions = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.actions = new Vector.<StartupActionAddObject>();
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
         this.serializeAs_StartupActionsListMessage(param1);
      }
      
      public function serializeAs_StartupActionsListMessage(param1:ICustomDataOutput) : void
      {
         param1.writeShort(this.actions.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.actions.length)
         {
            (this.actions[_loc2_] as StartupActionAddObject).serializeAs_StartupActionAddObject(param1);
            _loc2_++;
         }
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_StartupActionsListMessage(param1);
      }
      
      public function deserializeAs_StartupActionsListMessage(param1:ICustomDataInput) : void
      {
         var _loc4_:StartupActionAddObject = null;
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new StartupActionAddObject();
            _loc4_.deserialize(param1);
            this.actions.push(_loc4_);
            _loc3_++;
         }
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_StartupActionsListMessage(param1);
      }
      
      public function deserializeAsyncAs_StartupActionsListMessage(param1:FuncTree) : void
      {
         this._actionstree = param1.addChild(this._actionstreeFunc);
      }
      
      private function _actionstreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._actionstree.addChild(this._actionsFunc);
            _loc3_++;
         }
      }
      
      private function _actionsFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:StartupActionAddObject = new StartupActionAddObject();
         _loc2_.deserialize(param1);
         this.actions.push(_loc2_);
      }
   }
}
