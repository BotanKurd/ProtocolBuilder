package data.types.game.approach
{
   import com.ankamagames.jerakine.network.INetworkType;
   import com.ankamagames.jerakine.network.ICustomDataOutput;
   import com.ankamagames.jerakine.network.ICustomDataInput;
   import com.ankamagames.jerakine.network.utils.FuncTree;
   
   [Trusted]
   public class ServerSessionConstantString extends ServerSessionConstant implements INetworkType
   {
      
      public static const protocolId:uint = 436;
       
      public var value:String = "";
      
      public function ServerSessionConstantString()
      {
         super();
      }
      
      override public function getTypeId() : uint
      {
         return 436;
      }
      
      public function initServerSessionConstantString(param1:uint = 0, param2:String = "") : ServerSessionConstantString
      {
         super.initServerSessionConstant(param1);
         this.value = param2;
         return this;
      }
      
      override public function reset() : void
      {
         super.reset();
         this.value = "";
      }
      
      override public function serialize(param1:ICustomDataOutput) : void
      {
         this.serializeAs_ServerSessionConstantString(param1);
      }
      
      public function serializeAs_ServerSessionConstantString(param1:ICustomDataOutput) : void
      {
         super.serializeAs_ServerSessionConstant(param1);
         param1.writeUTF(this.value);
      }
      
      override public function deserialize(param1:ICustomDataInput) : void
      {
         this.deserializeAs_ServerSessionConstantString(param1);
      }
      
      public function deserializeAs_ServerSessionConstantString(param1:ICustomDataInput) : void
      {
         super.deserialize(param1);
         this._valueFunc(param1);
      }
      
      override public function deserializeAsync(param1:FuncTree) : void
      {
         this.deserializeAsyncAs_ServerSessionConstantString(param1);
      }
      
      public function deserializeAsyncAs_ServerSessionConstantString(param1:FuncTree) : void
      {
         super.deserializeAsync(param1);
         param1.addChild(this._valueFunc);
      }
      
      private function _valueFunc(param1:ICustomDataInput) : void
      {
         this.value = param1.readUTF();
      }
   }
}
