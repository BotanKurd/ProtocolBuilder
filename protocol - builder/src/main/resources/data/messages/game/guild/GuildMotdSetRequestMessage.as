package data.messages.game.guild
{
   import com.ankamagames.dofus.network.messages.game.social.SocialNoticeSetRequestMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class GuildMotdSetRequestMessage extends SocialNoticeSetRequestMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6588;
       
      private var _isInitialized:Boolean = false;
      
      [Transient]
      public var content:String = "";
      
      public function GuildMotdSetRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6588;
      }
      
      public function initGuildMotdSetRequestMessage(param1:String = "") : GuildMotdSetRequestMessage
      {
         this.content = param1;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.content = "";
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
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_GuildMotdSetRequestMessage(param1);
      }
      
      public function serializeAs_GuildMotdSetRequestMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_SocialNoticeSetRequestMessage(param1);
         param1.writeUTF(this.content);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_GuildMotdSetRequestMessage(param1);
      }
      
      public function deserializeAs_GuildMotdSetRequestMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._contentFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_GuildMotdSetRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_GuildMotdSetRequestMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._contentFunc);
      }
      
      private function _contentFunc(param1:ICustomDataInput) : void
      {
         this.content = param1.readUTF();
      }
   }
}
