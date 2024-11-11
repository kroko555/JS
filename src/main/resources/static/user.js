$(async function() {
    await thisUser();
});
async function thisUser() {
    fetch("http://localhost:8080/api/viewUser")
        .then(res => res.json())
        .then(data => {
            // Добавляем информацию в шапку
            $('#headerUsername').append(data.username);
            let roles = data.roles.map(role => " " + role.roleName.substring(5));
            $('#headerRoles').append(roles);

            //Добавляем информацию в таблицу
            let user = `$(
            <tr>
                <td>${data.id}</td>
                <td>${data.name}</td>
                <td>${data.age}</td>
                <td>${data.country}</td>
                <td>${data.roles}</td>)`;
            $('#userPanelBody').append(user);
        })
}