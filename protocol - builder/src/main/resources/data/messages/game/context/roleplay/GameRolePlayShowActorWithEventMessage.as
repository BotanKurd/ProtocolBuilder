package data.messages.game.context.roleplay
{
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class GameRolePlayShowActorWithEventMessage extends GameRolePlayShowActorMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6407;
       
      private var _isInitialized:Boolean = false;
      
      public var actorEventId:uint = 0;
      
      public function GameRolePlayShowActorWithEventMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6407;
      }
      
      public function initGameRolePlayShowActorWithEventMessage(param1:GameRolePlayActorInformations = null, param2:uint = 0) : GameRolePlayShowActorWithEventMessage
      {
         super.initGameRolePlayShowActorMessage(param1);
         this.actorEventId = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.actorEventId = 0;
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
         this.serializeAs_GameRolePlayShowActorWithEventMessage(param1);
      }
      
      public function serializeAs_GameRolePlayShowActorWithEventMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_GameRolePlayShowActorMessage(param1);
         if(this.actorEventId < 0)
         {
            throw new Error("Forbidden value (" + this.actorEventId + ") on element actorEventId.");
         }
         param1.writeByte(this.actorEventId);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_GameRolePlayShowActorWithEventMessage(param1);
      }
      
      public function deserializeAs_GameRolePlayShowActorWithEventMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._actorEventIdFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_GameRolePlayShowActorWithEventMessage(param1);
      }
      
      public function deserializeAsyncAs_GameRolePlayShowActorWithEventMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._actorEventIdFunc);
      }
      
      private function _actorEventIdFunc(param1:ICustomDataInput) : void
      {
         this.actorEventId = param1.readByte();
         if(this.actorEventId < 0)
         {
            throw new Error("Forbidden value (" + this.actorEventId + ") on element of GameRolePlayShowActorWithEventMessage.actorEventId.");
         }
      }
   }
}
