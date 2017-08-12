package data.messages.game.context.roleplay.npc
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class NpcDialogQuestionMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5617;
       
      private var _isInitialized:Boolean = false;
      
      public var messageId:uint = 0;
      
      public var dialogParams:Vector.<String>;
      
      public var visibleReplies:Vector.<uint>;
      
      private var _dialogParamstree:FuncTree;
      
      private var _visibleRepliestree:FuncTree;
      
      public function NpcDialogQuestionMessage()
      {
         this.dialogParams = new Vector.<String>();
         this.visibleReplies = new Vector.<uint>();
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5617;
      }
      
      public function initNpcDialogQuestionMessage(param1:uint = 0, param2:Vector.<String> = null, param3:Vector.<uint> = null) : NpcDialogQuestionMessage
      {
         this.messageId = param1;
         this.dialogParams = param2;
         this.visibleReplies = param3;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.messageId = 0;
         this.dialogParams = new Vector.<String>();
         this.visibleReplies = new Vector.<uint>();
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
         this.serializeAs_NpcDialogQuestionMessage(param1);
      }
      
      public function serializeAs_NpcDialogQuestionMessage(param1:ICustomDataOutput) : void
      {
         if(this.messageId < 0)
         {
            throw new Error("Forbidden value (" + this.messageId + ") on element messageId.");
         }
         param1.writeVarInt(this.messageId);
         param1.writeShort(this.dialogParams.length);
         var _loc2_:uint = 0;
         while(_loc2_ < this.dialogParams.length)
         {
            param1.writeUTF(this.dialogParams[_loc2_]);
            _loc2_++;
         }
         param1.writeShort(this.visibleReplies.length);
         var _loc3_:uint = 0;
         while(_loc3_ < this.visibleReplies.length)
         {
            if(this.visibleReplies[_loc3_] < 0)
            {
               throw new Error("Forbidden value (" + this.visibleReplies[_loc3_] + ") on element 3 (starting at 1) of visibleReplies.");
            }
            param1.writeVarInt(this.visibleReplies[_loc3_]);
            _loc3_++;
         }
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_NpcDialogQuestionMessage(param1);
      }
      
      public function deserializeAs_NpcDialogQuestionMessage(param1:ICustomDataInput) : void
      {
         var _loc6_:String = null;
         var _loc7_:uint = 0;
         this._messageIdFunc(param1);
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = param1.readUTF();
            this.dialogParams.push(_loc6_);
            _loc3_++;
         }
         var _loc4_:uint = param1.readUnsignedShort();
         var _loc5_:uint = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readVarUhInt();
            if(_loc7_ < 0)
            {
               throw new Error("Forbidden value (" + _loc7_ + ") on elements of visibleReplies.");
            }
            this.visibleReplies.push(_loc7_);
            _loc5_++;
         }
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_NpcDialogQuestionMessage(param1);
      }
      
      public function deserializeAsyncAs_NpcDialogQuestionMessage(param1:FuncTree) : void
      {
         param1.addChild(this._messageIdFunc);
         this._dialogParamstree = param1.addChild(this._dialogParamstreeFunc);
         this._visibleRepliestree = param1.addChild(this._visibleRepliestreeFunc);
      }
      
      private function _messageIdFunc(param1:ICustomDataInput) : void
      {
         this.messageId = param1.readVarUhInt();
         if(this.messageId < 0)
         {
            throw new Error("Forbidden value (" + this.messageId + ") on element of NpcDialogQuestionMessage.messageId.");
         }
      }
      
      private function _dialogParamstreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._dialogParamstree.addChild(this._dialogParamsFunc);
            _loc3_++;
         }
      }
      
      private function _dialogParamsFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:String = param1.readUTF();
         this.dialogParams.push(_loc2_);
      }
      
      private function _visibleRepliestreeFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readUnsignedShort();
         var _loc3_:uint = 0;
         while(_loc3_ < _loc2_)
         {
            this._visibleRepliestree.addChild(this._visibleRepliesFunc);
            _loc3_++;
         }
      }
      
      private function _visibleRepliesFunc(param1:ICustomDataInput) : void
      {
         var _loc2_:uint = param1.readVarUhInt();
         if(_loc2_ < 0)
         {
            throw new Error("Forbidden value (" + _loc2_ + ") on elements of visibleReplies.");
         }
         this.visibleReplies.push(_loc2_);
      }
   }
}
