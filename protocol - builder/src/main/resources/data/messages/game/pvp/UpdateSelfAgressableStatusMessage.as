package data.messages.game.pvp
{
   import com.ankamagames.jerakine.network.NetworkMessage;
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class UpdateSelfAgressableStatusMessage extends NetworkMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 6456;
       
      private var _isInitialized:Boolean = false;
      
      public var status:uint = 0;
      
      public var probationTime:uint = 0;
      
      public function UpdateSelfAgressableStatusMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 6456;
      }
      
      public function initUpdateSelfAgressableStatusMessage(param1:uint = 0, param2:uint = 0) : UpdateSelfAgressableStatusMessage
      {
         this.status = param1;
         this.probationTime = param2;
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         this.status = 0;
         this.probationTime = 0;
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
         this.serializeAs_UpdateSelfAgressableStatusMessage(param1);
      }
      
      public function serializeAs_UpdateSelfAgressableStatusMessage(param1:ICustomDataOutput) : void
      {
         param1.writeByte(this.status);
         if(this.probationTime < 0)
         {
            throw new Error("Forbidden value (" + this.probationTime + ") on element probationTime.");
         }
         param1.writeInt(this.probationTime);
      }
      
      public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_UpdateSelfAgressableStatusMessage(param1);
      }
      
      public function deserializeAs_UpdateSelfAgressableStatusMessage(param1:ICustomDataInput) : void
      {
         this._statusFunc(param1);
         this._probationTimeFunc(param1);
      }
      
      public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_UpdateSelfAgressableStatusMessage(param1);
      }
      
      public function deserializeAsyncAs_UpdateSelfAgressableStatusMessage(param1:FuncTree) : void
      {
         param1.addChild(this._statusFunc);
         param1.addChild(this._probationTimeFunc);
      }
      
      private function _statusFunc(param1:ICustomDataInput) : void
      {
         this.status = param1.readByte();
         if(this.status < 0)
         {
            throw new Error("Forbidden value (" + this.status + ") on element of UpdateSelfAgressableStatusMessage.status.");
         }
      }
      
      private function _probationTimeFunc(param1:ICustomDataInput) : void
      {
         this.probationTime = param1.readInt();
         if(this.probationTime < 0)
         {
            throw new Error("Forbidden value (" + this.probationTime + ") on element of UpdateSelfAgressableStatusMessage.probationTime.");
         }
      }
   }
}
