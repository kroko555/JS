$('#edit').on('show.bs.modal', ev => {
    let button = $(ev.relatedTarget);
    let id = button.data('id');
    showEditModal(id);
})

async function showEditModal(id) {
    $('#rolesEditUser').empty();
    let user = await getUser(id);
    let form = document.forms["formEditUser"];
    form.id.value = user.id;
    form.username.value = user.username;
    form.name.value = user.name;
    form.country.value = user.country;
    form.age.value = user.age;
    form.password.value = user.password;



    await fetch("http://localhost:8080/api/roles")
        .then(res => res.json())
        .then(roles => {
            roles.forEach(role => {
                let selectedRole = false;
                for (let i = 0; i < user.roles.length; i++) {
                    if (user.roles[i].roleName === role.roleName) {
                        selectedRole = true;
                        break;
                    }
                }
                let el = document.createElement("option");
                el.text = role.roleName.substring(5);
                el.value = role.id;
                if (selectedRole) el.selected = true;
                $('#rolesEditUser')[0].appendChild(el);
            })
        })
}