const inputs = document.querySelectorAll(".input");


function addcl() {
	let parent = this.parentNode.parentNode;
	parent.classList.add("focus");
}

function remcl() {
	let parent = this.parentNode.parentNode;
	if (this.value == "") {
		parent.classList.remove("focus");
	}
}


inputs.forEach(input => {
	input.addEventListener("focus", addcl);
	input.addEventListener("blur", remcl);
});


$('#NavMenuBar').click(function() {
	SideMenuOpenClose();
});

$('#ContentOverlayID').click(function() {
	SideMenuOpenClose();
});


function SideMenuOpenClose() {
	let SideNavID = $('#SideNavID');
	let ContentOverlayID = $('#ContentOverlayID');
	let menuText = $('.menuText');
	if (SideNavID.hasClass('sideNavClose')) {
		SideNavID.removeClass('sideNavClose')
		SideNavID.addClass('sideNavOpen')
		menuText.removeClass('d-none');
		ContentOverlayID.removeClass('ContentOverlayClose')
		ContentOverlayID.addClass('ContentOverlay')
	} else {
		SideNavID.removeClass('sideNavOpen')
		SideNavID.addClass('sideNavClose')
		menuText.addClass('d-none');
		ContentOverlayID.removeClass('ContentOverlay')
		ContentOverlayID.addClass('ContentOverlayClose')
	}
}
/**
 * 
 */

$(document).ready(function() {
	$('.delete-user').on('click', function() {
		/*<![CDATA[*/
		var path = /*[[@{/}]]*/'DeleteUser';
		/*]]>*/

		var id = $(this).attr('id');

		bootbox.confirm({
			message: "Are you sure to remove this User? It can't be undone.",
			buttons: {
				cancel: {
					label: '<i class="fa fa-times"></i> Cancel'
				},
				confirm: {
					label: '<i class="fa fa-check"></i> Confirm'
				}
			},
			callback: function(confirmed) {
				if (confirmed) {
					$.post(path, { 'id': id }, function(res) {
						location.reload();
					});
				}
			}
		});
	});

	$('.update-user').on('click', function() {
		var path = /*[[@{/}]]*/'updateUser';
		var user = {
				username: document.getElementById("username").value,
				firstName: document.getElementById("firstName").value,
				lastName: document.getElementById("lastName").value,
				email: document.getElementById("email").value,
				phone: document.getElementById("phone").value,
				password: document.getElementById("password").value,
				villId: document.getElementById("villId").value,
				userRoles: []
		}
		var selObj = document.getElementById('roles');
		for (i = 0; i < selObj.options.length; i++) {
			if (selObj.options[i].selected) {
				user.userRoles.push({user: document.getElementById("user_id").value, role: selObj.options[i].value })
			}
		}
		bootbox.confirm({
			message: "Are you sure to remove this User? It can't be undone.",
			buttons: {
				cancel: {
					label: '<i class="fa fa-times"></i> Cancel'
				},
				confirm: {
					label: '<i class="fa fa-check"></i> Confirm'
				}
			},
			callback: function(confirmed) {
				if (confirmed) {
					debugger;
					$.ajax({
						type: 'POST',
						url: path,
						data: JSON.stringify(user),
						contentType: "application/json",
						success: function(res) {
							console.log(res);
							location.reload()
						},
						error: function(res) {
							console.log(res);
							location.reload();
						}
					});
				}
			}
		});
	});

	$('#deleteSelected').click(function() {
		var idList = $('.checkboxBook');
		var Users = [];
		for (var i = 0; i < idList.length; i++) {
			if (idList[i].checked == true) {
				Users.push(idList[i]['id'])
			}
		}

		console.log(Users);

		/*<![CDATA[*/
		var path = /*[[@{/}]]*/'DeleteUsers';
		/*]]>*/

		bootbox.confirm({
			message: "Are you sure to remove all selected User? It can't be undone.",
			buttons: {
				cancel: {
					label: '<i class="fa fa-times"></i> Cancel'
				},
				confirm: {
					label: '<i class="fa fa-check"></i> Confirm'
				}
			},
			callback: function(confirmed) {
				if (confirmed) {
					$.ajax({
						type: 'POST',
						url: path,
						data: JSON.stringify(Users),
						contentType: "application/json",
						success: function(res) {
							console.log(res);
							location.reload()
						},
						error: function(res) {
							console.log(res);
							location.reload();
						}
					});
				}
			}
		});
	});

	$("#selectAllBooks").click(function() {
		if ($(this).prop("checked") == true) {
			$(".checkboxBook").prop("checked", true);
		} else if ($(this).prop("checked") == false) {
			$(".checkboxBook").prop("checked", false);
		}
	})
});
