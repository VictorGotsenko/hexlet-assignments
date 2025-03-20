@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(content = @`
     <h2>Search users</h2>
<form action="/users" method="get">
    <input type="search" required name="term" value="${page.getTerm()}">
    <input type="submit" value="Search">
</form>
     <table style="border: 1px solid rgb(0, 0, 0);">
        <thead>
        <tr>
            <th style="border: 1px solid rgb(0, 0, 0);"> User ID</th>
            <th style="border: 1px solid rgb(0, 0, 0);"> Firstname</th>
            <th style="border: 1px solid rgb(0, 0, 0);"> Lastname</th>
            <th style="border: 1px solid rgb(0, 0, 0);"> Email</th>
        </tr>
        </thead>
        <tbody>

        @for(var user : page.getUsers())
            <tr>
                <td style="border: 1px solid rgb(0, 0, 0);"><a href="/users/${user.getId()}"> ${user.getId()} </a></td>
                <td style="border: 1px solid rgb(0, 0, 0);"> ${user.getFirstName()} </td>
                <td style="border: 1px solid rgb(0, 0, 0);"> ${user.getLastName()}</td>
                <td style="border: 1px solid rgb(0, 0, 0);"> ${user.getEmail()} </td>
            </tr>
        @endfor
        </tbody>
    </table>
 `)