package UserRegistration;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class UserValidator implements Validator {
	
	String stringValue = null;

	@Override
	public void validate(FacesContext fC, UIComponent uiC, Object value) throws ValidatorException {
		
		stringValue = (String) value;
		
		// 3 Inputs to Check
		switch(uiC.getId()) {
		case "username":
			if(stringValue.length() < 2) {
				throw new ValidatorException(new FacesMessage("It's Too Short!"));
			}
		break;
		case "email":

		break;
		case "password":

		break;
		default:
			
		break;
		}                 
	}
}
 