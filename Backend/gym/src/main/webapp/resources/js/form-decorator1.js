function decorateForm(form) {
	const submitButton = $(form).find('#submitButton');
	const showAlert = function(msg) {
		alert(msg);
	};
	const pEl = $(form).find('#password');
	const nameEl = $(form).find('#username');

	$(submitButton).on('click', function() {
		if (!nameEl.val()) {
			showAlert('User name is required');
			return false;
		}
		if (!pEl.val()) {
			showAlert('Password is required');
			return false;
		}
		form.submit();
	});
}