@import gg.jte.Content

@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<header class="d-flex justify-content-center py-3 m-4">
    <ul class="nav nav-pills">
        <li class="nav-item">
            <a class="nav-link" href="/" >Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/users">Users</a>
        </li>
    </ul>
</header>
<body class="m-4">
    <div>
        ${content}
    </div>
</body>
<footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top m-4">
    <p class="text-muted">
        Footer needs to be here!
    </p>
</footer>
</html>
