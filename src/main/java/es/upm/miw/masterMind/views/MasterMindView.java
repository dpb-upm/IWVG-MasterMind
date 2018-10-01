package es.upm.miw.masterMind.views;

import es.upm.miw.masterMind.controllers.OperationControllerVisitor;
import es.upm.miw.masterMind.controllers.local.*;
import es.upm.miw.masterMind.utils.IO;
import es.upm.miw.masterMind.utils.YesNoDialog;

public class MasterMindView implements OperationControllerVisitor {

	private static int optionLimit = 2;
	private IO io = new IO();

	public void interact(LocalOperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}
	
	@Override
	public void visit(LocalStartController startController) {
		io.showMenu();
		int optionSelected = io.readOption(MasterMindView.optionLimit);
        startController.setOption(optionSelected);
        int limit = startController.getLimitTokens();
        StringBuilder asterisk = new StringBuilder();
        for(int i=0; i < limit; i++){ asterisk.append("*"); }
        io.writeln("Secreto: " +  asterisk);
	}
	
	@Override
	public void visit(LocalPutController putController) {
        String attempt = io.readAttempt(putController.getLimitTokens(), putController.getTotalAttempt() + 1);
		if (putController.existMasterMind(attempt)) {
            io.writeln(putController.getLimitTokens() + " muertos!!! Victoria!!!");
		} else {
		    io.writeln(putController.getTotalDead() + " muertos y " + putController.getTotalInjured() + " heridos");
        }
	}

    @Override
    public void visit(LocalPutDemoController putDemoController) {
        String attempt = putDemoController.getRandomAttempt();
        io.writeln("IntentoRandom " + (putDemoController.getTotalAttempt() + 1) + ": "+ attempt);
        if (putDemoController.existMasterMind(attempt)) {
            io.writeln(putDemoController.getLimitTokens() + " muertos!!! Victoria!!!");
        } else {
            io.writeln(putDemoController.getTotalDead() + " muertos y " + putDemoController.getTotalInjured() + " heridos");
        }
    }

	@Override
	public void visit(LocalContinueController continueController) {
		continueController.resume(new YesNoDialog("Desea continuar")
                .read());
	}
}
