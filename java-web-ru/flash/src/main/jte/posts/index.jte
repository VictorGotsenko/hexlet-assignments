@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage

@param PostsPage page

@template.layout.page(
content = @`
    @if(page.getFlash() != null)
        @if(page.getFlash().equals("Post was successfully created!"))
            <div class="alert alert-success" role="alert">
                ${page.getFlash()}
            </div>
        @endif
    @endif
    <div class="mx-auto p-4 py-md-5">
        <header>
            <!-- header content goes here -->
            <a href="${NamedRoutes.buildPostPath()}">New post</a>
        </header>
    </div>
    <div class="mx-auto p-4 py-md-5">
        <main>

            <div>
                <ul>
                    @if(page.getPosts().isEmpty())
                        <div class="alert alert-primary" role="alert">
                            No post have been added yet
                        </div>
                    @else
                        @for(var post : page.getPosts())
                            <li>
                                <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                            </li>
                        @endfor
                    @endif
                </ul>
            </div>
            <!--    <div> -->
            <!--            @if(page.getPage() != 1) -->
            <!--             <a href="${NamedRoutes.postsPath() + "?page=" + (page.getPage() - 1)}">Назад</a>-->
            <!--         @endif -->
            <!--      ${page.getPage()} -->
            <!--      @if(!page.getPosts().isEmpty()) -->
            <!--          <a href="${NamedRoutes.postsPath() + "?page=" + (page.getPage() + 1)}">Вперёд</a> -->
            <!--      @endif -->
            <!--  </div>  -->
        </main>
    </div>
`)