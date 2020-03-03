package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Carteira {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Carteira
public static Var CriarCarteira() throws Exception {
 return new Callable<Var>() {

   private Var carteira = Var.VAR_NULL;

   public Var call() throws Exception {
    carteira = Var.valueOf(cronapi.blockchain.BlockchainOperations.createWallet(Var.valueOf(cronapi.io.Operations.fileAppDir().toString() + Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class), cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNomeCarteira")).getTypedObject(java.lang.String.class), Var.valueOf("test").getTypedObject(java.lang.String.class)));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.inputPublicKey"), carteira);
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var EnviarFundos() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.blockchain.BlockchainOperations.sendCoins(Var.valueOf(cronapi.io.Operations.fileAppDir().toString() + Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class), cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNomeCarteira")).getTypedObject(java.lang.String.class), Var.valueOf("test").getTypedObject(java.lang.String.class), cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputValorBTC")).getTypedObject(java.lang.String.class), cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputKeyCarteiraCreditada")).getTypedObject(java.lang.String.class));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var ObterInformacoes() throws Exception {
 return new Callable<Var>() {

   private Var saldo = Var.VAR_NULL;
   private Var endereco = Var.VAR_NULL;

   public Var call() throws Exception {
    saldo = Var.valueOf(cronapi.blockchain.BlockchainOperations.getBalance(Var.valueOf(cronapi.io.Operations.fileAppDir().toString() + Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class), cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNomeCarteira")).getTypedObject(java.lang.String.class), Var.valueOf("test").getTypedObject(java.lang.String.class)));
    endereco = Var.valueOf(cronapi.blockchain.BlockchainOperations.getReceiveAddress(Var.valueOf(cronapi.io.Operations.fileAppDir().toString() + Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class), cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNomeCarteira")).getTypedObject(java.lang.String.class), Var.valueOf("test").getTypedObject(java.lang.String.class)));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.inputPublicKey"), endereco);
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.inputSatoshi"), cronapi.object.Operations.getObjectField(saldo, Var.valueOf("value")));
    return Var.VAR_NULL;
   }
 }.call();
}

}

