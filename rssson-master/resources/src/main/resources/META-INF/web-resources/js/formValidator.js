$(document).ready(function() {
	function validateRegEx(regex, input, helpText, helpMessage) {
		if (!regex.test(input)) {
			if (helpText != null) {
				helpText.innerHTML = helpMessage;
				return false;
			}
		} else {
			if (helpText != null) {
				helpText.innerHTML = "";
				return true;
			}
		}
	}
	
	function validateNonEmptyUsername(inputField, helpText) {
		return validateRegEx(/.+/, inputField.value, helpText, "Please enter a username");
	}
	
	function validateNonEmptyPassword(inputField, helpText) {
		return validateRegEx(/.+/, inputField.value, helpText, "Please enter a password");
	}
});