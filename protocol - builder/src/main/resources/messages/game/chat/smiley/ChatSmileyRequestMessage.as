package com.ankamagames.dofus.network.messages.game.chat.smiley
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class ChatSmileyRequestMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 800;
       
      private var _isInitialized:Boolean = false;
      
      public var smileyId:uint = 0;
      
      public function ChatSmileyRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 800;
      }
      
      public function initChatSmileyRequestMessage(param1:uint = 0) : ChatSmileyRequestMessage
      {
         this.smileyId = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.smileyId = 0;
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
         this.serializeAs_ChatSmileyRequestMessage(param1);
      }
      
      public function serializeAs_ChatSmileyRequestMessage(param1:ICustomDataOutput) : void
      {
         if(this.smileyId < 0)
         {
            throw new Error("Forbidden value (" + this.smileyId + ") on element smileyId.");
         }
         param1.writeVarShort(this.smileyId);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ChatSmileyRequestMessage(param1);
      }
      
      public function deserializeAs_ChatSmileyRequestMessage(param1:ICustomDataInput) : void
      {
         this._smileyIdFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ChatSmileyRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_ChatSmileyRequestMessage(param1:FuncTree) : void
      {
         param1.addChild(this._smileyIdFunc);
      }
      
      private function _smileyIdFunc(param1:ICustomDataInput) : void
      {
         this.smileyId = param1.readVarUhShort();
         if(this.smileyId < 0)
         {
            throw new Error("Forbidden value (" + this.smileyId + ") on element of ChatSmileyRequestMessage.smileyId.");
         }
      }
   }
}
