package data.messages.game.friend
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class GuildMemberWarnOnConnectionStateMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6160;
       
      private var _isInitialized:Boolean = false;
      
      public var enable:Boolean = false;
      
      public function GuildMemberWarnOnConnectionStateMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6160;
      }
      
      public function initGuildMemberWarnOnConnectionStateMessage(param1:Boolean = false) : GuildMemberWarnOnConnectionStateMessage
      {
         this.enable = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.enable = false;
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
         this.serializeAs_GuildMemberWarnOnConnectionStateMessage(param1);
      }
      
      public function serializeAs_GuildMemberWarnOnConnectionStateMessage(param1:ICustomDataOutput) : void
      {
         param1.writeBoolean(this.enable);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_GuildMemberWarnOnConnectionStateMessage(param1);
      }
      
      public function deserializeAs_GuildMemberWarnOnConnectionStateMessage(param1:ICustomDataInput) : void
      {
         this._enableFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_GuildMemberWarnOnConnectionStateMessage(param1);
      }
      
      public function deserializeAsyncAs_GuildMemberWarnOnConnectionStateMessage(param1:FuncTree) : void
      {
         param1.addChild(this._enableFunc);
      }
      
      private function _enableFunc(param1:ICustomDataInput) : void
      {
         this.enable = param1.readBoolean();
      }
   }
}
