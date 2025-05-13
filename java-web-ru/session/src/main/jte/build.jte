@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <header>
            <!-- header content goes here -->
            @if(page.getError() != null )
                <p>Wrong username or password.</p>
            @endif
        </header>
        <main>
            <form action="${NamedRoutes.loginPath()}" method="post">
                <input type="text" placeholder="Nickname" name="name"/>
                <input type="password" placeholder="Password" name="password"/>
                <input type="submit"/>
            </form>
        </main>
    </div>
`)