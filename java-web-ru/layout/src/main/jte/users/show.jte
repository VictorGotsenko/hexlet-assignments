@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    header =@`<a href="/">Main</a>
              <a href="/users">Users</a>`,
content =@`<h2>About user ${page.getUser().getFirstName()}</h2>
      <table style="border: 1px solid rgb(0, 0, 0);">
        <thead>
          <tr>
            <th style="border: 1px solid rgb(0, 0, 0);">User ID</th>
            <th style="border: 1px solid rgb(0, 0, 0);">Firstname</th>
            <th style="border: 1px solid rgb(0, 0, 0);">Lastname</th>
            <th style="border: 1px solid rgb(0, 0, 0);">Email</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td style="border: 1px solid rgb(0, 0, 0);">${page.getUser().getId()}</td>
            <td style="border: 1px solid rgb(0, 0, 0);">${page.getUser().getFirstName()}</td>
            <td style="border: 1px solid rgb(0, 0, 0);">${page.getUser().getLastName()}</td>
            <td style="border: 1px solid rgb(0, 0, 0);">${page.getUser().getEmail()}</td>
          </tr>
        </tbody>
      </table>` ,
footer=@`<p>Thanks for visiting, come again soon!</p>`)