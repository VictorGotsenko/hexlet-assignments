@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
header =@`<p>
            <a href="/">Main</a>
        </p>` ,
content = @`<h2>Users</h2>
        @if(page.getUsers().isEmpty())
            <p>Nothing users</p>
        @else
            <table style="border: 1px solid rgb(0, 0, 0);">
              <thead>
                <tr>
                  <th style="border: 1px solid rgb(0, 0, 0);"> User ID </th>
                  <th style="border: 1px solid rgb(0, 0, 0);"> Firstname </th>
                  <th style="border: 1px solid rgb(0, 0, 0);"> Lastname </th>
                  <th style="border: 1px solid rgb(0, 0, 0);"> Email </th>
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
        @endif` ,
footer = @`<p>Thanks for visiting, come again soon!</p>`)