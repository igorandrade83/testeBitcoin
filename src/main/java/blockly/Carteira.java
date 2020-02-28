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
public static Var ObterInformacoes() throws Exception {
 return new Callable<Var>() {

   private Var saldo = Var.VAR_NULL;
   private Var endereco = Var.VAR_NULL;

   public Var call() throws Exception {
    saldo = Var.valueOf(cronapi.blockchain.BlockchainOperations.getBalance(Var.valueOf(cronapi.io.Operations.fileAppDir().toString() + Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class), cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNomeCarteira")).getTypedObject(java.lang.String.class), Var.valueOf("test").getTypedObject(java.lang.String.class)));
    endereco = Var.valueOf(cronapi.blockchain.BlockchainOperations.getReceiveAddress(Var.valueOf(cronapi.io.Operations.fileAppDir().toString() + Var.valueOf("/carteiras").toString()).getTypedObject(java.lang.String.class), cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.inputNomeCarteira")).getTypedObject(java.lang.String.class), Var.valueOf("test").getTypedObject(java.lang.String.class)));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.inputPublicKey"), endereco);
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.inputSatoshi"), saldo);
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.inputSaldoBTC"), cronapi.math.Operations.divisor(cronapi.conversion.Operations.toDouble(cronapi.conversion.Operations.toString(saldo)),Var.valueOf(100000000)));
    return Var.VAR_NULL;
   }
 }.call();
}

}

