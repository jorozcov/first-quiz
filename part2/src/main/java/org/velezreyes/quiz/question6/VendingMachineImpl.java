package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine{
	
	private static VendingMachineImpl instance = null;
	private static float Money = 0;
	
	public static VendingMachine getInstance() {
		if (instance == null) {
	        VendingMachineImpl.instance = new VendingMachineImpl();
	    }
	    return VendingMachineImpl.instance;
	}
	

	@Override
	public void insertQuarter() {
		VendingMachineImpl.Money += 0.25;
	}
	
	@Override
	public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
		if (name == "ScottCola") {
			
			if (VendingMachineImpl.Money < 0.75) {
				throw new NotEnoughMoneyException();
			} else {
				VendingMachineImpl.Money -= 0.75;
				
				return new Drink() {
					
					@Override
					public boolean isFizzy() {
						return true;
					}
					
					@Override
					public String getName() {
						return "ScottCola";
					}
				};
			}
		
		} else if (name == "KarenTea"){
			
			if (VendingMachineImpl.Money < 1) {
				throw new NotEnoughMoneyException();
			} else {
				VendingMachineImpl.Money -= 1;
				
				return new Drink() {
					
					@Override
					public boolean isFizzy() {
						return false;
					}
					
					@Override
					public String getName() {
						return "KarenTea";
					}
				};
			}
			
			
		} else {
			throw new UnknownDrinkException();
		}
	}
}
