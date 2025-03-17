@param gg.jte.Content header = null
@param gg.jte.Content content
@param gg.jte.Content footer = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Hexlet Javalin Example</title>
    </head>
    <body>
        @if (header != null)
            <header class="text-center text-lg-start bg-light text-muted">
                <div class="text-left p-4" style="background-color: rgba(0, 0, 0, 0.05);">
                    ${header}
                </div>
            </header>
        @endif

        ${content}

        @if (footer != null)
            <footer class="text-center text-lg-start bg-light text-muted">
                <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.05);">
                    ${footer}
                </div>
            </footer>
        @endif
    </body>
</html>