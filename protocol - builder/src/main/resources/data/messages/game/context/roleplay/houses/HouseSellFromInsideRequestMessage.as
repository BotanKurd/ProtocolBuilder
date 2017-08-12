package data.messages.game.context.roleplay.houses
{
   import com.ankamagames.jerakine.network.INetworkMessage;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import flash.utils.ByteArray;
   import com.ankamagames.jerakine.network.CustomDataWrapper;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class HouseSellFromInsideRequestMessage extends HouseSellRequestMessage implements INetworkMessage
   {
      
      public static const protocolId:uint = 5884;
       
      private var _isInitialized:Boolean = false;
      
      public function HouseSellFromInsideRequestMessage()
      {
         super();
      }
      
      override public function get isInitialized() : Boolean
      {
         return super.isInitialized && this._isInitialized;
      }
      
      override public function getMessageId() : uint
      {
         return 5884;
      }
      
      public function initHouseSellFromInsideRequestMessage(param1:uint = 0, param2:Number = 0, param3:Boolean = false) : HouseSellFromInsideRequestMessage
      {
         super.initHouseSellRequestMessage(param1,param2,param3);
         this._isInitialized = true;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
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
         this.serializeAs_HouseSellFromInsideRequestMessage(param1);
      }
      
      public function serializeAs_HouseSellFromInsideRequestMessage(param1:ICustomDataOutput) : void
      {
         super.serializeAs_HouseSellRequestMessage(param1);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_HouseSellFromInsideRequestMessage(param1);
      }
      
      public function deserializeAs_HouseSellFromInsideRequestMessage(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_HouseSellFromInsideRequestMessage(param1);
      }
      
      public function deserializeAsyncAs_HouseSellFromInsideRequestMessage(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
      }
   }
}
