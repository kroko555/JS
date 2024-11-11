$(async function() {
    await allUsers();
});
const table = $('#tbodyAllUserTable');
async function allUsers() {
    table.empty()
    fetch("/api/users")
        .then(res => res.json())
        .then(data => {
            data.forEach(user => {
                let tableWithUsers = `$(
                        <tr>
                            <td>${user.name}</td>
                            <td>${user.country}</td>
                            <td>${user.age}</td>
                            <td>${user.id}</td>                                               
                            <td>${user.roles.map(role => " " + role.roleName)}</td>
                            <td>
                                <button type="button" class="btn btn-info" data-toggle="modal" id="buttonEdit"
                                data-action="edit" data-id="${user.id}" data-target="#edit">Edit</button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger" data-toggle="modal" id="buttonDelete"
                                data-action="delete" data-id="${user.id}" data-target="#delete">Delete</button>
                            </td>
                        </tr>)`;
                table.append(tableWithUsers);
            })
        })
}